;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 165)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm165 0
	rogTalker 15
)

(local
	[local0 80] = [0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2]
	[local80 80] = [319 281 272 265 261 257 252 247 243 240 238 232 227 224 220 218 216 144 139 137 133 129 125 122 119 117 115 108 102 96 90 85 83 82 82 85 86 92 100 107 112 120 129 138 143 148 152 154 156 157 157 154 150 144 138 129 119 110 103 99 93 91 92 95 100 107 117 128 137 150 167 185 203 221 240 257 274 291 309 307]
	[local160 80] = [163 105 93 87 84 82 80 78 76 75 74 72 71 70 68 68 68 65 63 63 64 66 68 72 76 82 90 99 105 109 111 112 112 112 112 111 113 115 116 115 114 111 107 102 98 94 91 89 87 86 86 87 88 89 91 93 93 92 88 85 83 81 81 79 76 73 69 64 60 55 49 43 39 36 34 33 33 33 34 62]
	[local240 80] = [128 51 32 23 20 34 30 26 26 23 23 19 19 19 15 15 15 29 29 29 29 37 37 44 44 52 52 60 60 60 60 60 60 60 60 60 60 60 60 52 52 44 44 37 37 29 29 29 29 29 29 29 29 37 37 44 44 44 23 23 19 19 19 19 15 15 15 11 11 11 11 11 11 11 11 11 11 11 11 3]
	local320
	local321 = 79
)

(instance rm165 of Rm
	(properties
		picture 37
		style -32758
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 164)
		(theDoors init:)
		(super init:)
		(gCurRoom setScript: sDoAll)
	)
)

(instance sDoAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 106 setLoop: 1 play:)
				(theDoors setCycle: End self)
			)
			(2
				(theDoors dispose:)
				(= seconds 2)
			)
			(3
				(gMessager say: 1 0 0 1 self) ; "And so, having undergone an extensive weekend Captain's training seminar on the planet Oakhurst, Roger is shuttled to his new command--the SS Eureka."
			)
			(4
				(Palette palSET_FROM_RESOURCE 37 2)
				(PalVary pvUNINIT)
				(PalVary pvINIT 372 1)
				(= local320 5)
				(shuttle1
					view: 164
					setLoop: -1
					setLoop: 0
					cel: 0
					x: 319
					y: 163
					init:
					setScale: Scaler 150 20 163 84
					setMotion: MoveTo 261 84 self
				)
				(gSq5Music2 number: 156 loop: -1 play: fade: 10 10 5 0)
			)
			(5
				(shuttle1
					loop: [local0 local320]
					x: [local80 local320]
					y: [local160 local320]
					setScale: 0
					scaleSignal: 1
					scaleX: [local240 local320]
					scaleY: [local240 local320]
					show:
				)
				(if (> (++ local320) local321)
					(= cycles 1)
				else
					(-- state)
					(switch local320
						(17
							(shuttle1 hide:)
							(= seconds 3)
						)
						(50
							(gMessager say: 1 0 0 2 3 self) ; "|f8|hey!|f| That's not a starship--it's a |f8|garbage scow!|f|"
						)
						(else
							(= ticks 7)
						)
					)
				)
			)
			(6
				(gEgo get: 10) ; Communicator
				(gSq5Music1 stop:)
				(gSq5Music2 stop:)
				(shuttle1 dispose:)
				(PalVary pvUNINIT)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance theDoors of Prop
	(properties
		x 33
		y 21
		view 164
		loop 4
	)
)

(instance shuttle1 of Actor
	(properties
		x 319
		y 163
		view 164
		loop 3
		moveSpeed 2
	)
)

(instance rogTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 170 tailY: 65 xOffset: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

