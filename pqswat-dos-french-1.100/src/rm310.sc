;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
)

(instance rm310 of PQRoom
	(properties
		picture 310
		infoRoomSignal 104
	)

	(method (init)
		(Load rsVIEW 10)
		(super init: &rest)
		(Load rsAUDIO 31001)
		(Lock rsAUDIO 31001 1)
		(if (not global403)
			((ScriptID 45 0) initData:) ; dopeBook
		)
		(houseDoor init:)
		(ghilleGuy init:)
		(if (IsFlag 48)
			(gBackMusic number: 31001 setLoop: -1 play:)
		)
		(cond
			(
				(and
					(not (IsFlag 34))
					(not (IsFlag 36))
					(not (IsFlag 38))
					(not (IsFlag 48))
				)
				(self setScript: informEgo)
			)
			(
				(and
					(not (IsFlag 48))
					(or (IsFlag 34) (IsFlag 36) (IsFlag 38))
				)
				(tello init: setCycle: Fwd)
				(SetFlag 48)
				(gBackMusic number: 31001 setLoop: -1 play:)
				(self setScript: introToPartner)
			)
			((and (IsFlag 49) (!= gPrevRoomNum 300))
				(tello init: setCycle: Fwd)
				(pruette init: setCycle: End)
				(houseDoor setCel: 3)
				(UpdateScreenItem houseDoor)
				(Load rsAUDIO 12)
				(self setScript: thereYouAre)
			)
			((and (IsFlag 49) (== gPrevRoomNum 300))
				(houseDoor setCel: 3)
				(UpdateScreenItem houseDoor)
				(Load rsAUDIO 12)
				(pruette init: setCycle: End)
				(tello init: setCycle: Fwd)
				(self setScript: exitBriefingEnterRange)
			)
			(else
				(houseDoor setCel: 3)
				(UpdateScreenItem houseDoor)
				(Load rsAUDIO 12)
				(tello init: setCycle: Fwd)
				(self setScript: enterRange)
			)
		)
		(ClearFlag 49)
	)

	(method (dispose)
		(if (!= gNewRoomNum 315)
			(Lock rsAUDIO 31001 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(DisposeScript 64938)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance introToPartner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 311 232 110 0 0 -1 1)
			)
			(1
				(SetFlag 49)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance thereYouAre of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(houseDoor setCycle: Beg self)
				(proc4_6 313 95 101 0 0 400 1)
			)
			(1
				(gFxSound number: 12 setLoop: 0 play:)
			)
			(2
				(SetFlag 112)
				(gCurRoom newRoom: 315)
			)
		)
	)
)

(instance informEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 56)
				(proc4_6 310 327 111 5)
			)
			(1
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance enterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(houseDoor setCycle: Beg self)
				(egoProp init: setPri: 400 setCycle: CT 17 1 self)
			)
			(1
				(gFxSound number: 12 setLoop: 0 play:)
			)
			(2
				(gCurRoom newRoom: 315)
			)
		)
	)
)

(instance exitBriefingEnterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(houseDoor setCycle: Beg self)
				(proc4_6 312 105 132 0 0 400 1)
			)
			(1
				(gFxSound number: 12 setLoop: 0 play:)
			)
			(2
				(gCurRoom newRoom: 315)
			)
		)
	)
)

(instance ghilleGuy of Prop
	(properties
		x 219
		y 219
		view 3104
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)

	(method (doVerb)
		(if (and (not cel) (> (++ local0) 5))
			(= local0 0)
			(self setCycle: CT 73 1 self)
		)
	)

	(method (cue)
		(self setCycle: Beg)
	)
)

(instance tello of Prop
	(properties
		x 4
		y 235
		priority 100
		fixPriority 1
		view 3100
	)

	(method (onMe)
		(return 0)
	)
)

(instance pruette of Prop
	(properties
		x -51
		y 247
		view 3120
		cel 8
	)
)

(instance egoProp of Prop
	(properties
		x 279
		y 237
		view 314
	)
)

(instance houseDoor of Prop
	(properties
		x 300
		y 136
		view 3101
	)
)

(instance enterRangeFeat of Feature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 86 120 112 121 227 0 248
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 315)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

