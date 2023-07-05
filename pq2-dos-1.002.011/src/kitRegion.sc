;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)

(public
	kitRegion 0
)

(local
	local0
	local1
)

(instance fKit of View
	(properties
		y 60
		x 81
		view 110
		priority 13
		signal 16657
	)
)

(instance dView of View
	(properties)
)

(instance kitRegion of Locale
	(properties)

	(method (init)
		(super init:)
		(= gFKit fKit)
		(= global117
			(= global118
				(= global119
					(= global120
						(= global121
							(= global122
								(= global123 (= global124 (= global125 dView)))
							)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(fKit dispose:)
		(= global240 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(= local1 (not (gEgo has: 10))) ; field_kit
		(cond
			((Said 'look,open,use/briefcase')
				(if local1
					(Print 153 0) ; "You do not have the field kit."
				else
					(if (!= global240 1)
						(fKit setPri: 13 ignoreActors: stopUpd: init:)
						(= global240 1)
					)
					(Print 153 1 #at 184 1 #draw #mode 1 #width 110) ; "Your Detective's Field Kit is used to carry various things you will need in the course of your investigations:  Plastic Baggie  Small Camera  Casting Plaster  Glass Vial  Eye Dropper  Fingerprint Powder Fingerprint Brush  Fingerprint Tape"
				)
			)
			((Said 'close/briefcase')
				(cond
					(local1
						(Print 153 0) ; "You do not have the field kit."
					)
					((== global240 0)
						(Print 153 2) ; "It's already closed."
					)
					(else
						(fKit dispose:)
						(= global240 0)
					)
				)
			)
			((Said 'look>')
				(cond
					(
						(and
							(not (gEgo has: 10)) ; field_kit
							(Said
								'/baggie,camera,plaster,(vial<glass),dropper,powder,brush,tape'
							)
						)
						(Print 153 3) ; "You don't have the field kit."
					)
					((Said '/baggie')
						(Print 153 4) ; "Hair, dirt, and other items can be placed in the plastic evidence bag."
					)
					((Said '/camera')
						(Print 153 5) ; "The camera is used to preserve crime scenes on film for later analysis."
					)
					((Said '/plaster')
						(Print 153 6) ; "Casting plaster can be used to make casts of foot prints."
					)
					((Said '/vial/[*]')
						(event claimed: 0)
					)
					((or (Said '/vial') (Said '/glass<vial'))
						(Print 153 7) ; "The glass vial is used to hold small samples of blood and other liquids."
					)
					((Said '/dropper')
						(Print 153 8) ; "The eye dropper sucks up the liquid which is to be placed in the vial."
					)
					((Said '/powder')
						(Print 153 9) ; "Fingerprints leave oily residue. The powder clings to this residue."
					)
					((Said '/brush')
						(Print 153 10) ; "The brush is used to dust away excess fingerprint powder."
					)
					((Said '/tape')
						(Print 153 11) ; "Once a good fingerprint is found, the tape is used to pick it up and transfer it to a fingerprint card."
					)
				)
			)
			(
				(or
					(Said 'use,remove/powder,brush')
					(Said 'drop,apply,use/powder,dust')
					(Said 'dust,powder[/*]')
					(Said 'get,remove,hoist/fingerprint,print[<finger]')
				)
				(if local1
					(Print 153 12) ; "You don't have your field kit."
				else
					(Print 153 13 #draw) ; "Carefully, you apply the fingerprint powder and ... "Not worth processing" you think."
				)
			)
			((or (Said 'use,remove/camera') (Said 'get/painting'))
				(if local1
					(Print 153 12) ; "You don't have your field kit."
				else
					(Print 153 14) ; ""Click!" You take a picture, and return the camera to your field kit."
				)
			)
			((Said 'use,remove/tape')
				(Print 153 15) ; "The fingerprint tape is used only after finding a useful print. By picking up the print with the tape, it can be transferred to a card."
			)
			((or (Said 'use,remove/dropper,vial,baggie') (Said 'get/sample'))
				(Print 153 16) ; "There's nothing here worth the trouble."
			)
			((Said 'make,use/plaster,cast,footprint,(print<feet)')
				(Print 153 17) ; "You see nothing worth wasting casting plaster on."
			)
		)
	)
)

