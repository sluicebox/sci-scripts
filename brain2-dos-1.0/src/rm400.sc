;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm400 0
)

(instance rm400 of Rm
	(properties
		picture 410
	)

	(method (init)
		(gCMusic number: 18 setLoop: -1 play:)
		(super init:)
		(gTheIconBar disable:)
		(self setScript: moveToNext)
	)

	(method (dispose)
		(super dispose: &rest)
		(LoadMany 0 946 945 964)
	)
)

(instance moveToNext of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 188 216 141 232)
				(LoadMany rsVIEW 415)
				(gCSoundFX number: 188 setLoop: -1 play:)
				(anchor init: setCycle: Fwd)
				(theFlag init:)
				(propeller init:)
				(squid
					init:
					setStep: 8
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Fwd
					setMotion: MoveTo -30 (squid y:) squid
				)
				(dolphin
					init:
					setCycle: Fwd
					setMotion: MoveTo -100 (dolphin y:)
				)
				(dolphin2
					init:
					setCycle: Fwd
					setMotion: MoveTo -100 (dolphin2 y:)
				)
				(fish1 init: setCycle: Fwd setMotion: MoveTo -100 (fish1 y:))
				(fish2 init: setCycle: Fwd setMotion: MoveTo -100 (fish2 y:))
				(waves init: setCycle: Fwd)
				(smoke init: setCycle: Fwd)
				(= ticks 1)
			)
			(1
				(gGame setCursor: 996)
				(= seconds 3)
			)
			(2
				(anchor setCycle: End self)
			)
			(3
				(anchor setCel: 0 setLoop: 5 setCycle: End self)
			)
			(4
				(gCSoundFX stop:)
				(= seconds 3)
			)
			(5
				(gCSoundFX number: 216 setLoop: 1 play: propeller)
				(propeller setCycle: Fwd)
				(dolphin moveSpeed: 1 origStep: 257 setScript: (raceIt new:))
				(dolphin2 moveSpeed: 1 origStep: 257 setScript: (raceIt new:))
				(fish1
					moveSpeed: 1
					origStep: 257
					setMotion: MoveTo 400 (fish1 y:)
				)
				(fish2
					moveSpeed: 1
					origStep: 257
					setMotion: MoveTo 400 (fish1 y:)
				)
				(= register 1)
				(= ticks 26)
			)
			(6
				(waves cycleSpeed: 16)
				(propeller cycleSpeed: 8)
				(= ticks 30)
			)
			(7
				(smoke setLoop: 13 setCel: 0 setCycle: End smoke)
				(waves cycleSpeed: 8)
				(propeller cycleSpeed: 4)
				(= seconds 5)
			)
			(8
				(gMessager say: 1 9 0) ; "Aha! The old ship hidden in the island trick. You've seen that one before. Wait a minute! Have you seen that one before?"
				(squid
					moveSpeed: 1
					origStep: 257
					setScript: ((raceIt new:) start: 1)
				)
				(theFlag setCycle: End self)
			)
			(9
				(theFlag setCel: 0 x: 135 y: 5 setLoop: 3 setCycle: Fwd)
				(= seconds 4)
			)
			(10
				(gCSoundFX number: 141 setLoop: 1 play:)
				(whistle init: setCycle: End)
				(= seconds 2)
			)
			(11
				(whistle setCycle: End)
				(= seconds 2)
			)
			(12
				(whistle setCycle: End)
				(= seconds 2)
			)
			(13
				(client setScript: shipScript)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if register
			(Palette palANIMATE 69 73 -9)
		)
		(super doit: &rest)
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke dispose:)
				(waves dispose:)
				(propeller dispose:)
				(theFlag dispose:)
				(anchor dispose:)
				(squid dispose:)
				(dolphin dispose:)
				(dolphin2 dispose:)
				(fish1 dispose:)
				(fish2 dispose:)
				(whistle dispose:)
				(gCurRoom
					drawPic: 130
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 249 189 158 189 200 171 206 162 223 158 252 167 238 181 250 185
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 144 134 142 139 170 145 166 136 201 136 223 129 224 137 197 150 201 165 176 165 133 189 87 189 52 173 52 163 83 128 111 117 146 123 171 118 221 127 200 133 160 133 164 141
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 131 111 150 102 175 108 175 113 146 115
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 177 98 156 94 158 91 168 90 200 98 215 93 186 79 163 84 153 93 143 94 131 91 115 83 104 87 134 94 113 113 75 129 48 129 34 108 0 108 0 0 143 0 143 65 197 65 252 81 246 104 228 119 181 118
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 181 278 181 255 171 258 166 235 159 228 139 256 147 267 154 298 150 294 143 281 138 268 148 230 137 230 133 279 102 309 102 319 116
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 217 147 226 145 229 152
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 222 156 207 153 213 151 229 154
							yourself:
						)
				)
				(theIsland init: x: global172 y: global173 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(gMessager say: 1 49 0) ; "As you are whisked away in Dr. Brain's island ship, you wonder what is this invention you've worked so hard for. What could possibly use such a huge battery? Dr. Brain eagerly awaits to show it to you outside his castle."
				(theIsland setCycle: Walk setMotion: PolyPath 132 95 self)
			)
			(2
				(theIsland
					setMotion:
						DPath
						134
						97
						140
						100
						134
						107
						127
						110
						118
						107
						115
						103
						125
						100
						135
						97
						138
						99
						135
						101
						132
						99
						135
						97
						132
						94
						132
						90
						self
				)
			)
			(3
				(theIsland setMotion: PolyPath 106 74 self)
			)
			(4
				(= global131 0)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance raceIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setMotion:
						MoveTo
						(+ (client x:) (Random 10 30))
						(client y:)
						self
				)
			)
			(1
				(client
					setMotion:
						MoveTo
						(- (client x:) (Random 10 30))
						(client y:)
						self
				)
				(= start 0)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 175
		y 12
		view 415
		loop 12
		signal 16384
		cycleSpeed 9
	)

	(method (cue)
		(self setLoop: 0 setCel: 0 setCycle: Fwd)
	)
)

(instance waves of Prop
	(properties
		y 97
		view 415
		loop 1
		cel 1
		signal 16384
		cycleSpeed 36
	)
)

(instance propeller of Prop
	(properties
		x 266
		y 141
		view 415
		loop 2
		cel 4
		signal 16384
		cycleSpeed 12
	)

	(method (cue)
		(gCSoundFX client: 0 number: 232 setLoop: -1 play:)
	)
)

(instance theFlag of Prop
	(properties
		x 131
		y 31
		view 415
		loop 4
		signal 24576
	)
)

(instance anchor of Prop
	(properties
		x 39
		y 110
		view 415
		loop 9
		cel 6
		signal 16384
		cycleSpeed 16
	)
)

(instance squid of Actor
	(properties
		x 330
		y 164
		view 415
		loop 6
		cel 8
		signal 18432
	)

	(method (cue)
		(self
			x: 340
			y: (+ y 15)
			setStep: 4 2
			cycleSpeed: 6
			moveSpeed: 6
			setMotion: MoveTo -100 y
		)
	)
)

(instance dolphin of Actor
	(properties
		x 186
		y 145
		view 415
		loop 7
		signal 18432
		cycleSpeed 4
	)
)

(instance dolphin2 of Actor
	(properties
		x 146
		y 157
		view 415
		loop 7
		cel 1
		signal 18432
		cycleSpeed 4
	)
)

(instance fish1 of Actor
	(properties
		x 28
		y 172
		view 415
		loop 8
		signal 18432
	)
)

(instance whistle of Prop
	(properties
		x 154
		y 21
		view 415
		loop 10
		signal 26624
	)
)

(instance fish2 of Actor
	(properties
		x 281
		y 171
		view 415
		loop 8
		signal 18432
	)
)

(instance theIsland of Actor
	(properties
		yStep 1
		view 130
		priority 1
		signal 24592
		xStep 1
		origStep 257
	)
)

(instance engineSound of Sound ; UNUSED
	(properties)
)

