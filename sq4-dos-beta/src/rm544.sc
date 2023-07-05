;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 544)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use SQRoom)
(use Feature)
(use Window)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm544 0
)

(local
	local0
	local1
	local2
)

(instance rm544 of SQRoom
	(properties
		picture 544
		style 100
	)

	(method (init &tmp [temp0 4])
		(self setRegions: 704) ; brain
		(super init:)
		(gEgo init: hide:)
		(HandsOn)
		(= local2 gSpeed)
		(= gSpeed 0)
		(if (not (IsFlag 29))
			(KQ43Icon init:)
		)
		(if (not (IsFlag 30))
			(SFIcon init:)
		)
		(if (brain droids:)
			(droidIcon init:)
		)
		(SQ4Icon init:)
		(brainIcon init:)
		(toiletIcon init:)
		(exitBar init:)
		(= local1
			(proc0_12
				{Memory Free: 2,451 KBytes}
				67
				40
				171
				28
				global137
				29
				global129
			)
		)
		(= gUseSortedFeatures 0)
	)

	(method (dispose)
		(= gSpeed local2)
		(= gUseSortedFeatures 1)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit:)
		(= temp0 (User curEvent:))
		(cond
			((OneOf (temp0 type:) evMOUSEBUTTON evMOUSERELEASE evKEYBOARD))
			((not local0))
			((local0 cycler:))
			(else
				(= temp1 (temp0 x:))
				(= temp2 (temp0 y:))
				(if (InRect 32 42 285 159 temp1 temp2)
					(local0 x: temp1 y: temp2)
				)
			)
		)
	)
)

(instance KQ43Icon of Prop
	(properties
		x 60
		y 60
		description {KQ43Icon}
		lookStr {Probably represents some tertiary function of the super computer brain.  Certainly nothing important.}
		view 544
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local0 self)
				(if (toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				else
					(= local0 0)
					(= cel 0)
				)
			else
				(= local0 self)
				(= cel 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(proc0_12 local1)
		(= local1
			(proc0_12
				{Memory Free: 841,912,226 GBytes}
				67
				40
				171
				28
				global137
				29
				global129
			)
		)
		(= local0 0)
		(SetFlag 29)
		(self dispose:)
	)
)

(instance SQ4Icon of Prop
	(properties
		x 100
		y 60
		description {SQ4Icon}
		lookStr {You've seen this mystic rune somewhere else...}
		view 544
		loop 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local0 self)
				(if (toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				else
					(= local0 0)
					(= cel 0)
				)
			else
				(= local0 self)
				(= cel 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(= gQuit 1)
		(self dispose:)
	)
)

(instance SFIcon of Prop
	(properties
		x 150
		y 60
		description {SFIcon}
		lookStr {Hmm.  Never heard of it.}
		view 544
		loop 2
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local0 self)
					(if (toiletIcon onMe: self)
						(toiletIcon setScript: flushFlash self)
					else
						(= local0 0)
						(= cel 0)
					)
				else
					(= local0 self)
					(= cel 1)
				)
			)
			(1 ; Look
				(self setScript: pMachine)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(= local0 0)
		(SetFlag 30)
		(self dispose:)
	)
)

(instance droidIcon of Prop
	(properties
		x 60
		y 95
		description {droidIcon}
		lookStr {Looks rather like a security droid of some sort.}
		view 544
		loop 3
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local0 self)
				(if (toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				else
					(= local0 0)
					(= cel 0)
				)
			else
				(= local0 self)
				(= cel 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(= local0 0)
		(brain droids: 0)
		(self dispose:)
	)
)

(instance brainIcon of Prop
	(properties
		x 100
		y 95
		description {brainIcon}
		lookStr {This is your brain.  This is only your brain.  Had this been a real brain, you would have known how to use it.}
		view 544
		loop 4
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local0 self)
				(if (toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				else
					(= local0 0)
					(= cel 0)
				)
			else
				(= local0 self)
				(= cel 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(= local0 0)
		(gCurRoom setScript: formatScript)
		(self dispose:)
	)
)

(instance toiletIcon of Prop
	(properties
		x 270
		y 155
		description {toiletIcon}
		lookStr {The Andromedan symbol for "Life"}
		view 544
		loop 5
		priority 14
		signal 16
	)
)

(instance exitBar of Feature
	(properties
		x 36
		y 37
		nsTop 32
		nsLeft 31
		nsBottom 43
		nsRight 42
		description {exit button}
		sightAngle 90
		lookStr {Click here to exit}
	)

	(method (doVerb)
		(gCurRoom newRoom: 514)
	)
)

(instance formatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_12 local1)
				(= local1
					(proc0_12
						{Initiating Formatting Sequence}
						67
						40
						162
						28
						global137
						29
						global129
					)
				)
				(= cycles 20)
			)
			(1
				(= local1
					(proc0_12
						{Setting Format Value to 5000}
						67
						40
						171
						28
						global137
						29
						global129
					)
				)
				(= cycles 20)
			)
			(2
				(brain formatting: 5000)
				(gCurRoom newRoom: 514)
			)
		)
	)
)

(instance flushFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCel: 1)
				(= cycles 2)
			)
			(1
				(local0 setCycle: Fwd)
				(= cycles 8)
			)
			(2
				(local0 cue:)
				(= cycles 2)
			)
			(3
				(client setCel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance myWin of SysWindow
	(properties)
)

(instance pMachine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myWin color: global129 back: global130)
				(Print 544 0 #window myWin #title {PMachine}) ; "Not an object: $0"
				(= cycles 2)
			)
			(1
				(Print 544 1 #window myWin #title {PMachine}) ; "Just kidding, Guys!"
				(self dispose:)
			)
		)
	)
)

