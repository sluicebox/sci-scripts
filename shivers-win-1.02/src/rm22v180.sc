;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22180)
(include sci.sh)
(use Main)
(use n951)
(use n22001)
(use Motion)
(use Actor)
(use System)

(public
	rm22v180 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm22v180 of ShiversRoom
	(properties
		picture 22180
	)

	(method (init)
		(= local3 -1)
		(= local6 -1)
		(hsDrumRam init:)
		(hsDrumTa init:)
		(hsDrumBo init:)
		(hsDrumBa init:)
		(hsMalletHolder init:)
		(hsMask init:)
		(mallet init: hide:)
		(vMalletInHand init:)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(proc22001_1)
		(gSounds play: 22201 -1 0 0)
		(gSounds fade: 22201 0 5 16 1 0)
	)

	(method (newRoom)
		(gSounds interruptChain:)
		(proc22001_0)
		(gSounds play: 22201 -1 0 0)
		(gSounds fade: 22201 74 5 16 0 0)
		(super newRoom: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22320
	)

	(method (init)
		(self createPoly: 263 0 215 0 215 78 262 78 262 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22340
	)
)

(instance hsMalletHolder of HotSpot
	(properties)

	(method (init)
		(self createPoly: 149 38 166 50 134 82 122 68 149 38)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sReturnMallet)
	)
)

(instance hsMask of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 139 37 131 33 126 23 128 13 133 7 139 5 145 9 150 16 150 29 144 35
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local6 5)
			(gSounds play: 35135 0 122 0)
		)
	)
)

(instance vMalletInHand of View
	(properties
		priority 25
		fixPriority 1
		view 22180
		loop 4
	)
)

(instance mallet of Prop
	(properties
		x 40
		y 40
		view 22180
		loop 5
	)

	(method (doit &tmp temp0 temp1)
		(if (and local0 (not local2))
			(= temp0 (+ (- gMouseX 27) 17))
			(= temp1 (+ (- gMouseY 7) 14))
			(self posn: temp0 temp1)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(super doit: &rest)
	)
)

(instance hsDrumRam of HotSpot
	(properties)

	(method (doVerb)
		(if local0
			(if (or (== local3 -1) (and (== local1 0) (== local3 4)))
				(+= local3 1)
			else
				(= local3 -1)
			)
			(if (or (== local6 -1) (and (== local1 2) (mod local6 2)))
				(+= local6 1)
				(PrintDebug {%d} local6)
			else
				(= local6 -1)
			)
			(= local1 3)
			(= local4 0)
			(PrintDebug {RAM})
			(gCurRoom setScript: sDrumHit)
		)
	)

	(method (init)
		(self createPoly: 121 123 121 143 202 143 192 123 122 123)
		(super init: &rest)
	)
)

(instance hsDrumTa of HotSpot
	(properties)

	(method (doVerb)
		(if local0
			(if
				(or
					(and (== local1 3) (== local3 0))
					(and (== local1 1) (== local3 3))
				)
				(+= local3 1)
			else
				(= local3 -1)
			)
			(= local6 -1)
			(= local1 0)
			(= local4 2)
			(PrintDebug {TA})
			(gCurRoom setScript: sDrumHit)
		)
	)

	(method (init)
		(self
			createPoly: 90 82 48 82 44 75 44 68 46 62 58 59 82 59 90 61 95 65 97 70 96 76 90 82
		)
		(super init: &rest)
	)
)

(instance hsDrumBo of HotSpot
	(properties)

	(method (doVerb)
		(if local0
			(if (and (== local1 0) (== local3 1))
				(+= local3 1)
			else
				(= local3 -1)
			)
			(if (and (== local1 3) (not (mod local6 2)))
				(+= local6 1)
				(PrintDebug {%d} local6)
			else
				(= local6 -1)
			)
			(= local1 2)
			(= local4 1)
			(PrintDebug {BO})
			(gCurRoom setScript: sDrumHit)
		)
	)

	(method (init)
		(self
			createPoly: 189 83 262 83 262 127 212 127 210 123 210 113 199 113 199 123 187 122 187 83 190 83
		)
		(super init: &rest)
	)
)

(instance hsDrumBa of HotSpot
	(properties)

	(method (doVerb)
		(if local0
			(if
				(or
					(and (== local1 2) (== local3 2))
					(and (== local1 3) (== local3 5))
				)
				(+= local3 1)
			else
				(= local3 -1)
			)
			(= local6 -1)
			(= local1 1)
			(= local4 3)
			(PrintDebug {BA})
			(gCurRoom setScript: sDrumHit)
		)
	)

	(method (init)
		(self
			createPoly: 90 142 98 123 99 107 95 86 42 86 38 115 40 124 46 143 89 144
		)
		(super init: &rest)
	)
)

(instance spDrumHead of ShiversProp
	(properties
		view 22180
	)
)

(instance sDrumHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(gSounds stop: (+ 22208 local5))
				(mallet cel: 0 setPri: 255 1)
				(= cycles 1)
			)
			(1
				(if (== local4 1)
					(spDrumHead cycleSpeed: 35)
				else
					(spDrumHead cycleSpeed: 1)
				)
				(spDrumHead
					loop: local1
					setPri: 150 1
					cel: 0
					setCycle: End
					init:
				)
				(gSounds play: (+ 22208 local4) 0 122 0)
				(= cycles 1)
			)
			(2
				(= local2 0)
				(spDrumHead dispose:)
				(= local5 local4)
				(mallet setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sReturnMallet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gSounds interruptChain:)
				)
				(= cycles 2)
			)
			(1
				(if local0
					(PrintDebug {drop})
					(mallet hide:)
					(vMalletInHand setCel: 0)
					(if (!= local3 6)
						(gSounds stop: 12202)
						(gSounds play: 12202 0 30 0)
					)
					(gNormalCursor show:)
					(= local0 0)
					(efExitLeft init: 2)
					(efExitRight init: 1)
					(gTheDoits delete: mallet)
					(proc951_9 22201)
					(gSounds play: 22201 -1 0 0)
					(gSounds fade: 22201 74 5 16 0 0)
					(proc22001_0)
				else
					(PrintDebug {grab})
					(gSounds fade: 22201 0 5 16 1 0)
					(proc22001_1)
					(gSounds play: 12201 0 30 0)
					(= local0 1)
					(gNormalCursor hide:)
					(mallet show:)
					(vMalletInHand setCel: 1)
					(efExitLeft dispose:)
					(efExitRight dispose:)
					(gTheDoits add: mallet)
				)
				(= cycles 1)
			)
			(2
				(if (== local3 6)
					(gCurRoom newRoom: 22250) ; rm22v250
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

