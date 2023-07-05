;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4310)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4310 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s1_4310 of PQRoom
	(properties
		picture 4310
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(leftWall init:)
		(northE init:)
		(southE init:)
		(westE init:)
		(host init: hide:)
		((= local3 (Set new:)) add: dentonGate dentonBush wixell)
		(switch gPrevRoomNum
			(4280 ; s1_4280
				(cond
					((IsFlag 155)
						(ClearFlag 155)
						(gateClosed init:)
						(self setScript: lucysDead 0 0)
					)
					((global112 flashBanged:)
						(gateClosed init:)
						(self setScript: lucysDead 0 1)
					)
				)
			)
			(4290 ; s1_4290
				(cond
					((IsFlag 155)
						(ClearFlag 155)
						(gateClosed init:)
						(self setScript: lucysDead)
					)
					((global112 flashBanged:)
						(gateClosed init:)
						(self setScript: lucysDead)
					)
					(else
						(wixell init:)
						(dentonGate init:)
						(gateOpened init:)
						(global112 resetData: 0)
						(roomTimer setReal: 1 roomTimer 30)
						(gGame handsOn:)
					)
				)
			)
			(else
				(if (IsFlag 161)
					(dentonBush init:)
				else
					(dentonGate init:)
				)
				(wixell init:)
				(gateOpened init:)
				(global112 resetData: 0)
				(roomTimer setReal: 1 roomTimer 30)
				(gGame handsOn:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(SetFlag 156)
				(self setScript: shootRoom)
			)
			(6
				(SetFlag 157)
				(self setScript: shootRoom)
			)
			(16
				(if (IsFlag 161)
					(self setScript: flashGateApart)
				else
					(self setScript: flashGateTogether)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(cond
			((and (proc4_11 14) (== global149 1))
				(self setScript: dentonCovers)
				(return -1)
			)
			(
				(or
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 36)
						(== global149 3)
					)
					(and (proc4_11 17) (proc4_11 35) (== global149 2))
					(and (proc4_11 17) (proc4_11 36) (== global149 2))
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 4)
					)
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 28)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 3)
					)
					(and (proc4_11 17) (proc4_11 43) (== global149 2))
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 35)
						(proc4_11 36)
						(== global149 4)
					)
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 35)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 36)
						(== global149 3)
					)
				)
				(self setScript: sayLash)
				(return -2)
			)
			(else
				(return -1)
			)
		)
	)

	(method (newRoom)
		(if (gCast contains: (ScriptID 36)) ; Mirror
			((ScriptID 36) dispose:) ; Mirror
		)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(= gMyAutoEventCode 0)
		(local3 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance sayLash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 5 0 4 1 self) ; "Copy.""
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance lucysDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(deadLucyOpen init:)
				else
					(deadLucyClosed init:)
				)
				(= seconds 2)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(if (global112 flashBanged:)
					(SetFlag 98)
					(SetFlag 95)
					(SetFlag 103)
					(gCurRoom newRoom: 35) ; metroExt
				else
					(SetFlag 98)
					(SetFlag 95)
					(SetFlag 100)
					(gCurRoom newRoom: 35) ; metroExt
				)
			)
		)
	)
)

(instance flashBangIvy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roomTimer dispose: delete:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang posn: -14 184 init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gMessager say: 4 16 0 0 self) ; "Status! Status!"
			)
			(6
				(gCurRoom newRoom: 4330) ; s1_4330
			)
		)
	)
)

(instance flashGateApart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roomTimer dispose: delete:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
				(Load rsVIEW 43103)
				(Load rsVIEW 43102)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(wixell dispose:)
				(dentonBush dispose:)
				(wixellFlash init: setCycle: End)
				(dentonFlashBush init: setCycle: End self)
			)
			(6
				(gMessager say: 3 16 0 0 self) ; "Status! Status!"
			)
			(7
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashGateTogether of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roomTimer dispose: delete:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
				(Load rsVIEW 43103)
				(Load rsVIEW 43105)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(wixell dispose:)
				(dentonGate dispose:)
				(wixellFlash init: setCycle: End)
				(dentonFlashGate init: setCycle: End self)
			)
			(6
				(gMessager say: 3 16 0 0 self) ; "Status! Status!"
			)
			(7
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance dentonCovers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dentonGate dispose:)
				(dentCovers init: setCycle: End self)
			)
			(1
				(dentCovers dispose:)
				(dentonNodBush init: cel: 0 setCycle: End self)
			)
			(2
				(SetFlag 161)
				(dentonBush init:)
				(dentonNodBush dispose:)
				(roomTimer setReal: 1 roomTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dentBushFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomTimer dispose: delete:)
				(gCurRoom drawPic: 0)
				(gGame handsOff: showCloseUp: 43103 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
				(gMessager say: 0 7 0 0) ; "Cease fire! Cease fire!"
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bothGateFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomTimer dispose: delete:)
				(gCurRoom drawPic: 0)
				(gGame handsOff: showCloseUp: 43105 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
				(gMessager say: 0 7 0 0) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bothBushFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomTimer dispose: delete:)
				(gCurRoom drawPic: 0)
				(gGame handsOff: showCloseUp: 43106 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
				(gMessager say: 0 7 0 0) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance dentThumbsGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dentonGate hide:)
				(dentonThumbGate init: cel: 0 setCycle: End self)
			)
			(1
				(dentonGate show:)
				(dentonThumbGate dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance dentThumbsBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dentonBush hide:)
				(dentonThumbBush init: cel: 0 setCycle: End self)
			)
			(1
				(dentonBush show:)
				(dentonThumbBush dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance wixellThumbsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wixell hide:)
				(wixellThumb init: cel: 0 setCycle: End self)
			)
			(1
				(wixell show:)
				(wixellThumb dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance dentNodsGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dentonGate hide:)
				(dentonNodGate init: cel: 0 setCycle: End self)
			)
			(1
				(dentonGate show:)
				(dentonNodGate dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance dentNodsBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dentonBush hide:)
				(dentonNodBush init: cel: 0 setCycle: End self)
			)
			(1
				(dentonBush show:)
				(dentonNodBush dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance wixellNods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wixell hide:)
				(wixellNod init: cel: 0 setCycle: End self)
			)
			(1
				(wixell show:)
				(wixellNod dispose:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance dentonGate of View
	(properties
		x 45
		y 245
		view 43104
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: bothGateFire)
			)
			(6
				(gCurRoom setScript: bothGateFire)
			)
			(45
				(gCurRoom setScript: dentThumbsGate)
			)
			(44
				(gCurRoom setScript: dentonCovers)
			)
			(48
				(gCurRoom setScript: dentNodsGate)
			)
			(43
				(gCurRoom setScript: dentNodsGate)
			)
			(42
				(gCurRoom setScript: dentNodsGate)
			)
			(47
				(gCurRoom setScript: dentNodsGate)
			)
			(49
				(gCurRoom setScript: dentThumbsGate)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dentonBush of View
	(properties
		x 300
		y 275
		view 43102
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: bothBushFire)
			)
			(6
				(gCurRoom setScript: bothBushFire)
			)
			(45
				(gCurRoom setScript: dentThumbsBush)
			)
			(44
				(gCurRoom setScript: dentNodsBush)
			)
			(48
				(gCurRoom setScript: dentNodsBush)
			)
			(43
				(gCurRoom setScript: dentNodsBush)
			)
			(42
				(gCurRoom setScript: dentNodsBush)
			)
			(47
				(gCurRoom setScript: dentNodsBush)
			)
			(49
				(gCurRoom setScript: dentThumbsBush)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wixell of View
	(properties
		x 40
		y 205
		view 43107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(if (IsFlag 161)
					(gCurRoom setScript: dentBushFire)
				else
					(gCurRoom setScript: bothGateFire)
				)
			)
			(6
				(if (IsFlag 161)
					(gCurRoom setScript: dentBushFire)
				else
					(gCurRoom setScript: bothGateFire)
				)
			)
			(45
				(gCurRoom setScript: wixellThumbsUp)
			)
			(44
				(gCurRoom setScript: wixellThumbsUp)
			)
			(48
				(gCurRoom setScript: wixellNods)
			)
			(43
				(gCurRoom setScript: wixellNods)
			)
			(42
				(gCurRoom setScript: wixellNods)
			)
			(47
				(gCurRoom setScript: wixellNods)
			)
			(49
				(if (IsFlag 161)
					(gCurRoom setScript: dentThumbsBush)
				else
					(gCurRoom setScript: dentThumbsGate)
				)
				(host setScript: wixellThumbsUp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deadLucyOpen of View
	(properties
		x 119
		y 358
		view 43100
	)
)

(instance deadLucyClosed of View
	(properties
		x 128
		y 333
		view 43101
	)
)

(instance reflection of View
	(properties
		x 15
		y 342
		view 43110
	)
)

(instance gateClosed of View
	(properties
		x 76
		y 74
		view 43111
	)
)

(instance gateOpened of View
	(properties
		x 136
		y 74
		view 43111
		loop 1
	)
)

(instance dentonFlashGate of Prop
	(properties
		x 45
		y 245
		view 43105
	)
)

(instance dentonThumbGate of Prop
	(properties
		x 45
		y 245
		view 43104
	)
)

(instance dentonNodGate of Prop
	(properties
		x 45
		y 245
		view 43104
		loop 1
	)
)

(instance dentonFlashBush of Prop
	(properties
		x 300
		y 275
		view 43102
	)
)

(instance dentonThumbBush of Prop
	(properties
		x 300
		y 275
		view 43102
		loop 1
	)
)

(instance dentonNodBush of Prop
	(properties
		x 300
		y 275
		view 43102
		loop 2
	)
)

(instance wixellFlash of Prop
	(properties
		x 40
		y 205
		view 43103
	)
)

(instance wixellThumb of Prop
	(properties
		x 40
		y 205
		view 43106
	)
)

(instance wixellNod of Prop
	(properties
		x 40
		y 205
		view 43107
	)
)

(instance dentCovers of Prop
	(properties
		x 45
		y 245
		view 43109
	)
)

(instance flashBang of Prop
	(properties
		x 160
		y 145
		view 43108
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance leftWall of Feature
	(properties
		nsRight 50
		nsBottom 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(global112 threwFlash: 4330)
				(gCurRoom setScript: flashBangIvy)
			)
			(40
				(if (not local1)
					(= local1 1)
					(global112 useMirror: 4320)
					((ScriptID 36) init: add: reflection) ; Mirror
					(reflection init:)
					(mirrorTimer setReal: mirrorTimer 10)
				)
			)
			(48
				(if (IsFlag 161)
					(gCurRoom setScript: dentNodsBush)
				else
					(gCurRoom setScript: dentNodsGate)
				)
				(host setScript: wixellNods)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(if (IsFlag 161)
			(gCurRoom setScript: dentNodsBush)
		else
			(gCurRoom setScript: dentThumbsGate)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32771
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55
				(global112 slicePie: 4320)
				(if (global112 usedMirror:)
					(gCurRoom newRoom: 4320) ; s1_4320
				else
					(gCurRoom newRoom: 4340) ; s1_4340
				)
			)
			(29
				(gCurRoom newRoom: 4340) ; s1_4340
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southE of HotSpot
	(properties
		nsTop 310
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom newRoom: 4340) ; s1_4340
	)
)

(instance roomTimer of Timer
	(properties)

	(method (doit)
		(if (or (gCurRoom script:) (not (gTalkers size:)))
			(super doit: &rest)
		)
	)

	(method (cue)
		(switch local0
			(1
				(gMessager say: 0 0 1 1) ; "Pup! What's your position?!"
				(self setReal: 2 self 30)
			)
			(2
				(gMessager say: 0 0 1 2) ; "Pup, are you in position?!"
				(self setReal: 3 self 30)
			)
			(3
				(gMessager say: 0 0 1 3) ; "Pup! Report! Where are you?"
			)
		)
	)

	(method (setReal param1)
		(= local0 param1)
		(super setReal: &rest)
	)
)

(instance mirrorTimer of Timer
	(properties)

	(method (cue)
		((ScriptID 36) dispose:) ; Mirror
		(= local1 0)
		(self dispose: delete:)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(if (local3 contains: param2)
					(= local2 param2)
				)
				(param1 claimed: 1)
			)
			(local2
				(local2 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

