;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use RamaRoom)
(use Button)
(use Plane)
(use Motion)
(use Actor)
(use System)

(public
	videoMenu 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance videoMenu of RamaRoom
	(properties
		picture 97
	)

	(method (init)
		(= local3 ((ScriptID 0 2) view:)) ; ramanWaitCursor
		(= local4 ((ScriptID 0 2) loop:)) ; ramanWaitCursor
		(= local5 ((ScriptID 0 2) cel:)) ; ramanWaitCursor
		(= local6 ((ScriptID 0 3) view:)) ; ramanFingerCursor
		(= local7 ((ScriptID 0 3) loop:)) ; ramanFingerCursor
		(= local8 ((ScriptID 0 3) cel:)) ; ramanFingerCursor
		(= local0 ((ScriptID 0 1) view:)) ; ramanNormalCursor
		(= local1 ((ScriptID 0 1) loop:)) ; ramanNormalCursor
		(= local2 ((ScriptID 0 1) cel:)) ; ramanNormalCursor
		((ScriptID 0 2) view: 98 setLoop: 0 setCel: 1) ; ramanWaitCursor
		((ScriptID 0 1) view: 98 setLoop: 0 setCel: 0) ; ramanNormalCursor
		((ScriptID 0 3) view: 98 setLoop: 0 setCel: 2) ; ramanFingerCursor
		((= plane (Plane new:))
			init: 0 0 640 480
			priority: 255
			addCast: videoCast
		)
		(super init:)
		(gCast add: videoCast)
		(myNormalCursor init:)
		(gTheCursor setNormalCursor: myNormalCursor)
		(artBox init: videoCast)
		(crewBox init: videoCast)
		(backToIntro init: videoCast)
		(= local9 0)
	)

	(method (dispose)
		((ScriptID 0 2) view: local3 setLoop: local4 setCel: local5) ; ramanWaitCursor
		((ScriptID 0 3) view: local6 setLoop: local7 setCel: local8) ; ramanFingerCursor
		((ScriptID 0 1) view: local0 setLoop: local1 setCel: local2) ; ramanNormalCursor
		(gCast delete: videoCast)
		(super dispose: &rest)
	)
)

(instance videoCast of Cast
	(properties)
)

(instance artBox of Prop
	(properties
		x 94
		y 329
		view 100
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= local9 self)
				(gCurRoom setScript: sOpenBox)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crewBox of Prop
	(properties
		x 410
		y 329
		loop 1
		view 100
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= local9 self)
				(gCurRoom setScript: sOpenBox)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOpenBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(local9 setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(switch (local9 loop:)
					(0
						(gCurRoom newRoom: 96) ; arthurQuestions
					)
					(1
						(gCurRoom newRoom: 88) ; ramaWatch
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance myNormalCursor of View
	(properties
		view 98
	)
)

(instance backToIntro of Button
	(properties
		y 430
		loop 2
		view 100
		upLoop 2
		downLoop 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(artBox deleteHotspot:)
				(crewBox deleteHotspot:)
				(self deleteHotspot:)
				(gCurRoom newRoom: 1015) ; easyPickins
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

