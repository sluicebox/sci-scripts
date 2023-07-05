;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 503)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	beachReg 0
)

(synonyms
	(ocean seawater ocean)
)

(local
	[local0 7]
	local7
	local8
)

(instance beachReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsVIEW 21)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<in,under/ocean,water')
							(if (!= (gEgo view:) 2)
								(Print 503 0) ; "You look under the water, and see nothing but...more water!"
							else
								(Print 503 1) ; "You're not in the water."
							)
						)
						((Said '/ocean,water')
							(Print 503 2) ; "The wide, blue ocean disappears into the horizon to the west."
						)
						((Said '/fish')
							(if (gEgo has: 24) ; Dead_Fish
								((Inv at: 24) showSelf:) ; Dead_Fish
							else
								(Print 503 3) ; "You don't see any fish right now."
							)
						)
						((Said '/beach')
							(Print 503 4) ; "The blue water of the ocean washes serenely over the pretty sand beach."
						)
						((or (Said '/sky') (Said '<up'))
							(if (not gNight)
								(Print 503 5) ; "The bright, blue sky seems to merge as one with the vast ocean before you."
							else
								(Print 503 6) ; "It's easy to see by the light of a full moon."
							)
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 503 7) ; "You see nothing but sandy soil."
						)
						((Said '/boulder')
							(Print 503 8) ; "There are not many rocks here."
						)
						((Said '/forest')
							(Print 503 9) ; "You see very few trees."
						)
						((Said '/grass')
							(Print 503 10) ; "From the beach, a beautiful meadow stretches to the east."
						)
						((Said '/bush')
							(Print 503 11) ; "Low-lying shrubs dot the meadowland to the east."
						)
						((Said '/flora,blossom')
							(Print 503 12) ; "Beautiful wildflowers adorn the green meadowland to the east."
						)
					)
				)
				((Said 'get/flora,blossom')
					(Print 503 13) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'get/water')
					(Print 503 14) ; "You have no reason to carry water."
				)
				((or (Said 'drink') (Said 'get/drink'))
					(cond
						((!= (gEgo view:) 2)
							(Print 503 15) ; "You taste the ocean water. YUCK!! This water's too salty!"
						)
						(
							(or
								(& (= local7 (NearControl gEgo 12)) $0008)
								(& local7 $0800)
								(& local7 $0002)
								(& local7 $0200)
							)
							(= global164 (gEgo script:))
							(gEgo setScript: drinking)
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said 'bathe,dive,wade[<enter][/ocean]>')
					(cond
						((!= global105 4)
							(Print 503 16) ; "Just enter the water."
						)
						((Said '<under')
							(Print 503 17) ; "The water is much too deep here."
						)
						(else
							(Print 503 18) ; "You are already swimming."
						)
					)
					(event claimed: 1)
				)
				((or (Said 'capture,get/fish') (Said 'fish[<enter]'))
					(cond
						((== global105 4)
							(Print 503 19) ; "You cannot catch fish while swimming."
						)
						((gEgo has: 17) ; Fishing_Pole
							(Print 503 20) ; "This would not be a good spot to fish."
						)
						(else
							(Print 503 21) ; "You have no way of catching any fish."
						)
					)
				)
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global204 1)
				(HandsOff)
				(= local8 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 cel: 0 setCycle: End self)
			)
			(1
				(Timer setReal: self 5)
				(= global120 (Print 503 22 #at -1 20 #dispose)) ; "YUCK!! This water's too salty!"
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global204 0)
				(gEgo view: 2 setCycle: Walk)
				(gEgo script: global164 viewer: local8)
				(HandsOn)
			)
		)
	)
)

