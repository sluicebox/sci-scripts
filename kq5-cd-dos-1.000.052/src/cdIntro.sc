;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	cdIntro 0
)

(local
	local0
	local1
	local2
	local3
)

(instance cdIntro of Rm
	(properties
		picture 68
	)

	(method (init)
		(Load rsPIC 68)
		(super init:)
		(gGame setSpeed: 3 setCursor: gNarrator 1)
		(= global103 1)
		(SetFlag 33 22)
		(gTheIconBar disable:)
		(if (IsFlag 31)
			(UnLoad 129 71)
			(LoadMany rsVIEW 760 750)
			(self setRegions: 769) ; introtoonRegion
			(gEgo
				init:
				signal: 16384
				view: 750
				setLoop: 0
				posn: 46 166
				illegalBits: 0
				setPri: 5
				normal: 0
			)
			((gEgo head:) hide:)
			(introOwl
				init:
				cycleSpeed: 2
				moveSpeed: (gEgo moveSpeed:)
				signal: 16384
				setLoop: 2
			)
			(self setScript: audioTrakScript)
		else
			(Load rsFONT 8)
			(LoadMany rsVIEW 754 755)
			(Load rsSYNC 10101)
			(self setScript: sceneOneScript)
		)
		(Load rsVIEW 2)
		(User canInput: 0 controls: 0)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo moveSpeed: 0)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sceneOneScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aCastle init:)
				((ScriptID 763) doit:) ; cartoonCode
				(gCurRoom setRegions: 769) ; introtoonRegion
				(= cycles 1)
			)
			(1
				(audioTrak init: hide: play: 10101 651)
				(mordack init: hide:)
				(= waitForCue 4096)
			)
			(2
				(= local1 (Display 650 0 dsCOORD 80 100 dsFONT 8 dsCOLOR 0)) ; "CASTLE DAVENTRY"
				(= local0
					(Display 650 0 dsCOORD 79 99 dsFONT 8 dsCOLOR (if global159 7 else 15)) ; "CASTLE DAVENTRY"
				)
				(= cycles 1)
			)
			(3
				(= waitForCue 4352)
			)
			(4
				(DrawPic 68 9 0)
				(= cycles 1)
			)
			(5
				(= waitForCue 4608)
			)
			(6
				(mordack
					show:
					setLoop: 0
					cel: (- (NumCels mordack) 1)
					setCycle: Beg self
				)
			)
			(7
				(= waitForCue 4864)
			)
			(8
				(mordack setLoop: 1 cel: 0 setCycle: End self)
			)
			(9
				(mordack setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 1)
			)
			(10
				(mordack setCycle: Beg self)
			)
			(11
				(lightning
					init:
					setPri: (+ (aCastle priority:) 1)
					setScript: myLightning
					hide:
				)
				(clouds init: setCycle: Fwd)
				(= cycles 1)
			)
			(12
				(= waitForCue 4944)
			)
			(13
				(mordack cel: 0 setCycle: End self)
			)
			(14
				(clouds setCycle: End self)
			)
			(15
				(clouds setLoop: 1 setCycle: Fwd cycleSpeed: 2)
				(= seconds 5)
			)
			(16
				(mordack cel: 0 setCycle: End)
				(clouds cycleSpeed: 1)
				(= seconds 5)
			)
			(17
				(mordack setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 1)
			)
			(18
				(mordack setCycle: Beg)
				(= cycles 1)
			)
			(19
				(= waitForCue 5632)
			)
			(20
				(myLightning dispose:)
				(lightning dispose:)
				(clouds setLoop: 2 setCycle: End self)
			)
			(21
				(aCastle hide:)
				(clouds setLoop: 3 cycleSpeed: 3 setCycle: End)
				(mordack cel: 0 setLoop: 5 setCycle: End self)
			)
			(22
				(clouds dispose:)
				(mordack setCycle: Beg)
				(= cycles 1)
			)
			(23
				(= waitForCue 5888)
			)
			(24
				(mordack setLoop: 0 cel: 0 setCycle: End self)
			)
			(25
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(26
				(gCurRoom newRoom: 651) ; cdIntro2
			)
		)
	)
)

(instance myLightning of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local2
					(0
						(= waitForCue 5120)
					)
					(1
						(= waitForCue 5200)
					)
					(2
						(= waitForCue 5376)
					)
				)
			)
			(1
				(lightning show: cel: 0 setLoop: 5 setCycle: End self)
			)
			(2
				(lightning hide:)
				(= cycles 1)
			)
			(3
				(if (== local2 2)
					(client setScript: 0)
				else
					(++ local2)
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance mordack of Prop
	(properties
		x 230
		y 176
		view 754
		signal 16384
		cycleSpeed 2
	)
)

(instance aCastle of Prop
	(properties
		x 157
		y 77
		view 755
		loop 4
		signal 16384
	)
)

(instance clouds of Prop
	(properties
		x 157
		y 86
		view 755
		cycleSpeed 3
	)
)

(instance lightning of Prop
	(properties
		x 157
		y 77
		view 755
		loop 5
		signal 16384
		cycleSpeed 2
	)
)

(instance audioTrakScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(audioTrak init: hide: play: 10109 656)
				(introOwl setScript: sceneEightScript)
			)
			(1
				(if (!= (gEgo loop:) 2)
					(gEgo
						setScript: 0
						cel: 0
						setLoop: 2
						setCycle: End self
						setMotion: MoveTo 181 35
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gCurRoom newRoom: 656) ; cdIntro7
			)
		)
	)
)

(instance sceneEightScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(introOwl
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 226 67 self
				)
				(= seconds 3)
			)
			(1
				(gEgo setScript: egoFlying)
			)
			(2
				(cls)
				(introOwl setCycle: End self)
			)
			(3
				(introOwl setLoop: 3 setCycle: End self)
			)
			(4
				(introOwl setLoop: 4 setCycle: Fwd setMotion: MoveTo 181 35)
				(= cycles 1)
			)
			(5
				(= waitForCue 16388)
				(introOwl setLoop: 5 setCycle: End)
			)
			(6
				(cls)
				(introOwl dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoFlying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Fwd setMotion: MoveTo 249 90 self)
			)
			(1
				(gEgo cel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo
					cel: 0
					setLoop: 9
					posn: (- (gEgo x:) 0) (- (gEgo y:) 7)
					setMotion: MoveTo 181 35
					setCycle: End self
				)
			)
			(3
				(gEgo
					cel: 0
					setLoop: 2
					setCycle: End self
					setMotion: MoveTo 181 35
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance introOwl of Actor
	(properties
		x 63
		y 97
		view 760
		loop 2
	)
)

(instance audioTrak of MonoAudioProp
	(properties)
)

