;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use n013)
(use HedgeRow)
(use verseScript)
(use PolyPath)
(use Polygon)
(use User)
(use Actor)
(use System)

(public
	hedge9 0
)

(local
	local0
	[local1 43]
	[local44 40] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1]
	[local84 40] = [1 1 1 1 1 1 2 2 2 2 2 2 4 4 4 4 4 5 5 5 7 7 7 6 7 6 6 8 8 9 9 9 9 9 9 9 10 10 10 10]
	[local124 40] = [327 264 202 138 77 16 327 264 202 140 77 16 327 264 202 140 109 348 308 245 130 66 36 216 149 326 267 152 117 322 258 226 198 194 87 106 15 35 56 170]
	[local164 54] = [45 45 45 45 45 45 83 83 83 83 83 83 115 115 115 115 115 142 142 142 142 142 142 173 173 173 173 173 173 213 213 213 213 243 203 232 179 211 243 244 0 1070 2 1 0 431 0 2 4 23 34 24 25 1]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 42) ((++ temp0))
		((= [local1 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local44 temp0]
			priority: [local84 temp0]
			signal: 16400
			x: [local124 temp0]
			y: [local164 temp0]
			init:
		)
		(gAddToPics add: [local1 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge9 of HedgeRow
	(properties
		teleX 150
		teleY 50
	)

	(method (init)
		(super init:)
		(if (== gDay 10)
			(self north: 501)
		else
			(self north: 500)
		)
		(if (not (<= 30 gPrevRoomNum 85)) ; hedge1, hedge12
			(gRgnMusic number: 490 loop: -1 play:)
		else
			(gRgnMusic fade: 127 8 30 0)
		)
		(localproc_0)
		(AddToAddToPics theDoor)
		(gCurRoom
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 47 0 20 319 20 319 47 yourself:)
				((Polygon new:) type: PBarredAccess init: 0 85 0 74 319 74 319 85 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 34 117 26 105 319 105 319 117
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 144 204 144 222 165 319 165 319 175 195 175 164 130 319 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 130 132 130 161 175 72 175 82 189 53 189 33 160 114 160 105 146 8 146 37 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 113 189 111 187 319 187 319 189
					yourself:
				)
		)
	)
)

(instance theDoor of PicView
	(properties
		x 168
		y 47
		view 500
		loop 2
		priority 1
		signal 16400
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canControl:)
				(User canInput:)
				(or
					(and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) $0000))
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(or
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(self onMe: event)
			)
			(if (== gDay 10)
				(SetFlag 172)
			)
			(cond
				((> (gEgo y:) 75)
					(event claimed:)
					(Say 1070 6 1) ; "The hedges are thick and impenetrable. I must find a way around."
				)
				((== gDay 10)
					(gEgo setScript: (ScriptID 490 2)) ; runFerDoor
				)
				(else
					(event claimed:)
					(gEgo setScript: goToDoor)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(Say 1070 0 0) ; "A hidden door opens out of the maze."
		else
			(super doVerb: &rest)
		)
	)
)

(instance goToDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(- (theDoor x:) 62)
						(+ (theDoor y:) 2)
						self
				)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 1) self
				)
			)
			(2
				(= global158 0)
				(= gForestSweepRoomCount 0)
				(gCurRoom newRoom: 500)
				(HandsOn)
			)
		)
	)
)

