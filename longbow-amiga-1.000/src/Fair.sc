;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use System)

(public
	Fair 0
	proc311_1 1
	proc311_3 3
	proc311_4 4
)

(local
	local0
	local1
	local2
	local3
	[local4 7] = [0 1 6 5 4 3 2]
	[local11 23] = [315 55 262 65 236 90 154 90 38 60 -20 60 -20 165 14 165 205 165 281 165 315 165 -32768]
	[local34 19] = [4 163 22 163 59 163 97 163 155 163 221 163 248 154 278 146 315 146 -32768]
	[local53 17] = [4 148 26 143 100 142 158 152 214 165 258 164 302 159 315 158 -32768]
	[local70 23] = [4 160 34 160 91 143 159 134 204 134 267 111 317 81 251 62 166 50 96 52 4 52 -32768]
	[local93 23] = [315 41 295 42 253 52 230 55 190 67 151 64 122 54 95 48 68 49 22 59 4 60 -32768]
	[local116 19] = [315 60 309 60 287 55 231 57 164 57 107 57 74 57 23 57 4 57 -32768]
	[local135 7] = [0 10 8 7 10 10 8]
	[local142 3] = [1 1 1]
)

(procedure (proc311_1 param1 param2 param3 &tmp temp0 temp1)
	(walkEm changeState: 0)
	(if (< (= temp0 (+ param1 param2)) 1)
		(= temp0 6)
	)
	(if (> temp0 6)
		(= temp0 1)
	)
	(if (== (= temp1 [local4 param1]) param1)
		(= temp1 0)
	)
	(if (localproc_0 param1 temp0 temp1)
		(= local0 0)
		(Fair setScript: sWalkOut 0 param3)
	else
		(param3
			init: (- param2) param1 (localproc_1 param1) [local135 param1] 0
		)
	)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (== [global120 temp0] param1)
			(if (== param1 param3)
				(return 0)
			)
			(if (== (= temp1 (- param2 param1)) -5)
				(= temp1 1)
			)
			(if (== temp1 5)
				(= temp1 -1)
			)
			(= param1 param2)
			(if (< (+= param2 temp1) 1)
				(= param2 6)
			)
			(if (> param2 6)
				(= param2 1)
			)
			(if (localproc_0 param1 param2 param3)
				(= [global120 temp0] param1)
				(= [local142 temp0] temp1)
				(if
					(and
						global198
						(not local0)
						(< global198 280)
						(not (IsFlag 217))
						(== param1 param3)
					)
					(= local0 1)
					((ScriptID (+ 312 temp0))
						init:
							temp1
							param1
							(localproc_1 param1)
							[local135 param1]
							0
					)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)
	(return 1)
)

(procedure (localproc_1 param1)
	(return
		(switch param1
			(1
				@local11
			)
			(2
				@local34
			)
			(3
				@local53
			)
			(4
				@local70
			)
			(5
				@local93
			)
			(6
				@local116
			)
		)
	)
)

(procedure (proc311_3 &tmp temp0)
	(= local2 (- (/ gCurRoomNum 10) 27))
	(if (< (gEgo y:) 99)
		(= local2 [local4 local2])
	)
	(= local3 [local4 local2])
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if
			(and
				(or (== [global120 temp0] local2) (== [global120 temp0] local3))
				global198
				(not local0)
				(not (IsFlag 217))
				(< global198 280)
			)
			(= local0 1)
			((ScriptID (+ 312 temp0))
				init:
					[local142 temp0]
					[global120 temp0]
					(localproc_1 [global120 temp0])
					[local135 [global120 temp0]]
					(walkEm ticks:)
			)
		)
	)
)

(procedure (proc311_4 param1 &tmp temp0) ; UNUSED
	(param1
		lookStr: {Tis a cat}
		view: 767
		loop: (- (Random 1 2) 1)
		setCycle: Walk
	)
	(if (== (- (Random 1 5) 1) 3)
		(or (== gCurRoomNum 300) (== gCurRoomNum 290))
		(param1
			signal: 16400
			priority: (if (== gCurRoomNum 290) 4 else 8)
			x: (if (== (param1 loop:) 0) -10 else 350)
			y: 84
			z: 20
			setScript: catWalk
		)
	)
)

(class Fair of Rgn
	(properties
		keep 1
		firstPickpocket 1
		firstTalkMorgan 1
		firstClickF3Talk 1
		firstClickMan13 1
		firstClickMan20 1
		firstClikMan24 1
		firstClickF26 1
		man4FirstClickTk 1
		talkedWithMan4 0
		doneGambled 0
		firstAfterGambling 1
		firstCricket 1
		boughtRoseOil 0
		firstChristy 1
		walkingOut 0
		mX 0
		mY 0
	)

	(method (init &tmp temp0)
		(super init:)
		(self setScript: walkEm)
	)

	(method (newRoom)
		(if (not (gEgo has: 17)) ; handScroll
			(++ gRoomCount)
		)
		(= local0 0)
		(if (< (gEgo x:) -10)
			(gEgo x: -10)
		)
		(if (> (gEgo x:) 330)
			(gEgo x: 330)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 311)
	)
)

(instance walkEm of Script
	(properties
		ticks 400
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (and (IsFlag 58) (> gRoomCount 50))
					(gCurRoom west: 160 east: 160 north: 160 south: 160)
				)
				(= ticks 801)
			)
			(1
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if
						(and
							(!= [global120 temp0] local2)
							(!= [global120 temp0] local3)
						)
						(if
							(<
								(= temp2 (+ [global120 temp0] (Random 1 3) -2))
								1
							)
							(= temp2 6)
						)
						(if (> temp2 6)
							(= temp2 1)
						)
						(if
							(and
								(!= temp2 global120)
								(!= temp2 global121)
								(!= temp2 global122)
							)
							(if (== (= temp3 (- temp2 [global120 temp0])) -5)
								(= temp3 1)
							)
							(if (== temp3 5)
								(= temp3 -1)
							)
							(if
								(and
									(or (== temp2 local2) (== temp2 local3))
									global198
									(not local0)
									(not (IsFlag 217))
									(< global198 280)
								)
								(= local0 1)
								((ScriptID (+ 312 temp0))
									init:
										temp3
										temp2
										(localproc_1 temp2)
										[local135 temp2]
										0
								)
							)
							(= [global120 temp0] temp2)
							(= [local142 temp0] temp3)
						)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance catWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setMotion:
						MoveTo
						(if (== (client loop:) 0) 250 else 25)
						84
						self
				)
			)
			(1
				(client
					loop: (if (== (client loop:) 0) 2 else 3)
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sWalkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fair walkingOut: 1)
				(if (< (register x:) 10)
					(register
						setLoop: 1
						setMotion: MoveTo -10 (register y:) self
					)
				else
					(register
						setLoop: 0
						setMotion: MoveTo 333 (register y:) self
					)
				)
			)
			(1
				(register dispose:)
				(Fair walkingOut: 0)
				(self setScript: walkEm)
			)
		)
	)
)

