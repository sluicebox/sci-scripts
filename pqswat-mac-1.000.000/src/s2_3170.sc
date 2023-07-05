;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3170)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use ROsc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s2_3170 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s2_3170 of PQRoom
	(properties
		picture 3170
	)

	(method (init)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(robotFeat init:)
		(furniture init:)
		(cond
			((and (== gPrevRoomNum 3110) (not (global112 slicedPie:))) ; s2_3110
				(gGame handsOff:)
				(global112 pausePath: 1)
				(gCurRoom setScript: sConfrontAllenBadly)
			)
			((== gPrevRoomNum 3150) ; s2_3150
				(gGame handsOff:)
				(global112 pausePath: 1)
				(gCurRoom setScript: sConfrontAllenBadly)
			)
			((<= 14 (global112 curColIdx:) 17)
				(gCurRoom setScript: sConfrontAllen)
			)
			(else
				(gGame handsOn:)
			)
		)
		(if
			(and
				(!= (global112 criticalRoom:) gCurRoomNum)
				(!= (gCurRoom script:) sConfrontAllenBadly)
			)
			(northE init:)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 15))
			(northE dispose:)
			(self setScript: sConfrontAllen)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(allen setScript: sShotAtFurn)
			)
			(6
				(allen setScript: sShotAtFurn)
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(43
				(if local1
					(gMessager say: 0 43 9) ; "What is it, pup?"
				else
					(gMessager say: 0 43 10) ; "What is it?"
				)
			)
			(else
				(if (OneOf theVerb 45 44 46 42 47 49)
					(if local1
						(gMessager say: 0 49 9) ; "What is it?"
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if (gTimers contains: shootTimer)
			(shootTimer dispose: delete:)
		)
		(proc4_5)
		(super dispose:)
	)
)

(instance sConfrontAllen of Script
	(properties)

	(method (cue param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(= temp0 param1)
			(if (== argc 1)
				(= scratch param1)
			)
		)
		(super cue: temp0 &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= temp0
					(switch (global112 curColIdx:)
						(15
							(global112 getPercent: 0 76)
						)
						(17
							(allen cel: 25)
							(hector cel: 25)
							(allenHectorDance start: 1)
							132
						)
						(else
							(if (> (global112 curColIdx:) 17)
								(global112 getPercent: 77 132)
							else
								-1
							)
						)
					)
				)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(if (!= temp0 -1)
					(allen init:)
					(hector init:)
					(proc4_6 31700 -1 146 temp0 0 -1 1)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 1)
					)
					(1
						(= local1 1)
						(gSwatInterface showHandAni: 4)
					)
					(2
						(= local1 0)
					)
					(3
						(= local1 1)
					)
					(4
						(allen setScript: allenHectorDance)
					)
					(5
						(= local1 0)
					)
					(6
						(proc4_5)
						(WalkieTalkie showFrame: 31700 201 -1 146)
						(= global128 31700)
						(++ state)
						(= cycles 2)
					)
				)
			)
			(2
				(wixell init:)
				(denton init:)
				(pac init:)
				(proc4_5)
				(shootTimer setReal: shootTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance allenHectorDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(hector cel: 0 setCycle: CT 25 1)
				(allen cel: 0 setCycle: CT 25 1 self)
			)
			(1
				(allen cel: 25 setCycle: ROsc -1 25 76)
				(hector cel: 25 setCycle: ROsc -1 25 76)
			)
			(2
				(allen setCycle: CT 77 1 self)
				(hector setCycle: CT 77 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDentonShootsAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (allen script:)
					((allen script:) caller: self cue:)
				else
					(= cycles 1)
				)
			)
			(1
				(wixell dispose:)
				(denton dispose:)
				(pac dispose:)
				(gFxSound number: 35 loop: 1 play:)
				(proc4_6 31700 -1 146 202 0 -1 1)
				(hector cel: 78 setCycle: End)
				(allen cel: 78 setCycle: End)
			)
			(2
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 64)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShootAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shootTimer dispose: delete:)
				(hector cel: 65 setCycle: End)
				(allen cel: 65 setCycle: End self)
			)
			(1
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 65)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShootHector of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 31618 -1 -1 self 1)
			)
			(1
				(SetFlag 98)
				(SetFlag 93)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sConfrontAllenBadly of Script
	(properties)

	(method (cue param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(= temp0 param1)
			(if (== argc 1)
				(= scratch param1)
			)
		)
		(super cue: temp0 &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0
					(switch (global112 curColIdx:)
						(14
							(global112 getPercent: 0 60)
						)
						(else 125)
					)
				)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(proc4_6 31701 -1 125 temp0 0 -1 1)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(1
						(gSwatInterface showHandAni: 4)
					)
					(2
						(allenFeat init:)
						(gGame handsOn:)
					)
					(3
						(gGame handsOff:)
					)
				)
			)
			(2
				(SetFlag 93)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (cue param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(= temp0 param1)
			(if (== argc 1)
				(= scratch param1)
			)
		)
		(super cue: temp0 &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(cannister init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 loop: 0 play:)
				(global112 stopPath:)
				(Palette 2 42 254 500) ; PalIntensity
				(cannister dispose:)
				(allen init:)
				(hector init:)
				(if
					(<=
						(= local3
							(if (or (Robot 5) gAutoRobot) ; HasEnded
								(Min 201 (Max 133 (Robot 11))) ; FrameNum
							else
								133
							)
						)
						201
					)
					(proc4_5)
					(WalkieTalkie showFrame: 31700 local3 -1 146)
					(= global128 31700)
				else
					(= register 1)
				)
				(FrameOut)
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
				(if (not register)
					(if (> (allen cel:) 14)
						(gGame handsOff:)
						(gCurRoom setScript: sShootHector)
					else
						(hector setCycle: CT 65 1)
						(allen setCycle: CT 65 1)
						(proc4_6 31700 -1 146 local3 0 -1 1)
					)
				else
					(self dispose:)
				)
			)
			(5
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(6
						(proc4_5)
						(WalkieTalkie showFrame: 31700 201 -1 146)
						(= global128 31700)
						(++ state)
						(= cycles 2)
					)
				)
			)
			(6
				(wixell init:)
				(denton init:)
				(pac init:)
				(proc4_5)
				(shootTimer setReal: shootTimer 10)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gGame showCloseUp: register -1 -1 self)
				else
					(gGame showCloseUp: 9012 -1 -1 self)
				)
			)
			(1
				(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sNotCleared of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen
					view: 31702
					loop: 0
					cel: 0
					posn: 249 225
					setPri: 10
					init:
					setCycle: CT 37 1 self
				)
				(if gAutoRobot
					(= temp0 (Robot 11)) ; FrameNum
					(proc4_5)
					(= global128 31700)
					(WalkieTalkie showFrame: 31700 temp0 -1 146)
				)
			)
			(1
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 44 1 self)
			)
			(2
				(gFxSound play:)
				(allen setCycle: CT 49 1 self)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound play:)
				(allen setCycle: CT 53 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 57 1 self)
			)
			(5
				(if (not (Robot 5)) ; HasEnded
					(gFxSound stop: play: self)
				else
					(gFxSound stop: number: 63 loop: 1 play: self)
				)
			)
			(6
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShotAtFurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(= local0 1)
					(gMessager say: 4 6 7 0 self) ; "Hold your fire!!!"
				else
					(gMessager say: 4 6 8 0 self) ; "Cease fire!!"
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance shootAllenBadly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(proc4_6 31701 -1 125 196 0 -1 1)
			)
			(1
				(SetFlag 95)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 374
		y 301
		view 31703
	)

	(method (init)
		(self setPri: 500)
		(super init: &rest)
	)
)

(instance allen of Prop
	(properties
		x 252
		y 228
		view 31705
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(self setScript: sShootAllen)
			)
			(6
				(self setScript: sShootAllen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties
		x 252
		y 228
		view 31705
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(self setScript: sShootHector)
			)
			(6
				(self setScript: sShootHector)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wixell of Prop
	(properties
		x 179
		y 162
		view 31700
		cel 2
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 9014)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 9014)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties
		x 179
		y 162
		view 31700
		cel 1
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 9020)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 9020)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pac of Prop
	(properties
		x 179
		y 162
		view 31700
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 9018)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 9018)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 9012)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 9012)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance allenFeat of Feature
	(properties
		y 500
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 367 174 404 174 398 204 404 237 365 237
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: shootAllenBadly)
			)
			(6
				(gCurRoom setScript: shootAllenBadly)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furniture of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 211 137 199 172 195 191 196 230 229 243 256 237 274 240 313 233 344 227 333 186 311 186 310 150 280 152 270 133
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (IsFlag 220)
					(allen setScript: sShotAtFurn)
				else
					(allen setScript: sNotCleared)
				)
			)
			(6
				(allen setScript: sShotAtFurn)
			)
			(48
				(if (IsFlag 220)
					(gMessager say: 3 theVerb 4) ; "It's been cleared."
				else
					(gMessager say: 3 theVerb 3) ; "Unconfirmed. No suspect movement. Cover."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shootTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sDentonShootsAllen)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3160) ; s2_3160
	)
)

