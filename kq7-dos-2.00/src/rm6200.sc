;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6200)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm6200 0
)

(instance rm6200 of KQRoom
	(properties
		picture 6200
	)

	(method (init)
		(gGame handsOn:)
		(gGame handsOff:)
		(SetFlag 21)
		(SetFlag 203)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 176 62 154 58 152 62 168 68 171 76 148 78 99 73 73 63 63 66 84 78 58 86 79 95 98 87 109 87 129 85 137 89 105 96 92 102 113 107 150 107 139 98 158 93 174 96 182 103 195 104 216 95 231 85 325 90 325 78 236 73 224 76 200 70 191 72 178 70
					yourself:
				)
		)
		(gEgo normalize:)
		(switch gPrevRoomNum
			(6300
				(self setScript: enterRoom)
			)
			(6500
				(self setScript: enterValFlies)
			)
			(else
				(self setScript: valEntersOnHorse)
			)
		)
		(desertRainBo init:)
		(oogaRainBo init:)
		(falderalRainBo init:)
		(woodsRainBo init:)
		(myEastExit init:)
		(if (!= (gKqMusic1 number:) 6200)
			(gKqMusic1
				stop:
				number: 6200
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 330
					y: 83
					init:
					setScaler: Scaler 70 24 116 56
					setMotion: MoveTo 305 83 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valEntersOnHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 3202 6202) ; WAVE
				(Load rsSOUND 819 6203)
				(= seconds 1)
			)
			(1
				(gKqSound1 number: 819 setLoop: 1 play: setVol: 127)
				(ghostHorse init: setCycle: CT 6 1 self)
			)
			(2
				(ghostHorse setCycle: End self)
				(gKqSound1 number: 6202 setLoop: 1 play: setVol: 127)
			)
			(3
				(ghostHorse loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(ghostHorse loop: 2 cel: 0 x: 97 y: 74 setCycle: CT 8 1 self)
				(gEgo
					normalize: 4
					x: 128
					y: 78
					init:
					setScaler: Scaler 70 24 116 56
				)
			)
			(5
				(gKqSound1 number: 6203 setLoop: 1 play: setVol: 127)
				(ghostHorse setCycle: End self)
			)
			(6
				(ghostHorse hide: dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterValFlies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6155)
				(Load rsSOUND 6261)
				(= seconds 1)
			)
			(1
				(gEgo
					view: 6155
					setLoop: 1 1
					cel: -1
					x: 105
					y: 83
					init:
					setScale:
					scaleX: 68
					scaleY: 68
					setCycle: Beg self
				)
				(gKqSound1 number: 6261 setLoop: 1 play:)
			)
			(2
				(gEgo normalize: 4 setScaler: Scaler 70 24 116 56)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slideToOoga of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 89 113 self)
			)
			(1
				(gEgo view: 8224 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					setScale: 0
					x: 29
					y: 125
					view: 6202
					loop: 1
					cel: 0
					setCycle: CT 10 1 self
				)
			)
			(3
				(gKqMusic1 stop:)
				(gKqSound1 number: 6201 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo hide:)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 4550)
				(self dispose:)
			)
		)
	)
)

(instance slideToFalderal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 146 59 self)
			)
			(1
				(gEgo view: 8225 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					setScale: 0
					x: 153
					y: 53
					view: 6202
					loop: 2
					cel: 0
					setCycle: End self
				)
				(gKqMusic1 stop:)
				(gKqSound1 number: 6201 setLoop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 5300)
				(self dispose:)
			)
		)
	)
)

(instance slideToDesert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 94 63 self)
			)
			(1
				(gEgo view: 8225 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					setScale: 0
					x: 85
					y: 58
					view: 6202
					loop: 3
					cel: 0
					setCycle: End self
				)
				(gKqMusic1 stop:)
				(gKqSound1 number: 6201 setLoop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 1600)
				(self dispose:)
			)
		)
	)
)

(instance slideToWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 159 121 self)
			)
			(1
				(gEgo view: 8224 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					setScale: 0
					x: 215
					y: 125
					view: 6202
					loop: 0
					cel: 0
					setCycle: CT 10 1 self
				)
			)
			(3
				(gKqMusic1 stop:)
				(gKqSound1 number: 6201 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo hide:)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 3250)
				(self dispose:)
			)
		)
	)
)

(instance ghostHorse of Prop
	(properties
		x 101
		y 75
		view 6201
	)

	(method (init)
		(if (> (gGame speedRating:) 380)
			(self cycleSpeed: 8)
		)
		(super init: &rest)
	)
)

(class RainBow of Feature
	(properties
		scriptToSet 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if scriptToSet
					(gCurRoom setScript: scriptToSet)
				)
				(return 1)
			)
		)
	)
)

(instance desertRainBo of RainBow
	(properties
		approachX 87
		approachY 67
		x 80
		y 64
	)

	(method (init)
		(super init: &rest)
		(self
			scriptToSet: slideToDesert
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 45 72 48 78 54 85 62 66 65 57 54 51 59 41 54 47 50 57 46
					yourself:
				)
		)
	)
)

(instance oogaRainBo of RainBow
	(properties
		approachX 118
		approachY 101
		x 110
		y 97
	)

	(method (init)
		(super init: &rest)
		(self
			scriptToSet: slideToOoga
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 114 79 137 55 137 44 122 35 127 26 137 0 138 0 119 14 110 29 108
					yourself:
				)
		)
	)
)

(instance falderalRainBo of RainBow
	(properties
		approachX 150
		approachY 62
		x 160
		y 58
	)

	(method (init)
		(super init: &rest)
		(self
			scriptToSet: slideToFalderal
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 58 159 48 167 42 178 41 191 48 195 53 180 60
					yourself:
				)
		)
	)
)

(instance woodsRainBo of RainBow
	(properties
		approachX 142
		approachY 106
		x 152
		y 110
	)

	(method (init)
		(super init: &rest)
		(self
			scriptToSet: slideToWoods
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 118 250 122 264 131 270 137 185 137 171 128 182 119 198 115 219 115
					yourself:
				)
		)
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 300
		nsRight 320
		nsBottom 140
		approachX 328
		approachY 81
		x 340
		y 81
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 6300)
	)
)

