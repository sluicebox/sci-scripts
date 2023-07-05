;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 656)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	cdIntro7 0
)

(instance cdIntro7 of Rm
	(properties
		picture 73
		style 10
	)

	(method (init)
		(self setScript: egoFlyingScript setRegions: 769) ; introtoonRegion
		(User canInput: 0 controls: 0)
		(Load rsPIC 73)
		(syncIt init: hide: play: 10111 658)
		(super init:)
		(UnLoad 129 68)
		(Load rsPIC 74)
		(LoadMany rsVIEW 750 760 751)
		(gEgo
			view: 750
			setLoop: 3
			posn: 292 210
			setStep: 3 2
			normal: 0
			init:
		)
		((gEgo head:) hide:)
		(myWater init: setCycle: Fwd)
		(owl init: setStep: 1 1 posn: 207 211)
	)

	(method (newRoom newRoomNumber)
		(gEgo setStep: -1 -1)
		(super newRoom: newRoomNumber)
	)
)

(instance owlFlyingScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(owl
					setLoop: 6
					cycleSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 184 70 self
				)
			)
			(2
				(owl setCycle: End self)
			)
			(3
				(owl setLoop: 7 setCycle: End self setMotion: MoveTo 140 70)
			)
			(4
				(client setScript: 0)
			)
		)
	)
)

(instance owl of Actor
	(properties
		view 760
	)
)

(instance egoFlyingScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setScript: owlFlyingScript)
				(if (== gHowFast 2)
					(= seconds 7)
				else
					(= seconds 5)
				)
			)
			(1
				(gEgo setCycle: Fwd setMotion: MoveTo 280 176 self)
			)
			(2
				(gEgo
					setCel: 0
					setCycle: Fwd
					setLoop: 4
					setMotion: MoveTo 210 80 self
				)
			)
			(3
				(gEgo
					setCel: 0
					setLoop: 5
					setMotion: MoveTo 140 70
					setCycle: End self
				)
			)
			(4
				(= waitForCue 16644)
			)
			(5
				(gEgo setMotion: 0 hide:)
				(owl hide:)
				(myWater hide:)
				(= cycles 1)
			)
			(6
				(client setScript: a2s2Script)
			)
		)
	)
)

(instance a2s2Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 74 10)
				((gEgo head:) hide:)
				(owl
					show:
					view: 760
					signal: 16384
					cycleSpeed: 2
					illegalBits: 0
					setLoop: 8
					setCycle: Fwd
					posn: 247 207
				)
				(gEgo
					view: 750
					setLoop: 6
					normal: 0
					posn: 163 224
					cycleSpeed: 2
					setCycle: Fwd
					show:
				)
				(= waitForCue 16724)
			)
			(1
				(owl setScript: owlFlying)
				(= seconds 5)
			)
			(2
				(gEgo setCycle: Fwd setMotion: MoveTo 143 85)
				(= waitForCue 17668)
			)
			(3
				(gEgo
					setLoop: 7
					moveSpeed: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(4
				(gEgo setLoop: 8 setMotion: MoveTo 138 88 setCycle: End self)
			)
			(5
				(gEgo setMotion: 0)
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(gCurRoom newRoom: 658) ; cdIntro9
			)
		)
	)
)

(instance owlFlying of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setMotion: MoveTo 254 90)
				(= waitForCue 16900)
			)
			(1
				(owl setCycle: End self)
			)
			(2
				(owl setLoop: 9 setCycle: End self)
			)
			(3
				(owl setLoop: 10 moveSpeed: 1 setCycle: Fwd)
				(= waitForCue 17156)
			)
			(4
				(cls)
				(owl setCycle: End self)
			)
			(5
				(owl setLoop: 11 setCycle: End self)
			)
			(6
				(owl
					setLoop: 12
					moveSpeed: 0
					setMotion: MoveTo 133 90
					setCycle: End self
				)
			)
			(7
				(owl setLoop: 13 setCycle: End setMotion: MoveTo 133 90 self)
			)
			(8
				(owl dispose:)
			)
		)
	)
)

(instance myWater of Prop
	(properties
		x 157
		y 148
		view 751
		cycleSpeed 5
	)
)

(instance syncIt of MonoAudioProp
	(properties)
)

