;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 551)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	toadRegion 0
	toad 1
	hopAway 2
	hopAbout 3
)

(local
	local0
	local1
	[local2 140] = [136 137 188 152 30 129 232 143 302 75 257 130 45 156 253 142 24 58 116 183 164 136 208 156 300 121 123 123 303 118 60 177 124 134 258 89 127 115 244 181 78 139 122 159 18 136 275 225 301 117 180 112 163 107 20 154 307 177 16 178 132 157 172 170 62 150 217 146 26 159 33 130 213 151 65 155 267 164 216 205 88 122 150 138 34 121 80 205 168 156 47 137 232 152 296 79 288 143 55 127 174 140 223 160 72 145 330 123 189 169 72 140 215 84 -10 120 214 89 42 83 217 140 236 151 84 186 330 157 151 136 320 156 12 165 330 179 158 87 330 73]
)

(instance toadRegion of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(toad setScript: 0 dispose:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
		(= local1
			(switch gCurRoomNum
				(19 0)
				(20 20)
				(21 40)
				(22 60)
				(24 80)
				(25 100)
				(26 120)
			)
		)
		(toad
			init:
			loop: (Random 0 1)
			x:
				(switch (Random 0 1)
					(0 [local2 local1])
					(1 [local2 (+ local1 2)])
				)
			y:
				(switch (Random 0 1)
					(0 [local2 (+ local1 1)])
					(1 [local2 (+ local1 3)])
				)
		)
		(if (== gCurRoomNum 22)
			(toad view: 461 setStep: 1 1)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance toad of Act
	(properties
		view 459
		signal 24576
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (== (self cel:) 1)
			(cond
				((!= gCurRoomNum 22)
					(gGlobalSound4 number: (Random 99 100) loop: 1 vol: 127 play:)
				)
				(
					(or
						(== (self script:) hopAbout)
						(== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
					)
					(gGlobalSound4 number: (Random 99 100) loop: 1 vol: 40 play:)
				)
			)
		)
		(return
			(if (self script:)
				0
			else
				(++ local0)
				(if (or (< (self distanceTo: gEgo) 35) (> local0 60))
					(self setScript: hopAway)
				)
			)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 551 0) ; "It seems to Graham that there is an unusual amount of toads in this forest."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 551 1) ; "These toads look too repulsive to catch!"
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 551 2) ; "Ribbiitttt!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hopAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(== gPrevRoomNum (gCurRoom south:))
						(== gPrevRoomNum (gCurRoom east:))
					)
					(toad
						setCycle: Walk
						setMotion:
							MoveTo
							[local2 (+ local1 4)]
							[local2 (+ local1 5)]
							self
					)
				else
					(toad
						setCycle: Walk
						setMotion:
							MoveTo
							[local2 (+ local1 6)]
							[local2 (+ local1 7)]
							self
					)
				)
			)
			(1
				(toad
					hide:
					stopUpd:
					setCel: 0
					setScript: (if (> global81 1) hopAbout else 0)
				)
			)
		)
	)
)

(instance hopAbout of Script
	(properties
		register 8
	)

	(method (doit)
		(super doit:)
		(if (and (not (gCurRoom script:)) (== state 1))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1 0)
			(2
				(if (== register 20)
					(= register 8)
				)
				(= temp0 (* (Random 0 1) 2))
				(toad
					show:
					setCycle: Walk
					x: [local2 (+ local1 temp0 register)]
					y: [local2 (+ local1 1 temp0 register)]
					setMotion:
						MoveTo
						[local2 (- (+ local1 2 register) temp0)]
						[local2 (- (+ local1 3 register) temp0)]
						self
				)
			)
			(3
				(toad hide: setCel: 0)
				(+= register 4)
				(self init:)
			)
		)
	)
)

