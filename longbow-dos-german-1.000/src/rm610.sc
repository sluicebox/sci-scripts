;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Polygon)
(use DPath)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm610 0
	hiddenWisp 1
)

(local
	local0
	local1
	local2
	[local3 24]
	[local27 24] = [3 3 3 3 2 2 3 3 3 2 2 2 2 2 2 3 2 3 2 2 3 3 3 3]
	[local51 24] = [7 7 7 7 6 7 6 6 6 6 6 4 1 4 3 7 7 6 5 6 5 6 7 5]
	[local75 24] = [269 0 20 252 50 0 22 0 281 243 286 23 -3 281 -4 228 233 258 268 286 302 -5 37 224]
	[local99 24] = [189 24 189 28 189 189 173 12 21 19 181 17 43 17 170 189 183 175 166 36 39 34 10 12]
	[local123 10]
	[local133 13] = [266 265 196 299 124 210 240 127 91 125 34 185 278]
	[local146 13] = [47 66 50 76 17 115 85 62 121 85 103 129 142]
	[local159 20]
	[local179 14] = [65 295 0 194 319 147 83 226 -27 195 60 318 98 191]
	[local193 14] = [24 22 58 51 69 62 97 108 121 140 150 172 181 201]
)

(procedure (localproc_0)
	(if (gCast contains: hiddenWisp)
		(return)
	)
	(if (== (= local2 (Random 1 4)) 3)
		(= local2 2)
	)
	(switch local2
		(1
			(hiddenWisp
				init:
				setMotion:
					DPath
					215
					160
					240
					110
					165
					105
					115
					85
					165
					50
					180
					10
					170
					-80
			)
		)
		(2
			(hiddenWisp
				init:
				setMotion: DPath 120 150 90 120 165 90 240 70 305 105 400 100
			)
		)
		(4
			(hiddenWisp
				init:
				setMotion: DPath 210 140 230 105 185 70 105 60 45 105 -80 100
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(= [local159 temp0] (cloud new:))
		([local159 temp0]
			x: [local179 temp0]
			y: [local193 temp0]
			loop: (Random 0 1)
			init:
		)
		(gAddToPics add: [local159 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 24) ((++ temp0))
		(= [local3 temp0] (plant new:))
		([local3 temp0]
			view: 600
			loop: [local27 temp0]
			cel: [local51 temp0]
			signal: 16384
			x: [local75 temp0]
			y: [local99 temp0]
			init:
		)
		(gAddToPics add: [local3 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		((= [local123 temp0] (wave new:))
			x: [local133 temp0]
			y: [local146 temp0]
			setPri: 1
			init:
		)
	)
)

(instance rm610 of Rm
	(properties
		picture 610
		horizon 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1610 2 1) ; "Faith, that is dark and unwholesome water, just deep enough to drown a man."
			)
			(3 ; Do
				(Say 1610 3 1) ; "I care not to touch this water."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(= local0 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(localproc_2)
		(localproc_1)
		(if (not (IsFlag 0))
			(localproc_3)
		)
		(gEgo actions: (ScriptID 601 7)) ; egoActions
		(self
			addObstacle:
				((Polygon new:) type: PTotalAccess init: 0 50 0 0 117 0 117 23 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 195 0 319 0 319 47 195 23
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 161 49 161 121 183 121 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 196 189 196 181 268 155 319 155 319 189
					yourself:
				)
		)
		(if (== gDisguiseNum 6) ; fens monk
			(gCurRoom setScript: withMonk)
		else
			(gEgo setScript: onTheWater)
		)
	)

	(method (doit &tmp [temp0 2] temp2)
		(if (== (mod (++ local1) 5) 0)
			(Palette palANIMATE 225 255 -1)
		)
		(= temp2 (gEgo onControl: 1))
		(cond
			((gEgo script:))
			((gEgo edgeHit:)
				(gEgo setScript: outtaHere)
			)
			((and (== global115 1) (not (gCast contains: hiddenWisp)))
				(localproc_0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(= gUseSortedFeatures local0)
		(super dispose:)
	)
)

(instance cloud of PicView
	(properties
		z 15
		lookStr 4 ; "The miasma that drifts over these fens is now so thick, I cannot even make out the Monastery through it."
		view 590
		signal 24576
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1610 5 1) ; "How can one grasp insubstantial tendrils of mist?"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance plant of PicView
	(properties
		lookStr 1 ; "Only stunted bushes and thick reeds grow in these fen waters."
	)
)

(instance wave of Prop
	(properties
		view 610
		loop 4
		signal 16384
		cycleSpeed 18
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance hiddenWisp of Actor
	(properties
		x 130
		y 190
		yStep 6
		view 610
		loop 3
		signal 26624
		xStep 6
		moveSpeed 12
	)
)

(instance onTheWater of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(= temp2 (if (> gHowFast 0) 2 else 3))
				(HandsOff)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 587
					cel: 0
					posn: 170 240
					setStep: temp2 temp2
					moveSpeed: 6
					cycleSpeed: 24
					setCycle: Walk
					looper: (ScriptID 601 6) ; boatLooper
					signal: (& (| (gEgo signal:) $3000) $f7ff)
					init:
					setMotion: PolyPath 176 170 self
				)
			)
			(1
				(if (== global115 1)
					(localproc_0)
				)
				(HandsOn)
				(gEgo cycleSpeed: 24)
				(self dispose:)
			)
		)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (gEgo edgeHit:)
					(EDGE_TOP
						(gEgo setMotion: PolyPath (gEgo x:) -5 self)
					)
					(EDGE_BOTTOM
						(gEgo
							setMotion:
								PolyPath
								(gEgo x:)
								(+ (gEgo y:) 30)
								self
						)
					)
					(EDGE_LEFT
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 40)
								(gEgo y:)
								self
						)
					)
					(EDGE_RIGHT
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 53)
								(gEgo y:)
								self
						)
					)
				)
			)
			(1
				(if
					(and
						(== global115 1)
						(== gDay 13)
						(== (gEgo edgeHit:) local2)
					)
					(gCurRoom newRoom: 700)
				else
					(gCurRoom newRoom: 620)
				)
			)
		)
	)
)

(instance withMonk of Script
	(properties)

	(method (doit)
		((ScriptID 601 3) ; robin
			posn: (- ((ScriptID 601 1) x:) 36) (+ ((ScriptID 601 1) y:) 19) ; rgnBoat, rgnBoat
			setPri: ((ScriptID 601 2) priority:) ; monk
		)
		((ScriptID 601 2) ; monk
			posn: (- ((ScriptID 601 1) x:) 70) (+ ((ScriptID 601 1) y:) 25) ; rgnBoat, rgnBoat
		)
		((ScriptID 601 1) setPri: ((ScriptID 601 2) priority:)) ; rgnBoat, monk
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (if (> gHowFast 0) 2 else 3))
				(HandsOn)
				(gTheIconBar disable: 0 4 5)
				((ScriptID 601 1) ; rgnBoat
					setLoop: 3
					setCel: 2
					posn: 0 138
					signal: 18432
					setStep: temp0 temp0
					init:
					setMotion: MoveTo 409 53 self
				)
				((ScriptID 601 2) ; monk
					view: 585
					setLoop: 1
					cycleSpeed: 24
					posn:
						(- ((ScriptID 601 1) x:) 70) ; rgnBoat
						(+ ((ScriptID 601 1) y:) 25) ; rgnBoat
					signal: 16384
					init:
					setCycle: Fwd
				)
				((ScriptID 601 3) ; robin
					view: 22
					setLoop: 0
					setCel: 0
					illegalBits: 0
					posn:
						(- ((ScriptID 601 1) x:) 36) ; rgnBoat
						(+ ((ScriptID 601 1) y:) 19) ; rgnBoat
					signal: 16384
					init:
				)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

