;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21070)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm21v070 0
)

(local
	local0
)

(instance rm21v070 of ShiversRoom
	(properties
		picture 21070
		invView 2
	)

	(method (init)
		(pPuzzleDrawer init:)
		(pPotDrawer init:)
		(vPotDrawerBack init:)
		(if (== gPrevRoomNum 21071) ; PeggedPuzzleRm
			(= local0 1)
			(pPuzzleDrawer cel: (pPuzzleDrawer lastCel:))
			(hsDrawerOpen init:)
			(efExitPuzzle init: 0)
		else
			(hsDrawerClosed init:)
		)
		(if (IsFlag 21)
			(if (not (IsFlag 83))
				(SetFlag 83)
				(gCurRoom setScript: sJustWonPuzzle)
			else
				(pPotDrawer cel: (pPotDrawer lastCel:))
			)
			(gCurRoom initRoom: 174 191 88 105)
			(psInDrawer init:)
		)
		(efExitLeft init: 2)
		(efExitBack init: 8)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and local0 (!= newRoomNumber 21071)) ; PeggedPuzzleRm
			(gSounds play: 12105 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21060
	)

	(method (init)
		(self
			createPoly: 26 0 26 142 263 142 264 0 203 0 203 140 67 140 67 0 26 0
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21050
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 21071
	)

	(method (init)
		(self createPoly: 98 98 85 106 130 112 137 106 136 102 98 98)
		(super init: &rest)
	)
)

(instance hsDrawerOpen of HotSpot
	(properties)

	(method (init)
		(self createPoly: 72 106 133 113 134 142 74 135 72 107)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDrawerClose)
	)
)

(instance hsDrawerClosed of HotSpot
	(properties)

	(method (init)
		(self createPoly: 92 95 147 99 146 126 91 119 92 96)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDrawerOpen)
	)
)

(instance hsPotDrawerClosed of HotSpot ; UNUSED
	(properties)

	(method (init)
		(self createPoly: 176 82 164 97 164 123 177 104 177 81 176 82)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sPotDrawerOpen)
	)
)

(instance hsPotDrawerOpen of HotSpot ; UNUSED
	(properties)

	(method (init)
		(self
			createPoly: 164 103 198 106 198 100 203 88 206 92 205 109 197 126 196 122 163 118 164 104
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sPotDrawerClose)
	)
)

(instance pPuzzleDrawer of Prop
	(properties
		priority 25
		fixPriority 1
		view 21070
	)
)

(instance pPotDrawer of Prop
	(properties
		priority 25
		fixPriority 1
		view 21072
	)
)

(instance vPotDrawerBack of View
	(properties
		priority 20
		fixPriority 1
		view 21072
		loop 1
	)
)

(instance psInDrawer of PotSpot
	(properties
		nsLeft 174
		nsTop 88
		nsRight 191
		nsBottom 107
	)
)

(instance sDrawerClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12105 0 82 0)
				(PrintDebug {Close Drawer})
				(= local0 0)
				(hsDrawerClosed init:)
				(pPuzzleDrawer setCycle: Beg self)
				(efExitPuzzle dispose:)
				(hsDrawerClosed init:)
				(hsDrawerOpen dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrawerOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12101 0 82 0)
				(PrintDebug {Open Drawer})
				(= local0 1)
				(pPuzzleDrawer setCycle: End self)
				(gSounds play: 12102 0 82 0)
				(efExitPuzzle init:)
				(hsDrawerOpen init:)
				(hsDrawerClosed dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPotDrawerClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12105 0 82 0)
				(PrintDebug {Close Drawer})
				(pPotDrawer setCycle: Beg self)
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

(instance sPotDrawerOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12101 0 82 0)
				(PrintDebug {Open Drawer})
				(pPotDrawer setCycle: End self)
				(gCurRoom initRoom: 174 191 88 105)
				(psInDrawer init:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJustWonPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(= local0 0)
				(gSounds play: 12105 0 82 0)
				(pPotDrawer setCycle: Beg self)
			)
			(2
				(gSounds play: 12101 0 82 0)
				(pPotDrawer setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

