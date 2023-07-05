;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm205 0
)

(local
	textUp
)

(instance rm205 of LLRoom
	(properties)

	(method (init &tmp num)
		(super init:)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(SetFFRoom 1000 self)
		(gTheIconBar disable: 8)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gTheIconBar enable: 8)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON evKEYBOARD)
			(if textUp
				(textUp cue:)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCast eachElementDo: #dispose)
				(DrawPic 1 12)
				(gGame setCursor: gTheCursor 1 300 180)
				(switch (++ gMeanWhiles)
					(1
						(gCurRoom picture: 120 curPic: 120)
						(gTheMusic2 number: 210 setLoop: -1 play: 127)
						(self setScript: sMobWantsCane self)
					)
					(2
						(gCurRoom picture: 215 curPic: 215)
						(gTheMusic2 number: 215 setLoop: -1 play: 127)
						(self setScript: sScruemallGetsCall self)
					)
					(3
						(gCurRoom picture: 220 curPic: 220)
						(gTheMusic2 number: 215 setLoop: -1 play: 127)
						(self setScript: sCaneGetsBigGrant self)
					)
					(4
						(gCurRoom picture: 225 curPic: 225)
						(gTheMusic2 number: 215 setLoop: -1 play: 127)
						(self setScript: sCaneWorksCongress self)
					)
				)
			)
			(1
				(if script
					(script caller: 0 dispose:)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= textUp self)
				(DrawPic 1 11)
				(CenterDisplay 2 gColWhite 205 0)
				(gTheMusic2 fade: 0 15 5 1)
				(gTheMusic number: 204 loop: -1 play: 0 fade: 127 15 5 0)
				(= seconds 3)
			)
			(2
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sMobWantsCane of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= textUp self)
				(CenterDisplay 4 gColWhite 205 1)
				(= seconds 5)
			)
			(1
				(= textUp 0)
				(DrawPic 120 12)
				(leftEyebrow init:)
				(rightEyebrow init:)
				(cigar init:)
				(hand init:)
				(= ticks 30)
			)
			(2
				(cigar setCycle: RandCycle)
				(leftEyebrow setCycle: RandCycle)
				(rightEyebrow setCycle: RandCycle)
				(TPrint 205 2 80 {Mr. Bigg} 108 self 67 -1 185) ; "So, tell me, boys," says Mr. Bigg, "is everything proceeding according to our plan?"
			)
			(3
				(cigar setCycle: 0)
				(hand setCycle: Fwd)
				(leftEyebrow setCycle: Beg)
				(rightEyebrow setCycle: Beg)
				(Say Vinnie 205 3 108 139 self) ; "Yes sir, Mr. Bigg! Our friends in Hollywood have the industry in an uproar. Their `America's Sexiest Home Videos' show is the talk of show biz!"
			)
			(4
				(= ticks 45)
			)
			(5
				(Say Vinnie 205 4 108 139 self) ; "There's every indication it will be the smash hit of the fall season."
			)
			(6
				(= ticks 45)
			)
			(7
				(Say Bruno 205 5 108 139 self) ; "And we've found the perfect way to attack our little straw dog: I've discovered a new, hyper-active, political action committee called `Conservatives Against Nearly Everything.'"
			)
			(8
				(= ticks 45)
			)
			(9
				(Say Bruno 205 6 108 139 self) ; "I'm sure they would be willing to become the focus of a national campaign to clean up the airwaves."
			)
			(10
				(= ticks 45)
			)
			(11
				(Say Bruno 205 7 108 139 self) ; "I'd like to propose to you, Boss, that we make a `little investment' in the health and well-being of C.A.N.E. You know, a `little something' to show how much we support their cause.'"
			)
			(12
				(TPrint 205 8) ; "The room is filled with suppressed laughter."
				(= ticks 45)
			)
			(13
				(leftEyebrow setCycle: RandCycle)
				(rightEyebrow setCycle: RandCycle)
				(hand setCycle: End)
				(cigar setCycle: RandCycle)
				(TPrint 205 9 80 {Mr. Bigg} 108 self 67 -1 185) ; "Well, boys, I think you know I'm always interested in `raising C.A.N.E.!'"
			)
			(14
				(leftEyebrow setCycle: Beg)
				(rightEyebrow setCycle: Beg)
				(hand setCycle: Beg)
				(TPrint 205 10) ; "The laughter becomes unsuppressed!"
				(= ticks 30)
			)
			(15
				(cigar setCycle: Fwd)
				(TPrint 205 11 80 {Mr. Bigg} 108 self 67 -1 185) ; "This bunch sounds like the perfect group to be the vanguard of our little protest against the filth of the airwaves! Why don't you make an anonymous contribution to our simple little friends at C.A.N.E., eh, boys?"
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance sScruemallGetsCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= textUp self)
				(CenterDisplay 3 gColWhite 205 12)
				(= seconds 5)
			)
			(1
				(= textUp 0)
				(DrawPic 215 12)
				(= cycles 2)
			)
			(2
				(TPrint 205 13 67 -1 185 70 280) ; "Silas Scruemall listens intently and deferentially to the powerful voice on the other end of the line."
				(= ticks 45)
			)
			(3
				(Say Silas_Scruemall 205 14 108 139 self) ; "Let me assure you, Julius: everything IS proceeding nicely. No, sir. I will NOT let you down."
			)
			(4
				(= ticks 45)
			)
			(5
				(Say Silas_Scruemall 205 15 108 139 self) ; "Yes, sir. That's also being taken care of. No, it's handled. I have a man on it right now. All right; whatever you say, Julius!"
			)
			(6
				(= ticks 30)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sCaneGetsBigGrant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= textUp self)
				(CenterDisplay 4 gColWhite 205 16)
				(= seconds 5)
			)
			(1
				(= textUp 0)
				(DrawPic 220 12)
				(= cycles 2)
			)
			(2
				(Say ; "Well, thank you, gentlemen. I promise your CONSIDERABLE contribution will not be wasted!"
					President_of_C_A_N_E__GPr_sident_der_B_G_F_A_
					205
					17
					108
					139
					self
				)
			)
			(3
				(= ticks 45)
			)
			(4
				(Say ; "I daresay this one donation will enable us to now succeed where we've been unable to before. You just don't know how grateful we are!"
					President_of_C_A_N_E__GPr_sident_der_B_G_F_A_
					205
					18
					108
					139
					self
				)
			)
			(5
				(= ticks 45)
			)
			(6
				(Say Luigi 205 19 108 139 self) ; "You're welcome. But, just remember: our `benefactor' insists that his contribution remain completely anonymous."
			)
			(7
				(= ticks 45)
			)
			(8
				(Say Luigi 205 20 108 139 self) ; "There are no strings attached; do with it as you will. But--he expects to see positive benefits immediately. Is that acceptable to you?"
			)
			(9
				(= ticks 45)
			)
			(10
				(Say ; "Why, sure. In fact, I know just where this money would do the most good. Tell your boss he's made the right decision going with us! C.A.N.E. will not let him down!"
					President_of_C_A_N_E__GPr_sident_der_B_G_F_A_
					205
					21
					108
					139
					self
				)
			)
			(11
				(= ticks 45)
			)
			(12
				(Say Luigi 205 22 108 139 self) ; "Oh, let's just say he fully intends to see that you live up to your end of this bargain (if you get my drift)."
			)
			(13
				(= ticks 30)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance sCaneWorksCongress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= textUp self)
				(CenterDisplay 4 gColWhite 205 23)
				(= seconds 7)
			)
			(1
				(= textUp 0)
				(DrawPic 225 12)
				(= cycles 2)
			)
			(2
				(face init:)
				(arm init: setCycle: End self)
			)
			(3
				(TPrint ; "And as you know (blah blah blah) interested in traditional American values, (blah blah blah) my campaign promises (blah blah blah) good and virtue (blah blah blah)"
					205
					24
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(4
				(TPrint ; "And furthermore (blah blah blah) if re-elected, I will (blah blah blah) pornography, blatant exploitation (blah blah blah) minors, miners (blah blah blah)"
					205
					25
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(5
				(TPrint ; "And in conclusion, (blah blah blah) (blah blah blah)"
					205
					26
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 45)
			)
			(6
				(Say ; "Yeah, okay, Senator, we've got it. Here's the deal: there's plenty more where this comes from, as long as we see some progress on that bill to tighten regulation of the airwaves."
					A_C_A_N_E__er_GEin_Mitglied_von_B_G_F_A
					205
					27
					108
					139
					self
				)
			)
			(7
				(= ticks 45)
			)
			(8
				(Say ; "We want that smut off the air--and we're willing to back up our beliefs in the `traditional' American way. So? Do you want it or don't you?"
					A_C_A_N_E__er_GEin_Mitglied_von_B_G_F_A
					205
					28
					108
					139
					self
				)
			)
			(9
				(= ticks 45)
			)
			(10
				(TPrint ; ""Gimme that suitcase, boy. I got legislation to write!" he grins."
					205
					29
					80
					{Your Elected Official}
					67
					100
					185
					70
					220
				)
				(= ticks 30)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance leftEyebrow of Prop
	(properties
		x 213
		y 57
		view 124
		priority 14
		signal 16400
	)
)

(instance rightEyebrow of Prop
	(properties
		x 227
		y 57
		view 124
		loop 1
		priority 14
		signal 16400
	)
)

(instance cigar of Prop
	(properties
		x 168
		y 87
		view 124
		loop 3
		priority 14
		signal 16400
	)
)

(instance hand of Prop
	(properties
		x 154
		y 149
		view 124
		loop 4
		priority 14
		signal 16400
	)
)

(instance face of Prop
	(properties
		x 221
		y 114
		view 227
		priority 14
		signal 16400
	)
)

(instance arm of Prop
	(properties
		x 155
		y 110
		view 225
		priority 14
		signal 16400
	)
)

(instance Vinnie of Talker
	(properties
		x 1
		y 180
		nsTop 66
		nsLeft 67
		view 1122
		loop 3
		talkWidth 250
	)

	(method (init)
		(= mouth mobFlunky1Mouth)
		(super init: &rest)
	)
)

(instance mobFlunky1Mouth of Prop
	(properties
		nsTop 31
		nsLeft 23
		view 1122
	)
)

(instance Bruno of Talker
	(properties
		x 30
		y 180
		nsTop 95
		nsLeft 267
		view 1123
		loop 3
	)

	(method (init)
		(= mouth mobFlunky2Mouth)
		(super init: &rest)
	)
)

(instance mobFlunky2Mouth of Prop
	(properties
		view 1123
	)
)

(instance Silas_Scruemall of Talker
	(properties
		name {Silas Scruemall}
		x 80
		y 150
		nsTop 48
		nsLeft 173
		view 1215
		loop 3
		talkWidth 160
	)

	(method (init)
		(= bust silasBust)
		(= eyes silasEyes)
		(= mouth silasMouth)
		(super init: &rest)
	)
)

(instance silasBust of View
	(properties
		view 1215
		loop 1
	)
)

(instance silasEyes of Prop
	(properties
		nsTop 1
		nsLeft -2
		view 1215
		loop 2
	)
)

(instance silasMouth of Prop
	(properties
		nsTop 20
		view 1215
	)
)

(instance President_of_C_A_N_E__GPr_sident_der_B_G_F_A_ of Talker
	(properties
		name {President of C.A.N.E.}
		x 120
		y 160
		nsTop 55
		nsLeft 192
		view 1220
		loop 3
	)

	(method (init)
		(= bust presBust)
		(= eyes presEyes)
		(= mouth presMouth)
		(super init: &rest)
	)
)

(instance presBust of View
	(properties
		view 1220
		loop 1
	)
)

(instance presEyes of Prop
	(properties
		nsTop 18
		nsLeft 17
		view 1220
		loop 2
	)
)

(instance presMouth of Prop
	(properties
		nsTop 35
		view 1220
	)
)

(instance Luigi of Talker
	(properties
		x 1
		y 160
		nsTop 77
		nsLeft 95
		view 1221
		loop 3
		talkWidth 200
	)

	(method (init)
		(= eyes flunkyEyes)
		(= mouth flunkyMouth)
		(super init: &rest)
	)
)

(instance flunkyEyes of Prop
	(properties
		nsTop -7
		nsLeft 1
		view 1221
		loop 2
	)
)

(instance flunkyMouth of Prop
	(properties
		view 1221
	)
)

(instance A_C_A_N_E__er_GEin_Mitglied_von_B_G_F_A of Talker
	(properties
		name {A C.A.N.E.-er}
		x 1
		y 140
		nsTop 95
		nsLeft 144
		view 1225
		loop 3
		talkWidth 250
	)

	(method (init)
		(= eyes congressEyes)
		(= mouth congressMouth)
		(super init: &rest)
	)
)

(instance congressEyes of Prop
	(properties
		nsTop -10
		nsLeft -61
		view 1225
		loop 2
	)
)

(instance congressMouth of Prop
	(properties
		view 1225
	)
)

