;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2980)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use ROsc)
(use Osc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_2980 0
)

(local
	local0 = 1
	local1 = 1
)

(procedure (localproc_0 param1 param2)
	(if (!= param1 local0)
		(gCurRoom setScript: (gotoNewPosn next: param2 yourself:) 0 param1)
	else
		(gCurRoom setScript: param2)
	)
)

(procedure (localproc_1 param1)
	(= local1 local0)
	(= local0 param1)
	(if (!= local1 local0)
		(switch local1
			(2
				(rooker
					view: 29802
					loop: 0
					cel: 0
					posn: 37 267
					cycleSpeed: 10
					setCycle: Osc -1
				)
				(UpdateScreenItem rooker)
			)
			(3
				(pacmeyer
					view: 29808
					loop: 0
					cel: 0
					posn: 118 295
					cycleSpeed: 10
					setCycle: Osc -1
				)
				(UpdateScreenItem pacmeyer)
			)
			(else
				(pup dispose:)
			)
		)
		(switch local0
			(4
				(pup view: 29804 loop: 0 cel: 0 posn: 490 242 setPri: 300 init:)
			)
			(2
				(rooker
					view: 29803
					loop: 0
					cel: 0
					posn: 37 276
					setCycle: ROsc -1 0 26
				)
			)
			(3
				(pacmeyer
					view: 29809
					loop: 0
					cel: 0
					posn: 119 295
					setCycle: ROsc -1 0 5
				)
			)
		)
	)
)

(instance s2_2980 of PQRoom
	(properties
		picture 2980
	)

	(method (init)
		(super init: &rest)
		(SetFlag 65)
		(SetFlag 121)
		(swatVan init:)
		(tape init:)
		(eastExit init:)
		(cond
			((IsFlag 76)
				(ClearFlag 76)
				(gCurRoom setScript: sOpeningScript)
			)
			((== gPrevRoomNum 2990) ; s2_2990
				(= local0 1)
				(Load rsVIEW 29803)
				(Load rsVIEW 29804)
				(Load rsVIEW 29809)
				(gCurRoom setScript: sEgoComesOut)
			)
			((== gPrevRoomNum 4052) ; s2_405
				(if (IsFlag 233)
					(ClearFlag 233)
					(self setScript: sMoveOutOfficers)
				else
					(sit init: setCycle: Osc -1)
					(stand init: setCycle: Osc -1)
					(rooker cycleSpeed: 10 init: setCycle: Osc -1)
					(pacmeyer cycleSpeed: 10 init: setCycle: Osc -1)
					(pup
						view: 29804
						loop: 0
						cel: 0
						posn: 490 242
						setPri: 300
						init:
					)
					((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
					(= local0 4)
					(gGame handsOn:)
				)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (dispose)
		(ClearFlag 65)
		(proc4_5)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 2990) (gTimers contains: (ScriptID 4054 4))) ; s2_2990, egoTakingTooLongTimer
			((ScriptID 4054 4) dispose: delete:) ; egoTakingTooLongTimer
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (setScript)
		(if (gTimers contains: (ScriptID 4054 4)) ; egoTakingTooLongTimer
			((ScriptID 4054 4) dispose: delete:) ; egoTakingTooLongTimer
		)
		(super setScript: &rest)
	)
)

(instance sOpeningScript of Script
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(Palette 2 42 254 0) ; PalIntensity
				(gKeyDownHandler delete: self)
				(FrameOut)
				(event claimed: 1)
				(proc4_5)
				(gCurRoom newRoom: 2990) ; s2_2990
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tobin init:)
				(if (gBackMusic handle:)
					(gBackMusic stop:)
				)
				(WalkieTalkie showFrame: 29855 0 -2 84)
				(= global128 29855)
				(= cycles 1)
				(tobin setPri: 250 setCycle: End tobin)
			)
			(1
				((gSwatInterface curSwatButn:) doVerb:)
				(gMessager say: 0 0 1 0 self) ; "Officer down. 612 Haley, Central Area. Code 3."
			)
			(2
				(proc4_5)
				(proc4_6 29855 -2 84 0 0 312 1)
			)
			(3
				(gCurRoom newRoom: 2990) ; s2_2990
			)
		)
	)
)

(instance sEgoComesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 29902)
				(sit init: setCycle: Osc -1)
				(stand init: setCycle: Osc -1)
				(rooker cycleSpeed: 10 init: setCycle: Osc -1)
				(pacmeyer cycleSpeed: 10 init: setCycle: Osc -1)
				(far init: setCycle: End far)
				(pup cel: 10 init: setPri: 312 setCycle: CT 47 1 self)
			)
			(1
				(pup setCycle: ROsc -1 47 66)
				(= local0 1)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance talkHancockRooker of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1
					(cond
						((SetFlag 215) 29808)
						((IsFlag 210) 29824)
						((IsFlag 211) 29823)
						((IsFlag 212) 29822)
						((IsFlag 213) 29821)
						((IsFlag 214) 29820)
					)
				)
				(gGame showCloseUp: temp1 -1 -1 self 1)
			)
			(1
				(SetFlag 302)
				(SetFlag 217)
				(localproc_1 2)
				(Palette 2 42 245 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance noMrsTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 301)
					(gGame showCloseUp: 29805 -1 -1 self 1)
					(= cycles 1)
				else
					(gGame showCloseUp: 29804 -1 -1 self 1)
					(= cycles 1)
					(SetFlag 301)
				)
			)
			(1
				(localproc_1 2)
				(Palette 2 42 245 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance afterTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 29806 -1 -1 self 1)
				(= cycles 1)
			)
			(1
				(localproc_1 2)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance sSecTalkPac of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 29811 -1 -1 self 1)
			)
			(1
				(localproc_1 3)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance sFirstTalkPac of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 29810 -1 -1 self 1)
			)
			(1
				(localproc_1 3)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				((ScriptID 4054 4) setReal: (ScriptID 4054 4) 15) ; egoTakingTooLongTimer, egoTakingTooLongTimer
				(self dispose:)
			)
		)
	)
)

(instance sMoveOutOfficers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rooker
					view: 29812
					loop: 0
					cel: 0
					posn: 311 219
					setPri: 300
					init:
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 3000) ; s2_3000
			)
		)
	)
)

(instance rooker of Prop
	(properties
		x 37
		y 267
		view 29802
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(cond
					((IsFlag 302)
						(localproc_0 2 afterTalk)
					)
					((IsFlag 214)
						(localproc_0 2 talkHancockRooker)
					)
					(else
						(localproc_0 2 noMrsTalk)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties
		x 118
		y 295
		view 29808
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (IsFlag 234)
					(localproc_0 3 sSecTalkPac)
				else
					(SetFlag 234)
					(localproc_0 3 sFirstTalkPac)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tobin of Prop
	(properties
		x -1
		y 333
		view 29815
	)

	(method (cue)
		(self dispose:)
	)
)

(instance sit of Prop
	(properties
		x 469
		y 214
		view 29814
	)
)

(instance stand of Prop
	(properties
		x 434
		y 243
		view 29824
		cycleSpeed 10
	)
)

(instance far of Prop
	(properties
		x 129
		y 201
		view 29816
	)

	(method (cue)
		(self dispose:)
	)
)

(instance pup of Prop
	(properties
		x 674
		y 402
		view 29811
	)
)

(instance tape of View
	(properties
		x -51
		y 404
		view 2980
	)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 620
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(localproc_0 1 (changeRooms register: 1 yourself:))
	)
)

(instance swatVan of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 451 152 513 146 561 152 563 174 577 177 584 193 588 207 582 224 526 239 451 236
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(gGame handsOff:)
			(localproc_0 4 (changeRooms register: 4 yourself:))
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gotoNewPosn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local0
					(2
						(rooker cycleSpeed: 6 setCycle: CT 42 1 self)
					)
					(3
						(pacmeyer cycleSpeed: 6 setCycle: CT 24 1 self)
					)
					(4
						(pup setCycle: End self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance changeRooms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(4
						(gCurRoom newRoom: 4052) ; s2_405
					)
					(1
						(gCurRoom newRoom: 2990) ; s2_2990
					)
				)
			)
		)
	)
)

