;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29260)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm29v260 0
)

(local
	[local0 9] = [224 220 206 184 156 128 104 86 81]
	[local9 9] = [60 62 64 68 73 80 88 97 106]
)

(procedure (localproc_0 param1 param2 param3)
	(param1
		createPoly:
			param2
			(+ param3 5)
			param2
			(+ param3 11)
			(+ param2 6)
			(+ param3 16)
			(+ param2 12)
			(+ param3 16)
			(+ param2 18)
			(+ param3 11)
			(+ param2 18)
			(+ param3 5)
			(+ param2 12)
			param3
			(+ param2 6)
			param3
	)
)

(instance rm29v260 of ShiversRoom
	(properties
		picture 29260
	)

	(method (init)
		(efExitBack init: 8)
		(efExitPlaque init: 3)
		(spEarth init:)
		(spVenus init:)
		(spMars init:)
		(if (IsFlag 61)
			(efExitDown init: 5)
		)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29010
	)

	(method (init)
		(self createPoly: 0 0 0 143 20 143 20 20 243 20 243 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29810
	)

	(method (init)
		(self createPoly: 194 112 177 97 202 94 219 109)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 29510
	)

	(method (init)
		(self
			createPoly: 187 130 139 135 85 130 76 124 82 119 139 111 183 116 199 123
		)
		(super init: &rest)
	)
)

(instance spVenus of ShiversProp
	(properties
		priority 1
		fixPriority 1
		view 29261
		loop 1
	)

	(method (init)
		(if (IsFlag 61)
			(= cel (self lastCel:))
		else
			(localproc_0 self 60 66)
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(event localize: gThePlane)
		(if
			(and
				(self onMe: event)
				(gUser canControl:)
				(not global184)
				(not (IsFlag 61))
			)
			(event claimed: 1)
			(gSounds play: 12907 0 90 0)
			(repeat
				(= temp2 (Event new:))
				(temp2 localize: gThePlane)
				(= temp0 (temp2 x:))
				(for ((= temp3 0)) (< temp3 9) ((++ temp3))
					(if (<= temp0 (+ [local9 temp3] 9))
						(break)
					)
				)
				(= cel temp3)
				(if (!= temp4 cel) ; UNINIT
					(= temp4 cel)
					(UpdateScreenItem self)
					(FrameOut)
				)
				(if (& (temp2 type:) evMOUSERELEASE)
					(if (>= cel 5)
						(self setCel: 8)
						(UpdateScreenItem self)
						(FrameOut)
						(if (== (spMars cel:) 8)
							(SetFlag 61)
							(proc951_15 6750)
						)
					)
					(localproc_0 self [local9 cel] 66)
					(break)
				)
				(temp2 dispose:)
			)
			(temp2 dispose:)
			(if (IsFlag 61)
				(gCurRoom newRoom: 29510) ; rm29v510
			)
			(gSounds stop: 12907)
		)
		(super handleEvent: event &rest)
	)
)

(instance spEarth of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 29261
		loop 2
	)

	(method (init)
		(localproc_0 self 90 64)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance spMars of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 29261
	)

	(method (init)
		(if (IsFlag 61)
			(= cel (self lastCel:))
		else
			(localproc_0 self 224 66)
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(event localize: gThePlane)
		(if
			(and
				(self onMe: event)
				(gUser canControl:)
				(not global184)
				(not (IsFlag 61))
			)
			(event claimed: 1)
			(gSounds play: 12912 0 90 0)
			(repeat
				(= temp2 (Event new:))
				(temp2 localize: gThePlane)
				(= temp0 (temp2 x:))
				(for ((= temp3 0)) (< temp3 9) ((++ temp3))
					(if (>= temp0 (+ [local0 temp3] 9))
						(break)
					)
				)
				(= cel temp3)
				(if (!= temp4 cel) ; UNINIT
					(= temp4 cel)
					(UpdateScreenItem self)
					(FrameOut)
				)
				(if (& (temp2 type:) evMOUSERELEASE)
					(if (>= cel 5)
						(self setCel: 8)
						(UpdateScreenItem self)
						(FrameOut)
						(if (== (spVenus cel:) 8)
							(SetFlag 61)
							(proc951_15 6750)
						)
					)
					(localproc_0 self [local0 cel] 66)
					(break)
				)
				(temp2 dispose:)
			)
			(temp2 dispose:)
			(if (IsFlag 61)
				(gCurRoom newRoom: 29510) ; rm29v510
			)
			(gSounds stop: 12912)
		)
		(super handleEvent: event &rest)
	)
)

