;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 545)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use RegionPath)
(use eRS)
(use Language)
(use Osc)
(use RandCycle)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm545 0
)

(local
	local0
	local1
	[local2 4] = [0 548 549 551]
	local6
	[local7 270] = [0 0 69 125 85 125 85 120 100 120 0 0 105 120 123 120 134 130 160 130 169 114 187 114 0 0 192 114 200 114 200 95 0 0 200 90 200 72 178 72 0 0 173 72 135 72 156 72 156 83 0 0 156 86 161 130 134 130 123 119 105 119 0 0 100 119 85 119 78 114 78 114 77 110 85 110 85 85 0 0 85 80 85 73 111 72 0 0 116 72 131 72 133 59 131 72 116 72 0 0 111 72 85 73 85 80 0 0 85 85 85 101 109 101 0 0 112 101 123 101 130 93 159 93 168 102 187 102 0 0 192 102 197 102 197 93 0 0 197 88 197 72 182 72 0 0 177 72 156 72 154 59 156 72 177 72 0 0 182 72 197 72 197 102 0 0 197 93 197 102 240 102 240 125 240 126 203 126 203 116 192 116 0 0 187 116 168 116 161 126 133 126 123 114 105 114 0 0 100 114 84 114 84 110 84 110 77 110 78 114 85 119 100 119 0 0 105 119 123 119 134 86 0 0 134 83 134 72 173 72 0 0 178 72 200 72 200 90 0 0 200 95 200 114 192 114 0 0 187 114 169 114 160 130 134 130 123 120 105 120 0 0 100 120 85 120 85 125 69 125]
	[local277 24] = [3500 100 73 2505 140 71 3510 182 72 3525 187 115 2525 189 114 3515 93 114 2515 73 125 1515 92 119]
)

(procedure (localproc_0 param1 param2 param3 param4)
	(proc0_12 local0)
	(= local0
		(proc0_12
			param2
			67
			60
			(if (== param1 0) 130 else 120)
			28
			(if (== param1 0) global135 else global152)
			29
			global129
			70
			225
		)
	)
	(if param3
		(gLongSong2 number: param3 vol: 127 loop: 1 play: param4)
	)
)

(instance rm545 of SQRoom
	(properties
		lookStr {The PocketPal(tm) terminal's screen displays a wealth of nearly useful information, all designed to impart upon you an understanding that will last a lunch time.}
		picture 545
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(LoadMany rsPIC 546 547 548 549 551)
		(LoadMany rsVIEW 506 546)
		(User canControl: 0 canInput: 1)
		(self setRegions: 704) ; brain
		(super init:)
		(SetScore 60 10)
		(if (== (++ global162) 2)
			(self setScript: vohaulScript)
		else
			(= local6 (brain level:))
			(gCurRoom overlay: [local2 local6])
			(if (not (IsFlag 38))
				(blip1
					view: 506
					setLoop: 3
					setStep: 2 2
					x: [local7 (- (((ScriptID 704 1) mover:) value:) 1)] ; droid1
					y: [local7 (((ScriptID 704 1) mover:) value:)] ; droid1
					setPri: 8
					init:
					setCycle: Osc
				)
				(blip2
					view: 506
					setLoop: 4
					setStep: 2 2
					x: [local7 (- (((ScriptID 704 2) mover:) value:) 1)] ; droid2
					y: [local7 (((ScriptID 704 2) mover:) value:)] ; droid2
					setPri: 8
					init:
					setCycle: Osc
				)
			)
			(= temp1 (+ (* (brain level:) 1000) (brain lastRoom:)))
			(for ((= temp0 0)) (!= temp1 [local277 temp0]) ((+= temp0 3))
			)
			(= temp2 [local277 (++ temp0)])
			(= temp3 [local277 (++ temp0)])
			(blip3
				view: 506
				setLoop: 5
				x: temp2
				y: temp3
				setPri: 8
				init:
				setCycle: Osc
			)
			(level1 init:)
			(level2 init:)
			(level3 init:)
			(powerButton init:)
			(keyboard init:)
			(dandyName init:)
		)
		(gEgo init: hide:)
		(gLongSong fade: 20 1 10 0)
		(gLongSong2 number: 843 vol: 127 loop: 1 play:)
	)

	(method (doit &tmp [temp0 40] temp40 temp41 temp42 temp43 temp44 temp45)
		(super doit:)
		(if (and local1 (not (-- local1)))
			(EgoDead 8 23) ; "While you were busy staring blankly at your PocketPal(tm) screen, a droid clumsily snuck up to you and tapped you on the shoulder. "Zap," it said in its droning metallic voice, "you're it.""
		)
		(= temp44 ((ScriptID 704 1) mover:)) ; droid1
		(= temp45 ((ScriptID 704 2) mover:)) ; droid2
		(cond
			(script)
			((IsFlag 38))
			((not temp44)
				(if (not local1)
					(= local1 200)
				)
			)
			((temp44 isKindOf: RegionPath)
				(= temp40 (- (temp44 value:) 1))
				(= temp41 (temp44 value:))
				(blip1 setMotion: MoveTo [local7 temp40] [local7 temp41])
			)
		)
		(cond
			(script)
			((IsFlag 38))
			((not temp45)
				(if (not local1)
					(= local1 200)
				)
			)
			((temp45 isKindOf: RegionPath)
				(= temp42 (- (((ScriptID 704 2) mover:) value:) 1)) ; droid2
				(= temp43 (((ScriptID 704 2) mover:) value:)) ; droid2
				(blip2 setMotion: MoveTo [local7 temp42] [local7 temp43])
			)
		)
	)

	(method (dispose)
		(gLongSong fade: 127 1 10 0)
		(gLongSong2 number: 844 vol: 127 loop: 1 play:)
		(HandsOn)
		(brain lastRoom: 0)
		(super dispose:)
	)
)

(instance powerButton of Feature
	(properties
		x 37
		y 116
		nsTop 92
		nsLeft 28
		nsBottom 140
		nsRight 47
		description {power button}
		sightAngle 90
		lookStr {It's the PocketPal's power button.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gCurRoom newRoom: (brain lastRoom:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance keyboard of Feature
	(properties
		x 151
		y 179
		nsTop 170
		nsBottom 189
		nsRight 303
		description {keyboard}
		sightAngle 90
		lookStr {Hmm.__Keys just painted on.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Print 545 0) ; "They work as well as they look."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dandyName of Feature
	(properties
		x 78
		y 163
		nsTop 158
		nsLeft 20
		nsBottom 167
		nsRight 137
		description {fashionable name plate}
		sightAngle 90
		lookStr {Yes, it's the Dandy PocketPal(TM), from the people who brought you the Dandy BedBuddy(TM) universal remote control.}
	)
)

(instance level1 of Feature
	(properties
		x 222
		y 35
		nsTop 31
		nsLeft 244
		nsBottom 40
		nsRight 257
		description {level1}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 2) ; Do, Look
			(if (!= local6 1)
				(gCurRoom overlay: [local2 1])
				(if (== (= local6 1) (brain level:))
					(blip3 show:)
				else
					(blip3 hide:)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance level2 of Feature
	(properties
		x 222
		y 35
		nsTop 31
		nsLeft 230
		nsBottom 40
		nsRight 243
		description {level2}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 2) ; Do, Look
			(if (!= local6 2)
				(gCurRoom overlay: [local2 2])
				(if (== (= local6 2) (brain level:))
					(blip3 show:)
				else
					(blip3 hide:)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance level3 of Feature
	(properties
		x 222
		y 35
		nsTop 31
		nsLeft 216
		nsBottom 40
		nsRight 229
		description {level3}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 2) ; Do, Look
			(if (!= local6 3)
				(gCurRoom overlay: [local2 3])
				(if (== (= local6 3) (brain level:))
					(blip3 show:)
				else
					(blip3 hide:)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance blip1 of Actor
	(properties
		description {droid blip}
		lookStr {The blip indicates a security droid.}
	)

	(method (doit)
		(super doit:)
		(if (== ((ScriptID 704 1) level:) local6) ; droid1
			(self show:)
		else
			(self hide:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 545 1) ; "Maybe if you wait a while, the nice droid will come around to where you are and then maybe it'll talk to you."
			)
			(2 ; Look
				(if ((ScriptID 704 1) mover:) ; droid1
					(Print lookStr)
				else
					(Print 545 2) ; "It seems to have stopped, as if it were... waiting for something."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blip2 of Actor
	(properties
		description {droid blip}
		lookStr {The blip indicates a security droid.}
	)

	(method (doit)
		(super doit:)
		(if (== ((ScriptID 704 2) level:) local6) ; droid2
			(self show:)
		else
			(self hide:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 545 3) ; "Maybe if you wait a while, the nice droid will come around to where you are and then maybe it'll talk to you."
			)
			(2 ; Look
				(if ((ScriptID 704 2) mover:) ; droid2
					(Print lookStr)
				else
					(Print 545 4) ; "It seems to have stopped, as if it were... waiting for something."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blip3 of Prop
	(properties
		description {Roger blip}
		lookStr {You are here.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Talk
			(Print 545 5) ; "You talk to yourself, but you don't hear you."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theEyes of Prop
	(properties
		x 153
		y 65
		view 546
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance theMouth of Prop
	(properties
		x 155
		y 90
		view 546
		loop 1
		priority 11
		signal 16
		cycleSpeed 1
	)
)

(instance vohaulScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom overlay: 546)
				(theMouth init:)
				(theEyes init:)
				(= seconds 3)
			)
			(1
				(theMouth setCycle: Fwd)
				(theEyes setCycle: RandCycle)
				(localproc_0
					(LangSwitch 0 1)
					{Take a good look, Roger:}
					851
					self
				)
			)
			(2
				(proc0_12 local0)
				(gCurRoom overlay: 547)
				(theEyes hide:)
				(theMouth hide:)
				(= seconds 3)
			)
			(3
				(localproc_0
					(LangSwitch 0 1)
					{Remember this poor wretched soul...}
					852
					self
				)
			)
			(4
				(proc0_12 local0)
				(gCurRoom overlay: 546)
				(theMouth show: setCycle: Fwd)
				(theEyes show: setCycle: RandCycle)
				(localproc_0
					(LangSwitch 0 1)
					{...for he is your SON!}
					853
					self
				)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: (brain lastRoom:))
			)
		)
	)
)

