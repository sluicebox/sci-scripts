;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm020 0
)

(procedure (localproc_0)
	(HandsOn)
	(if (not (gEgo normal:))
		(gTheIconBar disable: 0)
	)
)

(instance rm020 of PQRoom
	(properties
		picture 20
	)

	(method (init)
		(super init:)
		(self
			setRegions: 891 ; station
			posn: 203 153
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 238 127 213 133 184 114 176 115 169 109 169 102 158 94 179 85 164 76 85 104 70 100 9 129 9 163 39 163 32 146 51 137 100 183 112 176 65 135 110 111 124 123 137 118 159 133 143 138 170 159 136 174 175 189 0 189 0 0 84 0 319 1 319 168
					yourself:
				)
		)
		(if
			(or
				(== ((gInventory at: 18) owner:) 20) ; patMemo
				(and (== ((gInventory at: 0) owner:) 20) (IsFlag 1)) ; compRequest
			)
			(note init:)
		)
		(chair init:)
		(thePhone init:)
		(ltDesk init:)
		(ltStuff init:)
		(garbageCan init:)
		(bulletinBoard init:)
		(visitorChair init:)
		(ltChair init:)
		(cabinets init:)
		(rm20picture init:)
		(computer init:)
		(mailBox init:)
		(desk init:)
		(bookcase init:)
		(thisRoom init:)
		(if (IsFlag 9)
			(pat init:)
		)
		(switch gPrevRoomNum
			(200
				(gEgo normal: 0 view: 165 loop: 5 posn: 183 112 cel: 0 init:)
				(chair hide:)
				(gTheIconBar disable: 0)
			)
			(else
				(gEgo
					normal: 1
					view: (if (> gDay 1) 4 else 0)
					setStep: 3 2
					posn: 231 189
					setPri: 12
					init:
				)
				(gCurRoom setScript: enterIn)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((IsFlag 9)
				(HandsOff)
				(ClearFlag 9)
				(self setScript: patScript)
			)
			((& (gEgo onControl: 0) $0002)
				(self posn: 231 189 setScript: (ScriptID 896 2) 0 18) ; sWO
			)
		)
		(super doit:)
	)
)

(instance enterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(doorClose play:)
				(= cycles 1)
			)
			(2
				(gCurRoom setScript: (ScriptID 896 1)) ; sWI
			)
		)
	)
)

(instance patScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 185 115 self)
				(mySound play:)
			)
			(1
				(gEgo
					normal: 0
					view: 165
					loop: 5
					x: 183
					y: 112
					cel: 12
					setCycle: Beg self
				)
				(chair hide:)
			)
			(2
				(= save1 1)
				(Print 20 0 #at 10 10 #dispose) ; "You have a serious talk with Morales..."
				(= seconds 4)
			)
			(3
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 20 1 108) ; "I have a complaint here alleging that you were verbally abusive to one of the violators you stopped."
				(= seconds 8)
			)
			(4
				(= save1 1)
				(Say sonnyInset 20 2 108) ; "The complaint states that you yelled, screamed and used profanity."
				(= seconds 8)
			)
			(5
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 20 3 108) ; "So whaddya want from me? The guy was a jerk!"
				(= seconds 8)
			)
			(6
				(= save1 1)
				(Say patInset 20 4 108) ; "He'd of liked to do more than file a complaint - if ya know what I mean."
				(= seconds 5)
			)
			(7
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(Animate (gCast elements:) 0)
				(Print 20 5 #at 10 10 #dispose) ; "Continuing the interview you ask..."
				(= seconds 4)
			)
			(8
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 20 6 108) ; "Alright. Why don't YOU tell ME what happened?"
				(= seconds 4)
			)
			(9
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 20 7 108) ; "I pull the guy over, right? He's goin' 75, maybe 80 in a 50 mile zone."
				(= seconds 6)
			)
			(10
				(= save1 1)
				(Say patInset 20 8 108) ; "I walk up to the car and BOOM, right away he starts eyein' me and lippin' off."
				(= seconds 6)
			)
			(11
				(= save1 1)
				(Say patInset 20 9 108) ; "I'm to put up with that crap?"
				(= seconds 4)
			)
			(12
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(Animate (gCast elements:) 0)
				(Print 20 10 #at 10 10 #dispose) ; "You ask Officer Morales directly..."
				(= seconds 4)
			)
			(13
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 20 11 108) ; "Did you raise your voice and use profanity with the man or not?"
				(= seconds 4)
			)
			(14
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 20 12 108) ; "Look - you try bein' a woman cop for just one day. Then tell me how to do my job!"
				(= seconds 7)
			)
			(15
				(= save1 1)
				(Say patInset 20 13 108) ; "Truthfully? I don't remember what the hell I said, but whatever it was I had damn good reason!"
				(= seconds 7)
			)
			(16
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 20 14 108) ; "Okay, Morales, that's it for now. Get back on duty and see if you can keep the 'civil' in civil servant."
				(= seconds 7)
			)
			(17
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 20 15 108) ; "Sure, Sarge. Whatever you say."
				(= seconds 4)
			)
			(18
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(pat setCycle: End self)
				(stinger play:)
				(mySound fade:)
			)
			(19
				(pat
					setLoop: 1
					setCycle: Walk
					setPri: 13
					setStep: 3 5
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 267 189 self
				)
			)
			(20
				(Print 20 16) ; "You think about what you've learned regarding the civilian complaint."
				(= cycles 1)
			)
			(21
				(gGame setCursor: 20)
				(pat dispose:)
				(if
					(Print ; "UNFOUNDED-  You find the complaint unfounded. EXONERATED-  Not believing the complainant, you exonerate the officer. SUSTAINED-  Based on the interview, you conclude that disciplinary action is necessary. You sustain the complaint against her. UNDETERMINED-  Feeling undecided based on the interview, you label the complaint undetermined."
						20
						17
						#font
						4
						#width
						300
						#button
						{UNFOUNDED}
						0
						#button
						{EXONERATED}
						0
						#button
						{SUSTAINED}
						1
						#button
						{UNDETERMINED}
						0
					)
					(SetFlag 10)
					(SetScore 95 5)
				)
				(= cycles 1)
			)
			(22
				(gEgo normal: 0 view: 165 setCycle: End self)
			)
			(23
				(chair show:)
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					x: 185
					y: 115
					setMotion: PolyPath 98 123 self
				)
			)
			(24
				(HandsOn)
				(Print 20 18) ; "You leave the complaint on the Lieutenant's desk."
				(gEgo put: 18 21) ; patMemo
				(proc0_17 20)
				(self dispose:)
			)
		)
	)
)

(instance sitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 185 115 self)
			)
			(1
				(gEgo
					normal: 0
					view: 165
					loop: 5
					x: 183
					y: 112
					cel: 12
					setCycle: Beg self
				)
				(chair hide:)
				(chairSlide play:)
			)
			(2
				(gEgo loop: 0 x: 186 y: 110)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance standScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cInset dispose:)
				(gEgo
					normal: 0
					view: 165
					x: 183
					y: 112
					loop: 5
					cel: 0
					setCycle: End self
				)
				(chairSlide play:)
			)
			(1
				(chair show:)
				(gEgo normal: 1 view: 0 setCycle: Walk x: 185 y: 115)
				(HandsOn)
				(gTheIconBar enable: 0)
				(self dispose:)
			)
		)
	)
)

(instance phoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(gEgo setMotion: PolyPath 185 115 self)
				else
					(= cycles (= state 1))
				)
			)
			(1
				(gEgo
					normal: 0
					view: 165
					loop: 5
					x: 182
					y: 113
					cel: 12
					setCycle: Beg self
				)
				(chair hide:)
			)
			(2
				(gEgo loop: 0 x: 186 y: 110)
				(HandsOn)
				(self setScript: (ScriptID 891 2) self) ; phoneScript
			)
			(3
				(gTheIconBar disable: 0)
				(gEgo setCycle: End self)
			)
			(4
				(if (== global112 111)
					(Print 20 19) ; "You can take the cop off the street, but you can't take the street out of the cop, eh Sonny?"
					(Print 20 20) ; "Oh well, it's getting stuffy in here anyway. Time to roll."
					(= global112 0)
				)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance compScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(gEgo setMotion: PolyPath 185 115 self)
				else
					(= cycles (= state 1))
				)
			)
			(1
				(gEgo
					normal: 0
					view: 165
					loop: 5
					x: 182
					y: 113
					cel: 12
					setCycle: Beg self
				)
				(chair hide:)
			)
			(2
				(cInset init:)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance mailBoxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo normal:)
					(gEgo setMotion: PolyPath 167 106 self)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((and (IsFlag 1) (== ((gInventory at: 0) owner:) 20)) ; compRequest
						(Print 20 21) ; "You remove a requisition form for a "computer access card." from the basket."
						(note dispose:)
						(gEgo get: 0) ; compRequest
						(SetScore 96 1)
					)
					((and (== ((gInventory at: 18) owner:) 20) (not (IsFlag 1))) ; patMemo
						(Print 20 22) ; "You remove a form from the basket."
						(Print 20 23) ; "It's a departmental "Disciplinary Action Form" with a note attached."
						(Print 20 24) ; "The note from the Lieutenant reads..."
						(Print 20 25) ; "Bonds, please interview Officer Pat Morales regarding a complaint. The complainant alleges that the officer used profanity and verbally abused him during the issuing of a citation. Determine disciplinary action, if any, based on your interview. Leave this form on my desk when you're done."
						(gEgo get: 18) ; patMemo
						(proc0_17 20)
						(SetScore 92 1)
						(note dispose:)
					)
					(else
						(Print 20 26) ; "Nothing's in there to take."
					)
				)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance note of Prop
	(properties
		x 178
		y 77
		description {chair}
		sightAngle 360
		view 165
		loop 1
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cInset dispose:)
				(Print 20 27) ; "The In/Out basket appears to have something in it."
			)
			(3 ; Do
				(cInset dispose:)
				(HandsOff)
				(gCurRoom setScript: mailBoxScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mailBox of Feature
	(properties
		x 182
		y 78
		description {In/Out basket.}
		sightAngle 360
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cInset dispose:)
				(if
					(or
						(== ((gInventory at: 18) owner:) 20) ; patMemo
						(and (== ((gInventory at: 0) owner:) 20) (IsFlag 1)) ; compRequest
					)
					(Print 20 27) ; "The In/Out basket appears to have something in it."
				else
					(Print 20 28) ; "The In/Out basket is empty."
				)
			)
			(3 ; Do
				(cInset dispose:)
				(HandsOff)
				(gCurRoom setScript: mailBoxScript)
			)
			(4 ; Inventory
				(Print 20 29) ; "This is for memos, requests and files."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer of Feature
	(properties
		description {a Computer.}
		sightAngle 360
		onMeCheck 8192
		lookStr {Your computer occupies the center of your desk. In this business, the computer is an indispensible tool.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((> gDay 1)
						(Print 20 30) ; "You are in homicide division now. Use the your computer there."
					)
					((gCast contains: cInset)
						(Print 20 31) ; "Your computer is already turned on."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: compScript)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(21 ; compCard
						(if (> gDay 1)
							(Print 20 30) ; "You are in homicide division now. Use the your computer there."
						else
							(HandsOff)
							(gCurRoom setScript: compScript)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thisRoom of Feature
	(properties
		description {sergeant's room}
		sightAngle 360
		lookStr {This is the Sergeant's office.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not (gEgo normal:))
					(HandsOff)
					(gCurRoom setScript: standScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		description {sergeant's room}
		sightAngle 360
		onMeCheck 4096
		lookStr {Your desk is neat and orderly - probably because you don't spend a lot of time here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== gDay 1)
					(HandsOff)
					(if (gEgo normal:)
						(gCurRoom setScript: sitScript)
					else
						(gCurRoom setScript: standScript)
					)
				else
					(Print 20 32) ; "You are in homicide division now. Use your desk there."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePhone of Feature
	(properties
		description {your phone}
		sightAngle 360
		onMeCheck 2048
		lookStr {Your phone sits silently on your desk.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (> gDay 1)
					(Print 20 33) ; "You are in homicide division now. Use the phone there."
				else
					(HandsOff)
					(cInset dispose:)
					(gCurRoom setScript: phoneScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ltDesk of Feature
	(properties
		x 113
		y 132
		description {Lt's desk}
		sightAngle 360
		onMeCheck 1024
		lookStr {That desk belongs to the Lieutenant.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 34) ; "Use your own desk."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ltStuff of Feature
	(properties
		x 113
		y 132
		description {Lt's desk}
		sightAngle 360
		onMeCheck 4
		lookStr {That's the Lieutenant's stuff.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 35) ; "Don't mess with the Lieutenant's stuff."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance garbageCan of Feature
	(properties
		x 151
		y 1153
		description {garbage can}
		sightAngle 360
		onMeCheck 32
		lookStr {It's a garbage can.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 36) ; "Now why would you want to take a garbage can?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulletinBoard of Feature
	(properties
		x 211
		y 64
		description {bulletin board}
		sightAngle 360
		onMeCheck 8
		lookStr {The bulletin board in here has information so old, there's a missing person bulletin about Jimmy Hoffa.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 37) ; "There's nothing even remotely interesting on that bulletin board."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cabinets of Feature
	(properties
		x 130
		y 65
		description {filing cabinets}
		sightAngle 360
		onMeCheck 64
		lookStr {Those are file drawers.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 38) ; "There's nothing you need in the file drawers."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rm20picture of Feature
	(properties
		x 211
		y 64
		description {picture}
		sightAngle 360
		onMeCheck 16
		lookStr {Ah, some of the fine art displayed here at the Lytton County Police Department!}
	)
)

(instance pat of Actor
	(properties
		x 215
		y 127
		view 167
		signal 1
	)
)

(instance patInset of Prop
	(properties
		x 253
		y 125
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(angryE posn: (self x:) (self y:) init:)
		(pEyes posn: (self x:) (self y:) setScript: patEyesBlink init:)
		(patMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(angryE dispose:)
		(patMouth dispose:)
		(pEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance patMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance angryE of Prop
	(properties
		description {Pat Morales}
		view 27
		cel 2
		priority 15
		signal 16401
	)
)

(instance pEyes of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 2
		priority 15
		signal 16401
	)
)

(instance patEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(pEyes cel: 1)
				(= cycles 4)
			)
			(2
				(pEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sonnyMouth x: (self x:) y: (self y:) setCycle: Fwd init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(sonnyMouth dispose:)
		(sonnyEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance chair of Prop
	(properties
		x 186
		y 108
		description {chair}
		sightAngle 360
		lookStr {It's your good ole, well-worn chair.}
		view 165
		loop 4
		cel 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== gDay 1)
					(HandsOff)
					(gCurRoom setScript: sitScript)
				else
					(Print 20 39) ; "You are in homicide division now. Your new desk and chair are there."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance visitorChair of Feature
	(properties
		x 219
		y 114
		description {chair}
		sightAngle 360
		onMeCheck 512
		lookStr {That chair's for your visitors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 40) ; "Why would you want to sit on that hard visitor's chair when you can sit on your own comfy one?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ltChair of Feature
	(properties
		x 138
		y 122
		description {chair}
		sightAngle 360
		onMeCheck 256
		lookStr {That chair belongs to the Lieutenant.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 41) ; "You have your own chair. Leave the Lieutenant's alone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookcase of Feature
	(properties
		x 90
		y 54
		description {bookcase}
		sightAngle 360
		onMeCheck 128
		lookStr {The bookcase contains law reference materials.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 42) ; "You prefer to catch the criminals - let the lawyers read all that crap."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cInset of Prop
	(properties
		x 89
		y 91
		lookStr {It's a computer.}
		view 249
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 43) ; "You need a computer access card first."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(computebutton init:)
		(screen setCycle: End init:)
		(computerOn play:)
		(card init:)
		(super init:)
	)

	(method (dispose)
		(computebutton dispose:)
		(screen dispose:)
		(card dispose:)
		(super dispose:)
	)
)

(instance computebutton of Prop
	(properties
		x 81
		y 91
		z 7
		lookStr {That's the power switch.}
		view 249
		loop 3
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cInset dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 49
		y 91
		z 56
		lookStr {That's the computer monitor.}
		view 249
		loop 4
		priority 15
		signal 16
		cycleSpeed 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 20 43) ; "You need a computer access card first."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance card of Prop
	(properties
		x 101
		y 91
		z 44
		lookStr {That's the computer access card slot.}
		view 249
		loop 5
		priority 15
		signal 16
	)

	(method (cue)
		(gTheIconBar enable: 0)
		(gCurRoom newRoom: 200)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 20 43) ; "You need a computer access card first."
			)
			(4 ; Inventory
				(switch invItem
					(21 ; compCard
						(Print 20 44) ; "You insert your computer access card."
						(computerCard play:)
						(self setCycle: End self)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mySound of Sound
	(properties
		flags 1
		number 200
		loop -1
	)
)

(instance stingSound of Sound ; UNUSED
	(properties
		number 201
	)
)

(instance doorClose of Sound
	(properties
		number 908
	)
)

(instance chairSlide of Sound
	(properties
		number 947
	)
)

(instance stinger of Sound
	(properties
		number 201
	)
)

(instance computerOn of Sound
	(properties
		number 214
	)
)

(instance computerCard of Sound
	(properties
		flags 1
		number 702
	)
)

