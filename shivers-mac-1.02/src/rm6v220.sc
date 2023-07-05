;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6220)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm6v220 0
)

(local
	local0
	local1
)

(instance rm6v220 of ShiversRoom
	(properties
		picture 6220
		invView 2
	)

	(method (init)
		(if (<= 6227 gPrevRoomNum 6228) ; rm6v227, rm6v228
			(gSounds play: 10621 0 58 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efRecorder init: 0)
		(efBook init: 0)
		(vDrawerBack init:)
		(pTopDrawer init:)
		(pDrawer init:)
		(pTLD init:)
		(hsDrawerClosed init:)
		(if (and (!= gPrevRoomNum 6227) (!= gPrevRoomNum 6228)) ; rm6v227, rm6v228
			(= local0 0)
			(hsTopDrawerClosed init:)
		)
		(if (or (== gPrevRoomNum 6227) (== gPrevRoomNum 6228)) ; rm6v227, rm6v228
			(= local0 1)
			(hsTopDrawerOpen init:)
			(pTopDrawer setCel: (pTopDrawer lastCel:))
			(efLetter init:)
		)
		(super init: &rest)
		(if (and (== gPrevRoomNum 930) global186) ; introMovie
			(vDialog init:)
			(hsDialogArea init:)
			(proc951_7 20601)
			(proc951_9 20601)
			(gSounds play: 20601 -1 0 0)
			(gSounds fade: 20601 10 15 5 0 0)
			(gSounds playChain: -1 -4 20602 -1)
			(gSounds adjChainVol: 34)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 6228) (!= newRoomNumber 6227) (or local0 local1)) ; rm6v228, rm6v227
			(gSounds play: 10609 0 40 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6210
	)
)

(instance efRecorder of ExitFeature
	(properties
		nextRoom 6240
	)

	(method (init)
		(self createPoly: 127 87 91 74 92 72 115 66 147 76 147 81)
		(super init: &rest)
	)
)

(instance efBook of ExitFeature
	(properties
		nextRoom 6221
	)

	(method (init)
		(self
			createPoly: 218 83 199 83 194 75 209 73 217 71 228 73 238 82 220 82
		)
		(super init: &rest)
	)
)

(instance efLetter of ExitFeature
	(properties
		nextRoom 6227
	)

	(method (init)
		(self createPoly: 220 91 220 98 204 98 204 91 220 91)
		(super init: &rest)
	)
)

(instance hsTopDrawerOpen of HotSpot
	(properties)

	(method (init)
		(self createPoly: 196 99 196 110 233 110 233 99 196 99)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sTopClose)
	)
)

(instance hsTopDrawerClosed of HotSpot
	(properties)

	(method (init)
		(self createPoly: 192 90 192 103 227 103 229 91 195 90 193 90)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sTopOpen)
	)
)

(instance hsDrawerOpen of HotSpot
	(properties)

	(method (init)
		(self createPoly: 195 119 192 142 228 143 231 119 197 120)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sBottomClose)
	)
)

(instance hsDrawerClosed of HotSpot
	(properties)

	(method (init)
		(self createPoly: 187 103 186 131 224 131 229 103 188 103)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not local0)
			(gCurRoom setScript: sBottomOpen)
		)
	)
)

(instance pDrawer of Prop
	(properties
		priority 25
		fixPriority 1
		view 6220
	)
)

(instance pTopDrawer of Prop
	(properties
		priority 26
		fixPriority 1
		view 6220
		loop 2
	)
)

(instance vDrawerBack of View
	(properties
		priority 1
		fixPriority 1
		view 6220
		loop 1
	)
)

(instance psInDrawer of PotSpot
	(properties
		nsLeft 194
		nsTop 101
		nsRight 222
		nsBottom 125
	)
)

(instance hsDialogArea of HotSpot
	(properties
		nsRight 266
		nsBottom 143
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vDialog dispose:)
		(self dispose:)
	)
)

(instance vDialog of View
	(properties
		x 44
		y 120
		priority 250
		fixPriority 1
		view 921
		loop 1
	)
)

(instance sTopClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10609 0 40 0)
				(= local0 0)
				(hsDrawerClosed init:)
				(pTopDrawer setCycle: Beg self)
				(efLetter dispose:)
				(hsTopDrawerClosed init:)
				(hsTopDrawerOpen dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTopOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10608 0 40 0)
				(= local0 1)
				(pTopDrawer setCycle: End self)
				(efLetter init:)
				(hsTopDrawerOpen init:)
				(proc951_7 10609)
				(hsTopDrawerClosed dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBottomClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10609 0 40 0)
				(= local0 0)
				(hsTopDrawerClosed init:)
				(pDrawer setCycle: Beg self)
				(hsDrawerClosed init:)
				(hsDrawerOpen dispose:)
				(psInDrawer dispose:)
				(if (!= global106 0)
					(gShiversRoomItem dispose:)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBottomOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10608 0 40 0)
				(= local0 1)
				(hsTopDrawerClosed dispose:)
				(pDrawer setCycle: End self)
				(proc951_7 10609)
				(hsDrawerClosed dispose:)
				(gCurRoom initRoom: 194 222 101 125)
				(psInDrawer init:)
				(hsDrawerOpen init:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pTLD of ShiversProp
	(properties
		x 40
		y 91
		priority 25
		fixPriority 1
		view 6220
		loop 4
	)

	(method (doVerb)
		(if local1
			(gSounds play: 10609 0 40 0)
			(self setCycle: Beg)
			(= local1 0)
		else
			(gSounds play: 10608 0 40 0)
			(self setCycle: End)
			(= local1 1)
		)
	)
)

