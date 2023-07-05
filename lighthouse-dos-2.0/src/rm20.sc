;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use LightRoom)
(use LightInv)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	rm20 0
)

(local
	local0
)

(instance rm20 of LightRoom
	(properties
		picture 20
		scene 20
	)

	(method (init)
		(Lock rsMESSAGE 3 1)
		(Lock rsMESSAGE 330 1)
		(Lock rsSCRIPT 3 1)
		(Lock rsAUDIO 19 1)
		(Lock rsAUDIO 17 1)
		(Lock rsAUDIO 17002 1)
		(if (not (IsFlag 29))
			(Lock rsAUDIO 17004 1)
		)
		(Lock rsAUDIO 44 1)
		(Lock rsAUDIO 45 1)
		(super init: &rest)
		(gGame handsOn:)
		(if (OneOf gPrevRoomNum 5 6) ; whereTo
			(if (not (gGame liteInterface:))
				((ScriptID 9 1) init:) ; PlInterface
			)
			(gUser curVerb: 5)
			(gMySoundFX number: 19 setLoop: -1 play: 32 0)
			(gIRandomMusic musicOne: 17 musicTwo: 17002 play: 63 0)
		)
		(fPhone init:)
		(fPoster init:)
		(fChair init:)
		((ScriptID 1 3) newRoom: 22) ; exitLeft
		(if (not (IsFlag 29))
			((ScriptID 3 1) init: x: 67 y: 215 cycleSpeed: 24) ; pLittleLight
		)
		(cond
			((IsFlag 12)
				(proc0_9 27 0 0)
				(gGame handsOn:)
			)
			((IsFlag 11)
				(SetFlag 12)
				(gGame handsOff:)
				(self setScript: sLightningStrike)
			)
			(else
				(SetFlag 11)
				(proc0_9 25 0 1)
				(gGame handsOn:)
			)
		)
		(if (not global258)
			(gGame handsOff:)
			(Sound pause: 1)
			(proc9_92 1)
			(= global246 1)
			(= global258 1)
			(gGame panelObj: gGame)
			(gGame panelSelector: 636)
			(Save 0 {rst} 0 {restart} (KArray 9 gVersion)) ; SaveGame, ArrayGetData
			(gGame panelObj: 0)
			(gGame panelSelector: 0)
			(= global246 0)
			(= global258 1)
			(gGame handsOn:)
			(proc9_92 0)
			(Sound pause: 0)
			(return)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5)
			(Lock rsMESSAGE 3 0)
			(Lock rsMESSAGE 330 0)
			(Lock rsSCRIPT 3 0)
			(Lock rsAUDIO 19 0)
			(Lock rsAUDIO 17 0)
			(Lock rsAUDIO 17002 0)
			(Lock rsAUDIO 17004 0)
			(Lock rsAUDIO 44 0)
			(Lock rsAUDIO 45 0)
			(Lock rsAUDIO 17004 0)
			(gIRandomMusic fade:)
		else
			(gGame handsOff:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fPhone of Feature
	(properties
		x 206
		y 225
		nsBottom 230
		nsLeft 39
		nsRight 104
		nsTop 203
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 0) init:) ; pplPhone
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fPoster of Feature
	(properties
		x 74
		y 95
		nsBottom 149
		nsLeft 13
		nsRight 137
		nsTop 41
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 2) init:) ; pplPoster
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sLightningStrike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 26 0 0)
			)
			(1
				(proc0_9 27 0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fChair of Feature
	(properties
		x 451
		y 246
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 299 48 259 72 227 108 216 144 219 167 245 167 299
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(SetFlag 418)
			(gCurRoom newRoom: 22)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

