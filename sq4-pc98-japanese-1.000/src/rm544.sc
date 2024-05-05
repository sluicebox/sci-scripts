;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 544)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use eRS)
(use Feature)
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
		lookStr {The programming screen's format looks familiar...}
		picture 544
		style 100
	)

	(method (init &tmp [temp0 50])
		(self setRegions: 704) ; brain
		(super init:)
		(gEgo setCycle: 0)
		(HandsOn)
		(= local2 gSpeed)
		(= gSpeed 0)
		(if (not (IsFlag 27))
			(KQ43Icon init:)
		)
		(if (not (IsFlag 28))
			(LLIcon init:)
		)
		(if (not (IsFlag 38))
			(droidIcon init:)
		)
		(SQ4Icon init:)
		(if (not (brain formatting:))
			(brainIcon init:)
		)
		(toiletIcon init:)
		(exitBar init:)
		(if (IsFlag 27)
			(StrCpy @temp0 {Memory Free: 841,912,226 GBytes})
		else
			(StrCpy @temp0 {Memory Free: 2,451 KBytes})
		)
		(= local1 (proc0_12 @temp0 67 40 171 28 global137 29 global129))
		(= gUseSortedFeatures 0)
		(gLongSong fade: 30 10 10 0)
		(gLongSong2 number: 842 vol: 127 loop: 1 play:)
	)

	(method (dispose)
		(= gSpeed local2)
		(= gUseSortedFeatures 1)
		(gLongSong fade: 127 10 10 0)
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
				(if (InRect 47 52 270 149 temp1 temp2)
					(local0 x: temp1 y: temp2)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 544 0) ; "Apparently, the programming screen is not equipped with a voice recognition system."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance KQ43Icon of Prop
	(properties
		x 60
		y 60
		description {KQ43Icon}
		lookStr {Probably represents some tertiary function of the super computer brain.__Certainly nothing important.}
		view 544
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(cond
				((toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				)
				((== local0 self)
					(= local0 0)
					(= cel 0)
				)
				(local0)
				(else
					(= local0 self)
					(= cel 1)
				)
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
		(SetFlag 27)
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
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(cond
				((toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				)
				((== local0 self)
					(= local0 0)
					(= cel 0)
				)
				(local0)
				(else
					(= local0 self)
					(= cel 1)
				)
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

(instance LLIcon of Prop
	(properties
		x 150
		y 60
		description {LLIcon}
		lookStr {Yeah, this looks like toilet material.}
		view 544
		loop 2
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(cond
				((toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				)
				((== local0 self)
					(= local0 0)
					(= cel 0)
				)
				(local0)
				(else
					(= local0 self)
					(= cel 1)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(= local0 0)
		(SetFlag 28)
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
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(cond
				((toiletIcon onMe: self)
					(toiletIcon setScript: flushFlash self)
				)
				((== local0 self)
					(= local0 0)
					(= cel 0)
				)
				(local0)
				(else
					(= local0 self)
					(= cel 1)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(= local0 0)
		(SetFlag 38)
		(SetScore 61 5)
		(self dispose:)
	)
)

(instance brainIcon of Prop
	(properties
		x 100
		y 95
		description {brainIcon}
		lookStr {This is your brain.__This is only your brain.__Had this been a real brain, you would have known how to use it.}
		view 544
		loop 4
		priority 14
		signal 16
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(cond
			((== theVerb 3) ; Do
				(cond
					((toiletIcon onMe: self)
						(toiletIcon setScript: flushFlash self)
					)
					((== local0 self)
						(= local0 0)
						(= cel 0)
					)
					(local0)
					(else
						(= local0 self)
						(= cel 1)
					)
				)
			)
			((and (== theVerb 2) (not (HaveMouse))) ; Look
				(= temp0 ((User curEvent:) x:))
				(= temp1 ((User curEvent:) y:))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 304 172)
				(Animate (gCast elements:) 0)
				(Print lookStr)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 temp0 temp1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(= local0 0)
		(proc0_12 local1)
		(= local1
			(proc0_12
				{Initiating Formatting Sequence Value to 5000}
				67
				40
				171
				28
				global137
				29
				global129
			)
		)
		(brain formatting: 5000)
		(gLongSong number: 869 vol: 30 loop: -1 play:)
		(SetScore 62 15)
		(self dispose:)
	)
)

(instance toiletIcon of Prop
	(properties
		x 270
		y 155
		description {toiletIcon}
		lookStr {The Andromedan symbol for "Life".}
		view 544
		loop 5
		priority 13
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
		lookStr {The exit bar.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom newRoom: 514)
			)
			(else
				(super doVerb: theVerb &rest)
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
				(gLongSong2 number: 839 loop: 1 play: self)
				(client setCel: 1)
				(= cycles 2)
			)
			(1
				(local0 setCycle: Fwd)
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

