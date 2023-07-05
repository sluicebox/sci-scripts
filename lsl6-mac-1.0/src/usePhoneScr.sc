;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 622)
(include sci.sh)
(use Main)
(use n079)
(use TTDialer)
(use Motion)
(use System)

(public
	usePhoneScr 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1)
	(return (& [global197 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 (localproc_0 param1))
	(= [global197 (/ param1 16)]
		(| [global197 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= temp0 (localproc_0 param1))
	(= [global197 (/ param1 16)]
		(& [global197 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(instance insultScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 30] temp30)
		(switch (= state newState)
			(0
				(if register
					((ScriptID 610 1) talkWidth: 200) ; unknown_610_16
					(gMessager say: 1 4 68 1 self 610) ; "Concierge Desk, Carlos speaking."
				else
					(gMessager say: 1 4 73 0 self 610) ; "You've reached the Fresno Insult Line."
				)
			)
			(1
				(= local5 (Random 1 61))
				(if (localproc_0 local5)
					(if (> (++ local0) 50)
						(for ((= temp30 0)) (<= temp30 4) ((++ temp30))
							(= [global197 temp30] 0)
						)
						(for ((= temp30 1)) (<= temp30 61) ((++ temp30))
							(localproc_2 temp30)
						)
						(= local0 0)
					)
					(-- state)
					(self cue:)
				else
					(localproc_1 local5)
					(gMessager say: 1 4 local5 0 self 611)
				)
			)
			(2
				(if register
					(= seconds 2)
				else
					(= register 0)
					(self dispose:)
				)
			)
			(3
				((ScriptID 610 1) talkWidth: 100) ; unknown_610_16
				(gMessager say: 1 4 68 3 self 610) ; "Have a nice day."
			)
			(4
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance hangUpPhoneScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (== (gGlobalSound1 number:) 627)
					(gGlobalSound1 number: 620 loop: -1 play:)
				else
					(gGlobalSound1 fade: 127 10 10 0)
				)
				(if (IsFlag 75)
					((ScriptID 620 3) startUpd:) ; bed
					((ScriptID 620 6) startUpd:) ; theCondom
				)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 621
					setLoop: 1
					cel: 6
					cycleSpeed: 6
					setCycle: CT 4 -1 self
				)
			)
			(2
				((ScriptID 620 1) cel: 0 x: 173 y: 116 forceUpd:) ; phone
				((ScriptID 620 2) number: 623 loop: 1 play:) ; sfx
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					view: 621
					setLoop: 0
					cel: 5
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(4
				(= ticks 20)
			)
			(5
				((ScriptID 620 1) show:) ; phone
				(gEgo normalize: 900 4 x: 157 y: 132 heading: 125)
				(UnLoad 128 621)
				(UnLoad 128 610)
				(UnLoad 143 610)
				(ClearFlag 57)
				(ClearFlag 76)
				(ClearFlag 86)
				(gGame handsOn:)
				(Platform 0 4 2 6)
				(self dispose:)
				(DisposeScript 622)
			)
		)
	)
)

(instance frontDeskScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (OneOf global171 1 9))
						(gMessager say: 1 4 19 1 self 610) ; "It seems there is no answer at that number."
					)
					((IsFlag 73)
						(gMessager say: 1 4 69 0 self 610) ; "Front desk, may I help you?"
					)
					(else
						(SetFlag 73)
						(gMessager say: 1 4 9 0 self 610) ; "Front desk. May I help you?"
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance usePhoneScr of Script
	(properties)

	(method (dispose)
		(proc610_2)
		(= next hangUpPhoneScr)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Platform 0 4 3 6)
				(Load rsVIEW 610)
				(UnLoad 128 900)
				(Load rsMESSAGE 610)
				(if (not (IsFlag 76))
					(gEgo setLoop: 8 cel: 4 heading: 125)
				else
					(= state 5)
				)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 621
					setLoop: 0
					cel: 0
					setCycle: End self
					cycleSpeed: 6
				)
			)
			(2
				(gEgo setLoop: 1 cel: 0 setCycle: 0)
				(= ticks 20)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				((ScriptID 620 1) cel: 1 x: 175 y: 119 forceUpd:) ; phone
				((ScriptID 620 2) number: 622 loop: 1 play:) ; sfx
				(gEgo setCycle: End self)
			)
			(5
				(UnLoad 128 621)
				(gEgo view: 623 setLoop: 0 cel: 0)
				(= cycles 2)
			)
			(6
				(gGlobalSound1 fade: 80 10 10 0)
				(SetFlag 86)
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(7
				(gGame handsOff:)
				(= local4 1)
				(= ticks 30)
			)
			(8
				(switch register
					(9998)
					(9991)
					(9993)
					(9992)
					(9994)
					(9989)
					(71
						(gGame changeScore: 1 242)
					)
					(72)
					(73)
					(74)
					(75)
					(76
						(gGame changeScore: 8 244)
					)
				)
				(= seconds 3)
			)
			(9
				(= local2 0)
				(switch register
					(9998
						(gMessager say: 1 4 7 0 self 610) ; "Hello. You have reached 911. I'm sorry, but we can't come to the phone right now. Please hold or leave a message after the tone..."
					)
					(9991
						(= local2 1)
						(self setScript: frontDeskScr self)
					)
					(9993
						(gMessager say: 1 4 13 0 self 610) ; "I'm sorry, but this telephone is not authorized for long distance dialing."
					)
					(9992
						(gMessager say: 1 4 12 0 self 610) ; "I'm sorry, but this telephone is not authorized for local dialing."
					)
					(9994
						(self setScript: (ScriptID 623 1) self) ; sexLineScr
					)
					(9989
						(self setScript: (ScriptID 623 1) self) ; sexLineScr
					)
					(71
						(self setScript: (ScriptID 621 0) self) ; roomServiceScr
					)
					(72
						(gMessager say: 1 4 4 0 self 610) ; "Bell desk. May I help you?"
					)
					(73
						(self setScript: insultScr self 1)
					)
					(74
						(gMessager say: 1 4 8 0 self 610) ; "Hello, you've reached La Costa Lotta's "Excursion Desk." For tomorrow, we have planned a wonderful trip for your vacationing pleasure:"
					)
					(75
						(cond
							((and (not (IsFlag 240)) (IsFlag 236))
								(gGame changeScore: 9 240)
								(gMessager say: 1 4 11 0 self 610) ; "Housekeeping. May I help you?"
							)
							((IsFlag 79)
								(gMessager say: 1 4 87 0 self 610) ; "Housekeeping. May I help you?"
							)
							(
								(and
									(IsFlag 77)
									(not (IsFlag 82))
									(or
										(not (gEgo has: 34)) ; soap
										(not (gEgo has: 37)) ; toiletpaper
									)
								)
								(SetFlag 82)
								(SetFlag 83)
								(if (>= global184 7)
									(-- global184)
								)
								(gMessager say: 1 4 80 0 self 610) ; "Housekeeping. May I help you?"
							)
							(
								(and
									(IsFlag 82)
									(or
										(not (gEgo has: 34)) ; soap
										(not (gEgo has: 37)) ; toiletpaper
									)
								)
								(gMessager say: 1 4 81 0 self 610) ; "Housekeeping. May I help you?"
							)
							((not (IsFlag 236))
								(gMessager say: 1 4 86 0 self 610) ; "Housekeeping. May I help you?"
							)
							(
								(and
									(gCast contains: (ScriptID 620 6)) ; theCondom
									(not (IsFlag 241))
									(IsFlag 240)
								)
								(gMessager say: 1 4 85 0 self 610) ; "Housekeeping. May I help you?"
							)
							(
								(and
									(not (gCast contains: (ScriptID 620 6))) ; theCondom
									(not (IsFlag 241))
									(IsFlag 240)
								)
								(gMessager say: 1 4 77 0 self 610) ; "Housekeeping. May I help you?"
							)
							((and (IsFlag 240) (IsFlag 241))
								(gMessager say: 1 4 10 0 self 610) ; "Housekeeping. May I help you?"
							)
							(else
								(gMessager say: 1 4 84 0 self 610) ; "Housekeeping. May I help you?"
							)
						)
					)
					(76
						(cond
							((and (not (IsFlag 34)) (IsFlag 19))
								(gGame changeScore: 8 244)
								(SetFlag 34)
								(gMessager say: 1 4 14 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							(
								(and
									(IsFlag 34)
									(not (IsFlag 12))
									(not (IsFlag 101))
								)
								(gMessager say: 1 4 18 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							((and (not (IsFlag 79)) (IsFlag 12))
								(gMessager say: 1 4 15 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							(
								(and
									(IsFlag 101)
									(or (IsFlag 79) (not (IsFlag 12)))
								)
								(gMessager say: 1 4 16 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							((and (not (IsFlag 80)) (IsFlag 79))
								(SetFlag 80)
								(gMessager say: 1 4 78 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							((and (IsFlag 80) (IsFlag 79))
								(gMessager say: 1 4 79 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
							(else
								(gMessager say: 1 4 17 0 self 610) ; "Building Maintenance, Landscaping and Grounds. May I help you?"
							)
						)
					)
					(23292
						(gMessager say: 1 4 72 0 self 610) ; "Sorry, we're unable to come to the phone right now, but if you leave your name and number after the beep, we'll ignore you until it's convenient for us!"
					)
					(18724
						(gGlobalSound1 number: 627 loop: -1 play: 127)
						(gMessager say: 1 4 20 0 self 610) ; "...cue for calling Sierra On-Line. Once we had a full-time operator, but now all we have is voice mail. But, don't worry, there's absolutely nothing that can go wrong."
					)
					(-6832
						(self setScript: insultScr self)
					)
					(275
						(gMessager say: 1 4 82 0 self 610) ; "It's time to play "LEAVE YOUR MESSAGE""
					)
					(-30981
						(gMessager say: 1 4 74 0 self 610) ; "Sorry, we're experiencing difficulty on this line. If you require further assistance, please call Sierra Telephone and ask for Connie. If she is unavailable, Boomer or Ozzy will be glad to take your call."
					)
					(16659
						(gMessager say: 1 4 75 0 self 610) ; "I'm not near the phone right now, but if you leave your name, your phone number, and a brief message, I'll get back in touch with you as soon as I get this code cleaned up!"
					)
					(-17883
						(gMessager say: 1 4 76 0 self 610) ; "We're not near the phone, but leave a message and we'll call you back."
					)
					(5695
						(gMessager say: 1 4 83 0 self 610) ; "Hi, this is Chris. Sorry, I'm not home right now. Eric, Brian, Brent and I are busy hauling Rob's inebriated carcass from bar to bar in South Lake Tahoe."
					)
					(else
						(= local2 1)
						(if (== register -1)
							(= cycles 2)
						else
							((ScriptID 620 2) number: 24 loop: 1 play:) ; sfx
							(if (not (Random 0 1))
								(gMessager say: 1 4 3 0 self 610) ; "The number you have dialed has been disconnected or is no longer in service. If you feel you have reached this recording in error, feel free to keep dialing it over and over, again and again, until you get sick and tired of hearing this same message!"
							else
								(gMessager say: 1 4 19 0 self 610) ; "It seems there is no answer at that number."
							)
						)
					)
				)
			)
			(10
				(if (IsFlag 97)
					(self setScript: (ScriptID 621 0) self) ; roomServiceScr
				else
					(self dispose:)
				)
			)
			(11
				(self dispose:)
			)
		)
	)
)

