;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm701 0
)

(local
	local0
	[local1 45]
	[local46 45] = [172 178 186 178 168 164 186 178 183 175 172 153 160 168 174 172 170 166 161 156 134 139 138 131 150 130 129 160 153 143 140 143 151 144 158 151 132 142 159 168 125 155 123 146 130]
	[local91 45] = [188 139 99 66 44 20 115 152 83 168 180 186 166 148 126 113 96 79 62 34 188 175 149 119 100 74 46 24 134 22 40 65 185 162 147 112 88 78 91 180 15 37 30 18 10]
	[local136 45] = [0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 -1 1 1 1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 3 3 1 1 0 2 2]
	local181
)

(procedure (localproc_0)
	(for ((= local181 0)) (< local181 45) ((++ local181))
		(= [local1 local181] (clIvy new:))
		([local1 local181]
			x: [local46 local181]
			y: [local91 local181]
			setLoop: [local136 local181]
			setCel: 221
			signal: 16401
			init:
		)
	)
)

(instance rightSide of Feature
	(properties)

	(method (init)
		(= onMeCheck 16)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance leftSide of Feature
	(properties)

	(method (init)
		(= onMeCheck 32)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance rm701 of Rm
	(properties
		picture 701
		horizon 20
	)

	(method (dispose)
		(gTheIconBar enable: 0)
		((gTheIconBar at: 2) message: 3)
		(super dispose:)
	)

	(method (init)
		(if (== gPrevRoomNum 702)
			(= style 13)
			(gEgo view: 709 y: 21 setCycle: Walk init:)
		else
			(= style 14)
			(gEgo view: 709 setCycle: Walk cel: 0 y: 164 init:)
		)
		(super init:)
		(= local0 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gRgnMusic2 fade: 0 20 12 1)
		((gTheIconBar at: 2) message: 1)
		(AddToFeatures aTower sky rightSide leftSide)
		(localproc_0)
		(gEgo
			xStep: 2
			yStep: 3
			setPri: 12
			signal: 16400
			ignoreHorizon:
			actions: unusualDoVerb
			setScript: enterThePicture
		)
	)

	(method (reflectPosn)
		(return 0)
	)

	(method (doit)
		(gRgnMusic setVol: (/ (gEgo y:) 2))
		(gSFX setVol: (/ (gEgo y:) 2))
		(cond
			((gEgo script:) 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(gEgo setScript: N)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gEgo setScript: S)
			)
			((leftSide onMe: gEgo)
				(gEgo setScript: climbGoThere 0 0)
			)
			((rightSide onMe: gEgo)
				(gEgo setScript: climbGoThere 0 1)
			)
			(else
				(super doit: &rest)
			)
		)
		(super doit: &rest)
	)
)

(instance unusualDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Inventory
			(Say 1701 3 1) ; "If I let go of these vines, I'm a dead man."
		)
	)
)

(instance aTower of Feature
	(properties
		x 212
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1701 0 1) ; "I cannot cling to bare stone."
			)
			(3 ; Do
				(Say 1701 0 1) ; "I cannot cling to bare stone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 212 0 229 189 0 189 0 2
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(= gUseSortedFeatures local0)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance sky of Feature
	(properties
		x 267
		y 94
		nsLeft 210
		nsBottom 189
		nsRight 319
		lookStr 4 ; "A perpetual gloom hangs over this fens."
	)
)

(instance clIvy of Prop
	(properties
		x 160
		y 170
		view 700
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1701 1 1) ; "The ivy remains strong even here by the power of the Green Man's blessing."
			)
			(3 ; Do
				(Say 1701 2 1) ; "For my dear life's sake, I'm clinging to this ivy as tightly as I can."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance climbGoThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1701 0) ; "I cannot cling to bare stone."
				(gEgo
					setMotion:
						PolyPath
						(if register
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
						(gEgo y:)
						self
				)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 4 0)
				(self dispose:)
			)
		)
	)
)

(instance N of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 55) self
				)
			)
			(1
				(gCurRoom newRoom: 702)
			)
		)
	)
)

(instance S of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(1
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance enterThePicture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 4 0)
				(self dispose:)
			)
		)
	)
)

