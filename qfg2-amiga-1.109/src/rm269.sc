;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 269)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Stage)
(use TargActor)
(use Interface)
(use LoadMany)
(use Motion)
(use Actor)

(public
	rm269 0
)

(procedure (VoicesPrint &tmp aT aR aL) ; UNUSED
	(= aR (BotWindow brRight:))
	(= aL (BotWindow brLeft:))
	(BotWindow color: 15 back: 8)
	(Print
		&rest
		#font
		gUserFont
		#title
		{Voices:}
		#window
		BotWindow
		#width
		(- aR (+ aL 16))
	)
)

(instance rm269 of Stage
	(properties
		picture 700
		style 9
		south 704
		bottomFromX 158
		bottomFromY 179
		bottomExit 4
		bottomToX 158
		bottomToY 147
	)

	(method (init)
		(LoadMany rsVIEW 0 700 705)
		(gEgo init:)
		(NormalEgo)
		(super init:)
		(door init:)
		(lamp init: setCycle: Fwd)
		(if (== gPrevRoomNum 260)
			(= inOut 3)
			(self setScript: exitHouseS)
		)
		(InitAddToPics wallLeft wallRight)
		(= gSpellChecker gAllChecker)
	)

	(method (cue)
		(super cue: &rest)
		(gEgo illegalBits: $fe80)
	)

	(method (doit)
		(if (and (== inOut 3) (>= (gEgo y:) 179))
			(= edgeHit 3)
		)
		(super doit:)
	)

	(method (dispose)
		(= gRoomExitDir 1)
		(super dispose:)
	)

	(method (handleEvent event &tmp aSpell)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(cond
					((not (CanPickLocks 1)))
					((not (gEgo inRect: 185 136 220 166))
						(Print 269 0) ; "You aren't close enough."
					)
					((PickLock 70 1 1)
						(self setScript: openDoorS)
					)
				)
			)
			((Said '/door')
				(Print 269 1) ; "Just what do you want to do with the door?"
			)
		)
	)
)

(instance openDoorS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setLoop: 7 cel: 0 setCycle: End)
				(= cycles 10)
			)
			(1
				(door stopUpd:)
				(gEgo
					setPri: 10
					illegalBits: 0
					setMotion: MoveTo 210 150 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 243 150 self)
			)
			(3
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance exitHouseS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo illegalBits: $fe80)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setLoop: 7 cel: 2 setCycle: Beg)
				(gEgo posn: 213 150 loop: 1 setMotion: MoveTo 194 150 self)
			)
			(1
				(door stopUpd:)
				(NormalEgo)
				(gEgo illegalBits: $fe80)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wallLeft of PicView
	(properties
		x 160
		y 79
		view 700
		loop 2
		cel 3
		signal 16384
	)
)

(instance wallRight of PicView
	(properties
		x 160
		y 79
		view 700
		loop 3
		cel 3
		signal 16384
	)
)

(instance door of TargActor
	(properties
		x 220
		y 160
		noun '/door'
		description {door}
		sightAngle 135
		closeRangeDist 60
		longRangeDist 400
		shiftClick 1
		contClick 7
		view 701
		loop 1
		cel 1
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (openMe)
		(self setScript: openDoorS)
		(return 1)
	)

	(method (doVerb theVerb)
		(if (or (< argc 2) (self passedChecks: theVerb))
			(switch theVerb
				(1
					(Print 269 2) ; "It is a locked door."
				)
				(7
					(Print 269 3) ; "The door is solidly mounted upon its hinges."
				)
				(2
					(Print 269 4) ; "The door is locked."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance lamp of Prop
	(properties
		x 208
		y 131
		z 66
		noun '/lamp'
		description {lamp}
		sightAngle 135
		closeRangeDist 50
		longRangeDist 400
		shiftClick 1
		contClick 7
		view 705
		loop 7
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(if (or (< argc 2) (self passedChecks: theVerb))
			(switch theVerb
				(1
					(Print 269 5) ; "The lamp burns brightly, lighting this otherwise darkened dead-end."
				)
				(7
					(Print 269 6) ; "The simple lamp is not worth your while."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

