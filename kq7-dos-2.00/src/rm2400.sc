;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2400)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n777)
(use Scaler)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2400 0
	proc2400_1 1
)

(procedure (proc2400_1)
	(switch (gEgo loop:)
		(3
			(gEgo view: 8633 loop: 0)
		)
		(2
			(gEgo view: 8632 loop: 0)
		)
		(0
			(gEgo view: 8631 loop: 0)
		)
		(1
			(gEgo view: 8631 loop: 1)
		)
		(6
			(gEgo view: 8635 loop: 0)
		)
		(7
			(gEgo view: 8635 loop: 1)
		)
		(4
			(gEgo view: 8634 loop: 0)
		)
		(5
			(gEgo view: 8634 loop: 1)
		)
		(else
			(gEgo view: 8631 loop: 0)
		)
	)
)

(instance rm2400 of KQRoom
	(properties
		picture 1000
	)

	(method (init)
		(SetFlag 21)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 48 118 81 137 209 137 188 121 128 106 60 95 5 85 5 96
					yourself:
				)
		)
		(= gValOrRoz -3) ; Roz
		(gEgo normalize:)
		(switch gPrevRoomNum
			(2350
				(if (IsFlag 282)
					(ClearFlag 282)
					(self setScript: enterRoseBlown)
				else
					(self setScript: enterWest)
				)
			)
			(5200
				(self setScript: enterRoseFalls)
			)
			(4050
				(self setScript: enterVolcano)
			)
			(else
				(switch gChapter
					(4
						(self setScript: enterRoseFalls)
					)
					(6
						(self setScript: enterVolcano)
					)
				)
			)
		)
		(switch gChapter
			(4
				(if (!= (gKqMusic1 number:) 2300)
					(gKqMusic1
						stop:
						number: 2300
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
				)
			)
			(6
				(sideHole init: setCycle: Fwd)
				(rumbleHost init: hide: setScript: rumbleRumble)
				(gKqMusic1
					stop:
					number: 2400
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
			)
		)
		(ceilingHole init:)
		(boulders init:)
		(caveExit init:)
	)

	(method (doit)
		(if (IsFlag 255)
			(ClearFlag 255)
			(lava init: setScript: lavaDeath)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(scream stop:)
		(super dispose: &rest)
	)
)

(instance enterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gChapter 6)
					(gEgo normalize: 4 setScaler: Scaler 86 64 116 90)
				else
					(gEgo setScale: scaleX: 83 scaleY: 83)
				)
				(gEgo x: 10 y: 90 init: setMotion: MoveTo 35 102 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoseFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 2478 924) ; WAVE
				(trollKing setScale: scaleX: 83 scaleY: 83 init:)
				(= cycles 2)
			)
			(1
				(= ticks 45)
			)
			(2
				(trollKing setScript: kingLeaves)
				(scream number: 2478 setLoop: 1 play: setVol: 127)
				(gEgo
					view: 1007
					loop: 0
					cel: 0
					x: 119
					y: 120
					init:
					setCycle: CT 7 1 self
				)
			)
			(3
				(gKqSound1 number: 924 setLoop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					normalize: 7
					x: 106
					y: 117
					setScale:
					scaleX: 83
					scaleY: 83
				)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kingLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(trollKing setMotion: MoveTo 0 (caveExit approachY:) self)
			)
			(1
				(trollKing hide: dispose:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterVolcano of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 3003)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 1008
					loop: 0
					cel: 0
					x: 171
					y: 88
					init:
					setCycle: CT 10 1 self
				)
			)
			(2
				(rumble setLoop: 1 play: setVol: 127)
				(proc777_0 gThePlane 1 3)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: CT 9 -1 self)
			)
			(5
				(gEgo
					normalize: 2
					x: 156
					y: 100
					setScale:
					scaleX: 110
					scaleY: 110
					setMotion: MoveTo 156 117 self
				)
			)
			(6
				(gEgo normalize: 2 setScaler: Scaler 86 64 116 90)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoseBlown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 2601)
				(Load 140 924) ; WAVE
				(= cycles 1)
			)
			(1
				(gEgo
					view: 1010
					loop: 0
					cel: 0
					x: 5
					y: 78
					init:
					setCycle: CT 21 1 self
				)
				(gKqSound1 number: 2601 setLoop: 1 play: setVol: 127)
			)
			(2
				(gKqSound1 number: 924 setLoop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: 1 cel: 0 x: 172 y: 136 setCycle: End self)
			)
			(4
				(gEgo
					normalize: 7
					x: 167
					y: 134
					setScaler: Scaler 86 64 116 90
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lavaDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gEgo setMotion: 0 setScript: faceLava)
				(lava cel: 0 show: setCycle: End self)
				(gKqSound1 number: 2305 setLoop: 1 play: setVol: 127)
			)
			(2
				(PalVary 0 2401 3 100 104 246) ; PalVaryStart
				(= ticks 210)
			)
			(3
				(PalVary 3) ; PalVaryKill
				(EgoDead 40 self)
			)
			(4
				(gEgo setScript: 0 normalize: 2)
				(lava cel: 0 hide:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance faceLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setCycle: 0 normalize:)
				(proc11_3 gEgo 147 97 self)
			)
			(1
				(proc2400_1)
				(gEgo setMotion: 0 cel: 0 setCycle: End self)
				(scream number: 4073 setLoop: 1 play: setVol: 127)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rumbleRumble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(if
					(and
						(not (gCurRoom script:))
						(not (gEgo script:))
						(not (lava script:))
					)
					(rumble setLoop: 1 play: self setVol: 127)
					(proc777_0 gThePlane 1 3)
				else
					(= ticks 1)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance trollKing of Actor
	(properties
		x 46
		y 102
		view 9010
		loop 7
	)

	(method (init)
		(|= signal $0800)
		(super init: &rest)
	)
)

(instance lava of Prop
	(properties
		x 175
		y 64
		view 1009
	)
)

(instance rumbleHost of Prop
	(properties
		view 1009
	)
)

(instance sideHole of Prop
	(properties
		x 147
		y 97
		priority 10
		fixPriority 1
		view 1008
		loop 4
	)
)

(instance ceilingHole of View
	(properties
		x 87
		y 22
		view 1000
		loop 1
	)
)

(instance boulders of View
	(properties
		x 37
		y 139
		priority 145
		fixPriority 1
		view 1008
		loop 3
	)

	(method (init)
		(&= signal $fffe)
		(super init: &rest)
	)
)

(instance caveExit of ExitFeature
	(properties
		nsLeft 7
		nsTop 55
		nsRight 33
		nsBottom 94
		approachX 10
		approachY 82
		y 90
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 2350)
	)
)

(instance scream of Sound
	(properties
		number 4073
	)
)

(instance rumble of Sound
	(properties
		number 2264
	)
)

