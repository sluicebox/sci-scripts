;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7111)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm7v111 0
)

(local
	local0
	[local1 12]
)

(procedure (localproc_0)
	(if
		(and
			(*
				[local1 0]
				[local1 1]
				[local1 3]
				[local1 5]
				[local1 6]
				[local1 11]
			)
			(==
				0
				(+
					[local1 2]
					[local1 4]
					[local1 7]
					[local1 8]
					[local1 9]
					[local1 10]
				)
			)
		)
		(SetFlag 64)
		(gSounds play: 10707 0 40 0)
		(pKey cel: 0 setLoop: 13 setCycle: End)
		(proc951_15 6750)
		(PrintDebug {Workshop puzzle solved! })
	)
)

(instance rm7v111 of ShiversRoom
	(properties
		picture 7111
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(pKey init:)
		(pDrawer0 init:)
		(pDrawer1 init:)
		(pDrawer2 init:)
		(pDrawer3 init:)
		(pDrawer4 init:)
		(pDrawer5 init:)
		(pDrawer6 init:)
		(pDrawer7 init:)
		(pDrawer8 init:)
		(pDrawer9 init:)
		(pDrawer10 init:)
		(pDrawer11 init:)
		(if (IsFlag 64)
			(efExitDown init: 5)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(if (== local0 1)
			(gSounds play: 10703 0 40 0)
		)
		(if (> local0 1)
			(gSounds play: 10704 0 40 0)
		)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 7410 createPoly: 0 0 0 130 28 131 26 13 32 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 7100 createPoly: 246 0 252 12 248 131 264 132 264 0)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 7112
	)

	(method (init)
		(self
			createPoly: 0 123 161 123 161 137 184 137 184 123 263 123 263 143 0 143 0 124
		)
		(super init: &rest)
	)
)

(class Drawer of ShiversProp
	(properties
		priority 40
		drawerNum 0
	)

	(method (init)
		(self setPri: (- 40 (self drawerNum:)))
		(super init: &rest)
	)

	(method (doVerb)
		(if (== (self cel:) 0)
			(self setScript: sDrawerOpen)
			(= [local1 (self drawerNum:)] 1)
			(++ local0)
		else
			(self setScript: sDrawerClose)
			(= [local1 (self drawerNum:)] 0)
			(-- local0)
		)
		(localproc_0)
	)
)

(instance sDrawerOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10702 0 40 self)
				(client setCycle: End)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrawerClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10703 0 40 self)
				(client setCycle: Beg)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pDrawer0 of Drawer
	(properties
		view 7110
	)
)

(instance pDrawer1 of Drawer
	(properties
		view 7110
		loop 1
		drawerNum 1
	)
)

(instance pDrawer2 of Drawer
	(properties
		view 7110
		loop 2
		drawerNum 2
	)
)

(instance pDrawer3 of Drawer
	(properties
		view 7110
		loop 3
		drawerNum 3
	)
)

(instance pDrawer4 of Drawer
	(properties
		view 7110
		loop 4
		drawerNum 4
	)
)

(instance pDrawer5 of Drawer
	(properties
		view 7110
		loop 5
		drawerNum 5
	)
)

(instance pDrawer6 of Drawer
	(properties
		view 7110
		loop 6
		drawerNum 6
	)
)

(instance pDrawer7 of Drawer
	(properties
		view 7110
		loop 7
		drawerNum 7
	)
)

(instance pDrawer8 of Drawer
	(properties
		view 7110
		loop 8
		drawerNum 8
	)
)

(instance pDrawer9 of Drawer
	(properties
		view 7110
		loop 9
		drawerNum 9
	)
)

(instance pDrawer10 of Drawer
	(properties
		view 7110
		loop 10
		drawerNum 10
	)
)

(instance pDrawer11 of Drawer
	(properties
		view 7110
		loop 11
		drawerNum 11
	)
)

(instance pKey of ShiversProp
	(properties
		priority 25
		view 7110
		loop 13
	)

	(method (init)
		(self
			loop: 13
			cel: 0
			setPri: 25
			cycleSpeed: 6
			createPoly: 163 119 163 137 179 136 178 119
		)
		(if (IsFlag 64)
			(self setCel: (self lastCel:))
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 64)
			(self setScript: sCupboardOpen)
		else
			(self setScript: sKeyStuck)
		)
	)
)

(instance sCupboardOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pKey loop: 12 cel: 0 setCycle: End)
				(gSounds play: 10706 0 40 self)
			)
			(1
				(cond
					((== local0 1)
						(gSounds play: 10703 0 40 self)
					)
					((> local0 1)
						(gSounds play: 10704 0 40 self)
					)
					(else
						(= ticks 1)
					)
				)
				(= local0 0)
				(pDrawer0 cel: 0)
				(pDrawer1 cel: 0)
				(pDrawer3 cel: 0)
				(pDrawer5 cel: 0)
				(pDrawer6 cel: 0)
				(pDrawer11 cel: 0)
			)
			(2
				(gCurRoom newRoom: 7112) ; rm7v112
				(self dispose:)
			)
		)
	)
)

(instance sKeyStuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10705 0 40 self)
				(pKey loop: 12 cel: 1)
				(= seconds 2)
			)
			(1
				(pKey cel: 2)
				(= seconds 1)
			)
			(2
				(pKey cel: 1)
			)
			(3
				(pKey cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

