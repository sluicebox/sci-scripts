;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm131 0
)

(local
	aBoat0
	aBoat1
	aBoat2
	aBoat3
	aBoat4
	aBoat5
	aEgoBoat
)

(instance rm131 of Rm
	(properties
		picture 31
		horizon 5
	)

	(method (init)
		(Load rsVIEW 300)
		(Load rsVIEW 301)
		(super init:)
		((View new:)
			view: 300
			loop: 0
			priority: 15
			posn: 216 44
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 300
			loop: 4
			priority: 15
			posn: 99 22
			ignoreActors:
			addToPic:
		)
		((= aBoat0 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 159 75
			cycleSpeed: 5
			init:
		)
		((= aBoat1 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 199 75
			cycleSpeed: 5
			init:
		)
		((= aBoat2 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 217 75
			cycleSpeed: 5
			init:
		)
		((= aBoat3 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 234 75
			cycleSpeed: 5
			init:
		)
		((= aBoat4 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 251 75
			cycleSpeed: 5
			init:
		)
		((= aBoat5 (Prop new:))
			view: 301
			setLoop: 0
			setPri: 14
			posn: 268 75
			cycleSpeed: 5
			init:
		)
		((= aEgoBoat (Act new:))
			view: 301
			setLoop: 2
			setPri: 14
			setCycle: Fwd
			illegalBits: 0
			posn: 160 1132
			setStep: 1 1
			cycleSpeed: 1
			moveSpeed: 1
			init:
		)
		(gEgo posn: 123 999)
		(HandsOff)
		(= gCurrentStatus 21)
		(self setRegions: 300 setScript: rm131Script) ; rm300
	)
)

(instance rm131Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (gEgo has: 14) (Said '(drop<on),apply,wear/wig')) ; Wig
			(Print 131 0) ; "Good idea. This would be a perfect time!"
			(if (not gWearingWig)
				(gGame changeScore: 5)
				(= gWearingWig 1)
			)
		)
		(if
			(and
				(gEgo has: 13) ; Spinach_Dip
				(or
					(Said '/bread<(overboard,(board<over))')
					(Said 'drop,drop,throw,shit/bread')
				)
			)
			(gGame changeScore: 2)
			(Print 131 1) ; "A good idea."
			(Print 131 2) ; "You toss the spinach dip as far over the ocean as you can."
			(Print 131 3 #at -1 152) ; "(Which is not really that far.)"
			(gEgo put: 13 -1) ; Spinach_Dip
		)
		(if (Said 'look>')
			(if (Said '/craft')
				(Print 131 4) ; "It's getting smaller!"
			)
			(if (Said '[/boat,airport]')
				(Print 131 5) ; "This is not what you were expecting from a deluxe cruise!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(Print 131 6) ; "The lifeboat drill has brought the ship to a standstill. What have you done, Larry?"
				(= seconds 5)
			)
			(2
				(Print 131 7) ; "A siren wails a warning cry, and the lifeboat begins to shake. You made it to the lifeboat in the nick of time!"
				(gGame changeScore: 5)
				(= seconds 3)
			)
			(3
				(aBoat0 setCycle: End self)
				(aBoat1 setCycle: End)
				(aBoat2 setCycle: End)
				(aBoat3 setCycle: End)
				(aBoat4 setCycle: End)
				(aBoat5 setCycle: End)
			)
			(4
				(aBoat1 stopUpd:)
				(aBoat2 stopUpd:)
				(aBoat3 stopUpd:)
				(aBoat4 stopUpd:)
				(aBoat5 stopUpd:)
				(aBoat0 setLoop: 1 stopUpd:)
				(User canControl: 0 canInput: 1)
				(aEgoBoat posn: 160 132 setMotion: MoveTo 123 146 self)
			)
			(5
				(Print 131 8) ; "Slowly, you drift away from the cruise ship. You wonder what you forgot to pack."
				(aEgoBoat setMotion: MoveTo -12 201 self)
				(User canInput: 1)
			)
			(6
				(gCurRoom newRoom: 138)
			)
		)
	)
)

