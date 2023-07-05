;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use RamaRoom)
(use Button)
(use VMDMovie)
(use Motion)
(use Actor)
(use System)

(public
	ramaWatch 0
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
	[local9 3] = [31011 32011 33011]
	[local12 3]
	local15
	local16
	local17 = -1
)

(instance ramaWatch of RamaRoom
	(properties
		picture 96
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
		(super init: &rest)
		(myNormalCursor init:)
		(gTheCursor setNormalCursor: myNormalCursor)
		(night1Box init:)
		(night2Box init:)
		(night3Box init:)
		(theExit init:)
		(= local15 0)
		(= local16 0)
		(= local17 -1)
	)

	(method (dispose)
		((ScriptID 0 2) view: local3 setLoop: local4 setCel: local5) ; ramanWaitCursor
		((ScriptID 0 3) view: local6 setLoop: local7 setCel: local8) ; ramanFingerCursor
		((ScriptID 0 1) view: local0 setLoop: local1 setCel: local2) ; ramanNormalCursor
		(super dispose: &rest)
	)
)

(instance night1Box of Prop
	(properties
		x 34
		y 311
		view 99
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local17 0) (not (gCurRoom script:)))
					(= local15 self)
					(= local17 0)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance night2Box of Prop
	(properties
		x 234
		y 316
		view 99
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local17 1) (not (gCurRoom script:)))
					(= local15 self)
					(= local17 1)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance night3Box of Prop
	(properties
		x 439
		y 315
		view 102
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local17 2) (not (gCurRoom script:)))
					(= local15 self)
					(= local17 2)
					(gCurRoom setScript: sOpenBox)
				)
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
				(if local16
					(local16 setCycle: Beg)
				)
				(local15 setCycle: End self)
			)
			(2
				(= local16 local15)
				(= local15 0)
				(FrameOut)
				(= cycles 2)
			)
			(3
				(interView
					movieName: [local9 local17]
					boostRGB: [local12 local17]
					play:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(local16 setCycle: Beg self)
			)
			(2
				(= local16 0)
				(= local17 -1)
				(= seconds 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theExit of Button
	(properties
		x -1
		y 429
		view 99
		loop 3
		upLoop 3
		downLoop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(night1Box deleteHotspot:)
				(night2Box deleteHotspot:)
				(night3Box deleteHotspot:)
				(gCurRoom newRoom: 89) ; videoMenu
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

(instance myNormalCursor of View
	(properties
		view 98
	)
)

(instance interView of VMDMovie
	(properties
		x 140
		y 80
	)

	(method (play)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(gCurRoom setScript: sCloseBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

