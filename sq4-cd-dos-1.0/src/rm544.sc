;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 544)
(include sci.sh)
(use Main)
(use brain)
(use eRS)
(use Sq4Feature)
(use Motion)
(use User)
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
		lookStr 1 ; "The programming screen's format looks familiar..."
	)

	(method (init &tmp [temp0 20])
		(self setRegions: 704) ; brain
		(super init:)
		(gEgo setCycle: 0)
		(HandsOn)
		(= local2 gGameSpeed)
		(= gGameSpeed 0)
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
		(= local1 (proc0_12 @temp0 64 40 171 25 global137 26 global129))
		(= gUseSortedFeatures 0)
		(gLongSong fade: 75 10 10 0)
		(gLongSong2 number: 842 vol: 127 loop: 1 play:)
	)

	(method (dispose)
		(= gGameSpeed local2)
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
			(2 ; Talk
				(gNarrator say: 2) ; "Apparently, the programming screen is not equipped with a voice recognition system."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance KQ43Icon of Sq4Prop
	(properties
		x 60
		y 60
		view 544
		priority 14
		signal 16
		lookStr 3 ; "Probably represents some tertiary function of the super computer brain. Certainly nothing important."
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
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
				64
				40
				171
				25
				global137
				26
				global129
			)
		)
		(= local0 0)
		(SetFlag 27)
		(self dispose:)
	)
)

(instance SQ4Icon of Sq4Prop
	(properties
		x 100
		y 60
		view 544
		loop 1
		priority 14
		signal 16
		lookStr 4 ; "You've seen this mystic rune somewhere else..."
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
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

(instance LLIcon of Sq4Prop
	(properties
		x 150
		y 60
		view 544
		loop 2
		priority 14
		signal 16
		lookStr 5 ; "Yeah, this looks like toilet material."
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
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

(instance droidIcon of Sq4Prop
	(properties
		x 60
		y 95
		view 544
		loop 3
		priority 14
		signal 16
		lookStr 6 ; "Looks rather like a security droid of some sort."
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
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

(instance brainIcon of Sq4Prop
	(properties
		x 100
		y 95
		view 544
		loop 4
		priority 14
		signal 16
		lookStr 7 ; "This is your brain. Had this been a real brain, you would have known how to use it."
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(cond
			((== theVerb 4) ; Do
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
			((and (== theVerb 1) (not (HaveMouse))) ; Look
				(= temp0 ((User curEvent:) x:))
				(= temp1 ((User curEvent:) y:))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 304 172)
				(Animate (gCast elements:) 0)
				(gNarrator say: 7) ; "This is your brain. Had this been a real brain, you would have known how to use it."
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
				64
				40
				171
				25
				global137
				26
				global129
			)
		)
		(brain formatting: 5000)
		(gLongSong number: 869 loop: -1 play: setVol: 75)
		(SetScore 62 15)
		(self dispose:)
	)
)

(instance toiletIcon of Sq4Prop
	(properties
		x 270
		y 155
		view 544
		loop 5
		priority 13
		signal 16
		lookStr 9 ; "The Andromedan symbol for "Life"."
	)
)

(instance exitBar of Sq4Feature
	(properties
		x 36
		y 37
		nsTop 32
		nsLeft 31
		nsBottom 43
		nsRight 42
		sightAngle 90
		lookStr 10 ; "The exit bar."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
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

