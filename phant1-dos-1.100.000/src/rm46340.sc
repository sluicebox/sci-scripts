;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46340)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use Actor)
(use System)

(public
	rm46340 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm46340 of ScaryRoom
	(properties
		picture 14200
	)

	(method (init &tmp temp0)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(if (and (not (IsFlag 390)) (not (gEgo has: 19))) ; invCutter
			(shard x: 33 init: setHotspot: 4 3) ; Do, Move
		)
		(= temp0 (Str newWith: 2 {08}))
		(cond
			((IsFlag 135))
			((IsFlag 150)
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(doorExit init: 1 approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(doorBack init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(= global165 8)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46790)
				(gCurRoom setScript: enterRoom)
			)
			((IsFlag 132)
				(gCurRoom setScript: enterGetCaught)
			)
			((not (IsFlag 132))
				(SetFlag 132)
				(gCurRoom setScript: enterRoom)
			)
			(else
				(SetFlag 148)
				(gCurRoom setScript: enterRoom)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (and (gEgo has: 10) (gEgo has: 19)) ; invBrooch, invCutter
			(gEgo put: 19) ; invCutter
		)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((not (IsFlag 135))
				(= temp0 (Str newWith: 3 {99\r\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(if local0
			(gCurRoom setScript: caughtBehindDoor)
		else
			(gCurRoom setScript: caughtScript)
		)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(= local3 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: caughtScript self)
					)
					(2
						(self setScript: enterRoom self)
					)
					(3
						(self setScript: runGetCaught self)
					)
					(4
						(self setScript: hideBehindDoor self)
					)
					(6
						(self setScript: pokeDon self)
					)
					(7
						(self setScript: hammerDon self)
					)
					(8
						(self setScript: stabDon self)
					)
					(9
						(self setScript: getShard self)
					)
					(10
						(self setScript: caughtBehindDoor self)
					)
					(11
						(self setScript: enterGetCaught self)
					)
					(12
						(self setScript: goGetShard self)
					)
					(99
						(gCurRoom setScript: playNextRoom)
					)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance playNextRoom of Script
	(properties)

	(method (changeState)
		(proc45951_3)
		(proc45951_3)
		(switch global179
			(3
				(gCurRoom newRoom: 46040)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance enterGetCaught of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {11}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= local4 1)
					(if (== global165 8)
						(DoRobot 9240 -7 -39 0 -1 1)
					else
						(DoRobot 9241 94 -39 0 -1 1)
					)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance caughtBehindDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {10}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9248 -7 -23 0 -1 1)
					(changeTo14200 doit:)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance runGetCaught of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (gCast contains: shard)
						(shard dispose:)
					)
					(DoRobot 9315 -7 -39 0 -1 1)
					(gCurRoom drawPic: 15210)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 45951 1) doit:) ; checkInv
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {01}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(if (and (not local4) (not (IsFlag 143)))
					(ClearFlag 132)
					(if (and (not (IsFlag 304)) (gEgo has: 19)) ; invCutter
						(gEgo put: 19) ; invCutter
					)
				)
				(SetFlag 150)
				(= global159 46340)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9242 94 -7 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
					)
				)
				(2
					(gGame handsOff:)
				)
				(3
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance hideBehindDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= local0 1)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(doorExit dispose:)
					(doorBack dispose:)
					(= local0 1)
					(DoRobot 9430 -10 -44 0 90 1)
					(changeTo14250 doit:)
				)
				(1
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
						(donFeat init: setHotspot: 0 27 10 11) ; invCutter, invPoker, invHammer
					)
				)
				(2
					(gGame handsOff:)
				)
				(3
					(door setPri: -1)
				)
				(4
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance pokeDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9244 -8 -20 0 -1 1)
					(changeTo14200 doit:)
				)
				(1
					(ClearFlag 148)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance hammerDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9243 -6 -36 0 -1 1)
					(changeTo14200 doit:)
				)
				(1
					(ClearFlag 148)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance stabDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 18)
			(= local1 1)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (IsFlag 18)
						(DoRobot 9245 -11 -38 0 -1 1)
					else
						(SetFlag 18)
						(= local1 1)
						(donFeat setHotspot: 0)
						(global114 pause:)
						(if (gEgo has: 10) ; invBrooch
							(DoRobot 9239 -10 -20 0 -1 1)
						else
							(DoRobot 9246 -16 -41 0 -1 1)
						)
					)
					(changeTo14200 doit:)
				)
				(1
					(cond
						((IsFlag 135)
							(global114 endPause:)
							(self dispose:)
						)
						(local1
							(global114 endPause:)
							(gCurRoom newRoom: 46040)
						)
						(else
							(gCurRoom setScript: caughtScript)
						)
					)
				)
			)
		)
	)
)

(instance goGetShard of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 19) ; invCutter
			((ScriptID 45951 1) doit:) ; checkInv
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {12}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(doorExit dispose:)
					(doorBack dispose:)
					(shard dispose:)
					(DoRobot 9431 -10 -38 0 -1 1)
					(changeTo14250 doit:)
					(gEgo get: 19) ; invCutter
					((ScriptID 45951 1) doit:) ; checkInv
				)
				(1
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(if (not (IsFlag 143))
							(gGame handsOn:)
						)
						(donFeat init: setHotspot: 0 27 10 11) ; invCutter, invPoker, invHammer
					)
				)
				(2
					(gGame handsOff:)
				)
				(3
					(door setPri: 1)
				)
				(4
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance getShard of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 19) ; invCutter
			((ScriptID 45951 1) doit:) ; checkInv
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {09}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(shard dispose:)
					(DoRobot 9249 -6 -43 0)
					(changeTo14200 doit:)
				)
				(1
					(gEgo get: 19) ; invCutter
					((ScriptID 45951 1) doit:) ; checkInv
				)
				(2
					(DoRobot 9432 -16 -51 0 -1 1)
					(changeTo14250 doit:)
					(if (IsFlag 135)
						(= local3 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(if (not (IsFlag 143))
							(gGame handsOn:)
						)
						(donFeat init: setHotspot: 0 27 10 11) ; invCutter, invPoker, invHammer
					)
				)
				(3
					(gGame handsOff:)
				)
				(4
					(door setPri: 1)
				)
				(5
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance shard of View
	(properties
		x 31
		y 130
		view 14251
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				(local0
					(gCurRoom setScript: getShard)
				)
				((gFeatures contains: donFeat)
					(gCurRoom setScript: stabDon)
				)
				(else
					(gCurRoom setScript: goGetShard)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of View
	(properties
		x 85
		y 128
		view 14202
		cel 5
	)
)

(instance donFeat of Feature
	(properties
		nsLeft 42
		nsTop 32
		nsRight 115
		nsBottom 110
		sightAngle 180
		x 78
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; invPoker
				(gCurRoom setScript: pokeDon)
			)
			(11 ; invHammer
				(gCurRoom setScript: hammerDon)
			)
			(27 ; invCutter
				(gCurRoom setScript: stabDon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorBack of Feature
	(properties
		nsLeft 31
		nsTop 54
		nsRight 75
		nsBottom 107
		x 121
		y 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: hideBehindDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 89
		nsTop 19
		nsRight 139
		nsBottom 113
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local1)
				(gCurRoom setScript: runGetCaught)
			else
				(gCurRoom newRoom: 46040)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance changeTo14200 of Code
	(properties)

	(method (doit)
		(door dispose:)
		(if (gCast contains: shard)
			(shard x: 33 y: 130)
		)
		(gCurRoom drawPic: 14200)
	)
)

(instance changeTo14250 of Code
	(properties)

	(method (doit)
		(door view: 14250 setPri: 200 cel: 3 x: 82 y: 124 init:)
		(if (gCast contains: shard)
			(shard x: 173 y: 85)
		)
		(gCurRoom drawPic: 14250)
	)
)

