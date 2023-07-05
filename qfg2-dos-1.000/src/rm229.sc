;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 229)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Stage)
(use TargActor)
(use Interface)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm229 0
)

(local
	seeDoor
)

(procedure (VoicesPrint &tmp aT aR aL)
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

(instance rm229 of Stage
	(properties
		picture 700
		style 9
		south 704
		bottomFromX 158
		bottomFromY 192
		bottomToX 158
		bottomToY 147
	)

	(method (init &tmp [str 20])
		(LoadMany rsVIEW 0 22 700 183 703)
		(Load rsSOUND 16)
		(NormalEgo)
		(gEgo init: illegalBits: -384)
		(super init: &rest)
		(InitAddToPics wallLeft wallRight)
		(= saveIllegal -384)
		(door init:)
		(if (OneOf gPrevRoomNum 210 215 220)
			(gEgo posn: 158 100 hide:)
			(SetFlag 2)
			(self setScript: zapInScript)
		)
		(= gSpellChecker gAllChecker)
	)

	(method (doit)
		(if (and (== inOut 3) (>= (gEgo y:) 192))
			(= edgeHit 3)
		)
		(super doit:)
	)

	(method (dispose)
		(= gRoomExitDir 2)
		(door dispose:)
		(super dispose:)
	)

	(method (handleEvent event &tmp aSpell)
		(cond
			((super handleEvent: event))
			((Said '/door')
				(if seeDoor
					(Print 229 0) ; "Your Detect Magic spell has revealed what appears to be a magical door at the end of the hallway. Or is it just an illusion?"
				else
					(Print 229 1) ; "You don't detect any doors here at the moment."
				)
			)
		)
	)
)

(instance showDoorS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door loop: 0 cel: 0 setCycle: ForwardCounter 3 self)
			)
			(1
				(door loop: 1 setCycle: End self)
				(= cycles 12)
			)
			(2
				(if (not seeDoor)
					(Print 229 2) ; "A door appears."
					(= seeDoor 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance goInsideS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not seeDoor)
					(door setLoop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(door loop: 2 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(2
				(gEgo
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setMotion: MoveTo 158 77 self
				)
			)
			(3
				(sparkle cel: 0 posn: 158 60 init: setCycle: CT 2 1 self)
			)
			(4
				(gEgo hide:)
				(sparkle setCycle: End self)
			)
			(5
				(= gRoomExitDir 1)
				(SetFlag 28)
				(ClearFlag 2)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance flashDoorS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (door loop:))
				(door loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(if register
					(door cel: 2)
				)
				(door loop: register)
				(if register
					(RedrawCast)
					(Print 229 3) ; "That didn't have any effect on the door."
				else
					(door cel: 0)
					(RedrawCast)
					(Print 229 4) ; "The wall seemed to absorb your spell's energies."
				)
				(self dispose:)
			)
		)
	)
)

(instance zapInScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn 1)
				(HandsOff)
				(gCSound stop:)
				(sparkle init: cel: 0 posn: 158 80 setCycle: CT 2 1 self)
			)
			(1
				(gEgo show:)
				(if (= register (!= gPrevRoomNum 220))
					(gEgo loop: 3)
				else
					(gEgo view: 22 loop: 0 cel: 2 setCycle: CT 6 1)
					(UseStamina 10)
				)
				(sparkle setCycle: End self)
			)
			(2
				(sparkle dispose:)
				(if register
					(gEgo view: 22 loop: 0 setCycle: CT 6 1 self)
				else
					(self cue:)
				)
			)
			(3
				(gSpareSound number: 16 loop: 1 play:)
				(= cycles 10)
			)
			(4
				(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(5
				(NormalEgo)
				(gEgo loop: 3 illegalBits: -384)
				(= cycles 2)
			)
			(6
				(if (and (== gPrevRoomNum 220) (not (IsFlag 65)))
					(HighPrint 229 5) ; "You hear the voices."
					(if (IsFlag 162)
						(VoicesPrint 229 6) ; "Our time is much too valuable to be wasted upon one with so little magic. Do not bother returning until you have acquired more power."
					else
						(VoicesPrint 229 7) ; "You will certainly have to be more clever and more skilled if you hope to be initiated. Perhaps you should practice your spells more."
					)
				)
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
		x 160
		y 77
		view 703
		signal 16384
		illegalBits 0
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(if (OneOf (whatHurt type:) 25 27)
			(self setScript: flashDoorS)
			(return 1)
		else
			(return 0)
		)
	)

	(method (detectMe)
		(self setScript: showDoorS)
		(return 1)
	)

	(method (openMe)
		(if (IsFlag 65)
			(Print 229 8) ; "Nothing happens."
			(return 0)
		else
			(self setScript: goInsideS)
			(return 1)
		)
	)

	(method (isNotHidden)
		(return 1)
	)
)

(instance sparkle of Prop
	(properties
		view 183
		priority 15
		signal 16400
	)
)

