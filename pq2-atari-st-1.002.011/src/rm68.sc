;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm68 0
)

(synonyms
	(box compartment)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm68 of Rm
	(properties
		picture 93
		style 3
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (init)
		(= global212 3)
		(= global211 1)
		(HandsOff)
		(User canInput: 1 canControl: 1)
		(self setLocales: 153)
		(Load rsVIEW 257)
		(Load rsVIEW 75)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(super init:)
		(self setScript: rm68Script)
		((gInventory at: 34) moveTo: gCurRoomNum) ; car_registration
	)
)

(instance rm68Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local0 (Prop new:))
					view: 75
					loop: 7
					cel: 0
					posn: 148 38
					setPri: 0
					setCycle: Fwd
					init:
				)
			)
			(1
				((= local1 (View new:))
					view: 257
					loop: 0
					cel: 0
					posn: 270 145
					setPri: 10
					init:
					ignoreActors:
					stopUpd:
				)
				((= local2 (Prop new:))
					view: 257
					setLoop: 1
					setCel: 0
					posn: 266 137
					setPri: 13
					init:
					stopUpd:
					ignoreActors:
				)
				((= local3 (View new:))
					view: 257
					loop: 0
					cel: 2
					posn: 266 128
					setPri: 11
					init:
					ignoreActors:
					stopUpd:
				)
				(if (== (gEgo has: 21) 0) ; empty_holster
					((= local4 (View new:))
						view: 257
						loop: 0
						cel: 1
						posn: 257 128
						setPri: 11
						init:
						stopUpd:
						ignoreActors:
					)
				)
				(if (== (gEgo has: 20) 0) ; bullets
					((= local5 (View new:))
						view: 257
						loop: 0
						cel: 3
						posn: 259 128
						setPri: 12
						init:
						stopUpd:
						ignoreActors:
					)
				)
				(self cue:)
			)
			(2
				(local2 startUpd: setCycle: End)
				(= local8 1)
			)
			(3
				(local2 setCycle: Beg self)
				(= local8 0)
			)
			(4
				(local1 dispose:)
				(local2 dispose:)
				(local3 dispose:)
				(if (== (gEgo has: 20) 0) ; bullets
					(local5 dispose:)
				)
				(if (== (gEgo has: 21) 0) ; empty_holster
					(local4 dispose:)
				)
			)
			(5
				(gCurRoom newRoom: 67)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((Said 'look/box')
				(if (== local8 1)
					(gInventory
						carrying: {In the glove compartment, you see:}
						empty:
							{Other than the car's registration, the glove compartment is empty.}
						showSelf: 68
					)
				else
					(Print 68 0) ; "The glove box isn't open."
				)
			)
			((Said 'get,read,look/registration,newspaper,card[<registration]')
				(if (== local8 1)
					(local3 setPri: 1)
					(Print 68 1 #draw) ; "You look at the registration ... After confirming the name, "Luis Pate", you return it to the glove box."
					(local3 setPri: 11)
				else
					(Print 68 2) ; "You don't see it."
				)
			)
			((Said 'get,look/ammo,ammo,bullet')
				(cond
					((gEgo has: 20) ; bullets
						((gInventory at: 20) showSelf:) ; bullets
					)
					((not local8)
						(Print 68 3) ; "You don't see them."
					)
					((IsItemAt 20) ; bullets
						(local5 dispose:)
						(Print 68 4 #draw) ; "Looking the ammunition over, you think... "Hmmm, three rounds of .38 caliber. Better hang on to this for evidence.""
						(SetScore 1)
						(gEgo get: 20) ; bullets
					)
					(else
						(Print 68 5) ; "There are no bullets here."
					)
				)
			)
			((Said 'get,look/gunbelt')
				(cond
					((gEgo has: 21) ; empty_holster
						((gInventory at: 21) showSelf:) ; empty_holster
					)
					((not local8)
						(Print 68 2) ; "You don't see it."
					)
					((IsItemAt 21) ; empty_holster
						(local4 dispose:)
						(Print 68 6 #draw) ; "You look at the empty holster and ponder the whereabouts of the gun. You retain it for evidence."
						(SetScore 1)
						(gEgo get: 21) ; empty_holster
						(SetFlag 50)
					)
					(else
						(Print 68 7) ; "There is no holster here."
					)
				)
			)
			(
				(and
					(Said 'frisk,look>')
					(or
						(Said '<below/bench')
						(Said '<back/bench')
						(Said '<below/dash')
						(Said '/ashtray,auto,console,visor,dash,floor')
					)
				)
				(Print 68 8) ; "You search diligently, finding nothing."
			)
			((Said 'open/box,box')
				(if (== local8 0)
					(= local8 1)
					(Print 68 9) ; "OK."
					(SetFlag 41)
					(rm68Script changeState: 1)
				else
					(Print 68 10) ; "The glove box is already open."
				)
			)
			((Said 'close/box,box')
				(if (== local8 1)
					(= local8 0)
					(rm68Script changeState: 3)
				else
					(Print 68 0) ; "The glove box isn't open."
				)
			)
			((or (Said 'exit,exit[/auto]') (Said 'close/door'))
				(rm68Script changeState: 5)
			)
			(
				(or
					(Said 'drop,use,apply/powder/box,box')
					(Said 'dust,powder/box,box')
				)
				(cond
					((not (gEgo has: 10)) ; field_kit
						(Print 68 11) ; "You'll need your field kit."
					)
					(local7
						(Print 68 12) ; "You already did."
						(= local6 2)
						(= local7 1)
					)
					(else
						(global122 setPri: 0)
						(global120 setPri: 0)
						(if (IsFlag 41)
							(Print 68 13 #draw) ; "Carefully, you apply the dust and... Mumbling to yourself... "This print is too smudged to take.""
							(= local6 1)
						else
							(Print 68 14 #draw) ; "Carefully, you apply the dust and ... Mumbling to yourself ... "Here's one worth taking!""
							(= local7 1)
							(= local6 2)
						)
						(global122 setPri: 15)
						(global120 setPri: 14)
					)
				)
			)
			(
				(or
					(Said 'dust,powder/pane,door,wheel,bench,mirror,handle')
					(Said
						'apply,use,drop/powder/pane,door,wheel,bench,mirror,handle'
					)
				)
				(if (not (gEgo has: 10)) ; field_kit
					(Print 68 11) ; "You'll need your field kit."
				else
					(global122 setPri: 0)
					(global120 setPri: 0)
					(Print 68 15 #draw) ; "Carefully, you apply the fingerprint powder ... you examine the powder and think to yourself... "Not worth processing.""
					(global122 setPri: 15)
					(global120 setPri: 14)
					(= local6 1)
				)
			)
			((Said 'drop,apply,use,hoist/print,tape')
				(cond
					((not (gEgo has: 10)) ; field_kit
						(Print 68 11) ; "You'll need your field kit."
					)
					((not local6)
						(Print 68 16) ; "Don't you know the correct way to get fingerprints?"
					)
					((== local6 1)
						(Print 68 17) ; "It isn't worth taking."
					)
					((gEgo has: 22) ; fingerprint
						(Print 68 18) ; "You've already gotten enough fingerprints."
					)
					(else
						(global123 setPri: 0)
						(Print 68 19 #draw) ; "Using the tape, you carefully "lift" the print."
						(SetScore 3)
						(global123 setPri: 15)
						(gEgo get: 22) ; fingerprint
						(= local6 0)
					)
				)
			)
			((Said '(drop,place)/*/box,box')
				(cond
					((and (Said '/bullet,ammo/*') (gEgo has: 20)) ; bullets
						(Print 68 20) ; "You will need the bullets for evidence."
					)
					((and (Said '/gunbelt/*') (gEgo has: 21)) ; empty_holster
						(Print 68 21) ; "You will need the holster for evidence."
					)
					(else
						(event claimed: 1)
						(Print 68 22) ; "You have no reason to do that."
					)
				)
			)
		)
	)
)

