;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use Array)
(use Inset)
(use Cursor)
(use Actor)
(use System)

(public
	dialThePhone 0
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
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
)

(instance dialThePhone of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local12 (IntArray with: 0 0 0 0 0 0 0 0 0 0 0))
		(= local13 (IntArray with: 5 5 5 1 2 8 0))
		(= local14 (IntArray with: 5 5 5 1 2 7 0))
		(= local15 (IntArray with: 5 5 5 1 2 2 0))
		(= local16 (IntArray with: 5 3 5 1 2 3 7))
		(= local17 (IntArray with: 5 8 5 1 1 3 0))
		(= local18 (IntArray with: 5 5 5 6 1 7 0))
		(= local19 (IntArray with: 4 9 0 9 3 2 4 3 3 3 3))
	)

	(method (dispose)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(local15 dispose:)
		(local16 dispose:)
		(local17 dispose:)
		(local18 dispose:)
		(local19 dispose:)
		(gGkSound1 stop:)
		(gGkSound2 stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNarrator (ScriptID 220 1)) ; studioNarrator
				(gGame handsOn:)
				(gTheIconBar disable: 4 0 1 2 3 6 7 8 9 10)
				(phoneInset init: self (ScriptID 220)) ; rm220
				(= local22 gTheCursor)
				(gGame setCursor: myInsetArrowCursor)
			)
			(1
				(gGame setCursor: local22)
				(gGame handsOff:)
				(vetTeller dispose:)
				(travelAgentTeller dispose:)
				(= cycles 2)
			)
			(2
				(self dispose:)
				(DisposeScript 920)
				(DisposeScript 51)
				(DisposeScript 221)
			)
		)
	)
)

(instance pushTheButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(whichButton loop: 2 cel: 0 posn: 18 25 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2201 setLoop: 1 play:)
					)
					(2
						(whichButton loop: 2 cel: 1 x: 46 y: 25 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2202 setLoop: 1 play:)
					)
					(3
						(whichButton loop: 2 cel: 2 x: 74 y: 25 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2203 setLoop: 1 play:)
					)
					(4
						(whichButton loop: 2 cel: 3 x: 18 y: 45 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2204 setLoop: 1 play:)
					)
					(5
						(whichButton loop: 2 cel: 4 x: 46 y: 45 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2205 setLoop: 1 play:)
					)
					(6
						(whichButton loop: 2 cel: 5 x: 74 y: 45 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2206 setLoop: 1 play:)
					)
					(7
						(whichButton loop: 2 cel: 6 x: 18 y: 65 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2207 setLoop: 1 play:)
					)
					(8
						(whichButton loop: 2 cel: 7 x: 46 y: 65 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2208 setLoop: 1 play:)
					)
					(9
						(whichButton loop: 2 cel: 8 x: 74 y: 65 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2209 setLoop: 1 play:)
					)
					(10
						(whichButton loop: 2 cel: 10 x: 46 y: 85 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2210 setLoop: 1 play:)
					)
					(11
						(whichButton loop: 2 cel: 9 x: 18 y: 85 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2211 setLoop: 1 play:)
					)
					(12
						(whichButton loop: 2 cel: 11 x: 74 y: 85 init:)
						(gGkSound2 stop:)
						(gGkSound1 number: 2212 setLoop: 1 play:)
					)
					(14
						(whichButton loop: 3 cel: 0 x: 19 y: 9 setPri: 33 init:)
						(gGkSound1 number: 2213 setLoop: 1 play:)
						(gGkSound2 number: 2215 setLoop: -1 play:)
						(onLight init:)
						(if (= local9 1)
							(= local10 1)
						)
					)
					(15
						(whichButton loop: 3 cel: 1 x: 47 y: 9 setPri: 33 init:)
						(= local9 0)
						(if (gCast contains: onLight)
							(onLight dispose:)
						)
						(offLight init:)
						(gGkSound2 stop:)
					)
					(16
						(whichButton loop: 3 cel: 2 x: 75 y: 9 setPri: 33 init:)
						(gMessager say: 23 0 60 0) ; "(RRCC)Gabriel never has figured out how to operate the memory function on this phone."
					)
				)
				(= cycles 2)
			)
			(1
				(whichButton dispose:)
				(if (or (not local9) local10)
					(if (gCast contains: offLight)
						(offLight dispose:)
					)
					(if (gCast contains: slotZero)
						(slotZero dispose:)
					)
					(if (gCast contains: slotOne)
						(slotOne dispose:)
					)
					(if (gCast contains: slotTwo)
						(slotTwo dispose:)
					)
					(if (gCast contains: slotThree)
						(slotThree dispose:)
					)
					(if (gCast contains: slotFour)
						(slotFour dispose:)
					)
					(if (gCast contains: slotFive)
						(slotFive dispose:)
					)
					(if (gCast contains: slotSix)
						(slotSix dispose:)
					)
					(if (gCast contains: slotSeven)
						(slotSeven dispose:)
					)
					(if (gCast contains: slotEight)
						(slotEight dispose:)
					)
					(if (gCast contains: slotNine)
						(slotNine dispose:)
					)
					(if (gCast contains: slotTen)
						(slotTen dispose:)
					)
					(= local10 0)
					(= local0 0)
				)
				(= cycles 1)
			)
			(2
				(if local9
					(if (<= register 10)
						(if (== register 10)
							(= register 0)
						)
						(local12 at: local0 register)
						(for ((= local21 0)) (<= local21 local0) ((++ local21))
							(cond
								((== local21 0)
									(slotZero cel: (local12 at: local0) init:)
								)
								((== local21 1)
									(slotOne
										cel: (local12 at: (- local0 1))
										init:
									)
								)
								((== local21 2)
									(slotTwo
										cel: (local12 at: (- local0 2))
										init:
									)
								)
								((== local21 3)
									(slotThree
										cel: (local12 at: (- local0 3))
										init:
									)
								)
								((== local21 4)
									(slotFour
										cel: (local12 at: (- local0 4))
										init:
									)
								)
								((== local21 5)
									(slotFive
										cel: (local12 at: (- local0 5))
										init:
									)
								)
								((== local21 6)
									(slotSix
										cel: (local12 at: (- local0 6))
										init:
									)
								)
								((== local21 7)
									(slotSeven
										cel: (local12 at: (- local0 7))
										init:
									)
								)
								((== local21 8)
									(slotEight
										cel: (local12 at: (- local0 8))
										init:
									)
								)
								((== local21 9)
									(slotNine
										cel: (local12 at: (- local0 9))
										init:
									)
								)
								((== local21 10)
									(slotTen
										cel: (local12 at: (- local0 10))
										init:
									)
								)
							)
						)
						(++ local0)
						(if (>= local0 7)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local13 at: local25)
									)
									(= local1 1)
								else
									(= local1 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local14 at: local25)
									)
									(= local2 1)
								else
									(= local2 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local15 at: local25)
									)
									(= local3 1)
								else
									(= local3 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local16 at: local25)
									)
									(= local4 1)
								else
									(= local4 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local17 at: local25)
									)
									(= local5 1)
								else
									(= local5 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local18 at: local25)
									)
									(= local6 1)
								else
									(= local6 0)
									(break)
								)
							)
							(for ((= local25 0)) (<= local25 6) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local19 at: local25)
									)
									(= local8 1)
								else
									(= local8 0)
									(= local11 1)
									(break)
								)
							)
							(cond
								(local1
									(= local1 0)
									(if
										(and
											(not (IsFlag 312))
											(gEgo has: 7) ; phonePage
											(>= gDay 3)
										)
										(phoneInset setScript: callCaz)
									else
										(phoneInset setScript: thePhoneIsBusy)
									)
								)
								(local2
									(= local2 0)
									(if (and (gEgo has: 7) (>= gDay 3)) ; phonePage
										(phoneInset setScript: callCaz1)
									else
										(phoneInset setScript: thePhoneIsBusy)
									)
								)
								(local3
									(= local3 0)
									(if (and (gEgo has: 7) (>= gDay 3)) ; phonePage
										(phoneInset setScript: callCaz2)
									else
										(phoneInset setScript: thePhoneIsBusy)
									)
								)
								(local4
									(= local4 0)
									(if (and (gEgo has: 7) (>= gDay 3)) ; phonePage
										(phoneInset setScript: callCaz4)
									else
										(phoneInset setScript: thePhoneIsBusy)
									)
								)
								(local5
									(= local5 0)
									(if (IsFlag 269)
										(phoneInset setScript: thePhoneIsBusy)
									else
										(phoneInset setScript: callTravelAgent)
									)
								)
								(local6
									(= local6 0)
									(if
										(and
											(not (IsFlag 266))
											(gEgo has: 7) ; phonePage
											(>= gDay 3)
										)
										(phoneInset setScript: callTheVet)
									else
										(phoneInset setScript: thePhoneIsBusy)
									)
								)
								(local8
									(= local8 0)
									(if (and (<= 3 gDay 6) (IsFlag 447))
										(phoneInset setScript: noMoney)
									)
								)
								(local11
									(= local11 0)
									(phoneInset setScript: makeRandomCall)
								)
							)
						)
						(if (>= local0 11)
							(for ((= local25 0)) (<= local25 10) ((++ local25))
								(if
									(==
										(local12 at: local25)
										(local19 at: local25)
									)
									(= local7 1)
								else
									(= local7 0)
									(break)
								)
							)
							(if local7
								(= local7 0)
								(cond
									((== gDay 7)
										(cond
											((IsFlag 384)
												(phoneInset
													setScript: thePhoneIsBusy
												)
											)
											((IsFlag 327)
												(phoneInset
													setScript: callWolfDay7
												)
											)
											(else
												(SetFlag 327)
												(phoneInset
													setScript: callWolfFirstDay7
												)
											)
										)
									)
									((not (gEgo has: 8)) ; wolfPhone
										(phoneInset setScript: thePhoneIsBusy)
									)
									((and (gEgo has: 8) (not (IsFlag 282))) ; wolfPhone
										(phoneInset setScript: earlyCall)
									)
									((gEgo has: 8) ; wolfPhone
										(phoneInset setScript: callWolfGang)
									)
								)
							else
								(phoneInset setScript: makeRandomCall)
							)
						)
					)
					(self dispose:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance earlyCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 59 0 self) ; "(GK-AM2. ADAMANT)I'm not calling some stranger in Germany! I still don't know who this guy really is."
			)
			(1
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance thePhoneIsBusy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2216 setLoop: 1 play: self)
				else
					(self cue:)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2216 setLoop: 1 play: self)
				else
					(self cue:)
				)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2216 setLoop: 1 play: self)
				else
					(gMessager say: 23 0 62 0 self) ; "It's busy."
				)
			)
			(3
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance callCaz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 316)
					(gMessager sayRange: 23 0 20 1 6 self) ; "(RRCC. DEFENSIVE)Yes?"
					(SetFlag 312)
				else
					(gMessager sayRange: 23 0 19 1 6 self) ; "(RRCC. ON PHONE. GABE IS TRYING TO GET HER ADDRESS)Hello?"
					(SetFlag 316)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance callCaz2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 379)
					(gMessager say: 23 0 18 0 self) ; "Hello? Cazaunoux residence."
				else
					(gMessager say: 23 0 17 0 self) ; "Hi, Cazaunoux residence."
					(SetFlag 379)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance callCaz1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 380)
					(gMessager say: 23 0 16 0 self) ; "Hello?"
				else
					(gMessager say: 23 0 15 0 self) ; "Hello?"
					(SetFlag 380)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance callCaz4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 381)
					(gMessager say: 23 0 14 0 self) ; "Cazaunoux residence, may I help you?"
				else
					(gMessager say: 23 0 11 0 self) ; "(ARCC)Cazaunoux residence, may I help you?"
					(SetFlag 381)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(phoneInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance callTheVet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 12 0 self) ; "Cajun Critters Animal Clinic. This is Melissa."
			)
			(1
				(vetTeller init: gEgo doVerb: 11)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance callWolfGang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 29 0 self) ; "Guten Tag. Sie haben Schloss Ritter erreicht."
			)
			(1
				(gEgo getPoints: 172 2)
				(SetFlag 447)
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance callWolfDay7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 270)
					(gMessager say: 23 0 35 0 self) ; "Guten Tag. Sie haben Schloss Ritter erreicht."
				else
					(gMessager say: 23 0 36 0 self) ; "Guten Tag. Sie haben Schloss Ritter erreicht."
				)
			)
			(1
				(if (IsFlag 270)
					(SetFlag 384)
					(self dispose:)
					(phoneInset dispose:)
				else
					(SetFlag 324)
					(self dispose:)
					(phoneInset dispose:)
				)
			)
		)
	)
)

(instance callWolfFirstDay7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 34 0 self) ; "Guten Tag. Sie haben Schloss Ritter erreicht."
			)
			(1
				(SetFlag 324)
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance callTravelAgent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 37 0 self) ; "(RRCC. FRIENDLY)Hello. C the World Travel Agency. How may I help you?"
			)
			(1
				(travelAgentTeller init: gEgo doVerb: 11)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance makeRandomCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local20 (Random 1 7))
				(= cycles 1)
			)
			(1
				(switch local20
					(1
						(gMessager say: 23 0 4 0 self) ; "The number you have dialed has been disconnected."
					)
					(2
						(gMessager say: 23 0 5 0 self) ; "Please hang up and try your call again. This is a recording."
					)
					(3
						(gMessager say: 23 0 6 0 self) ; "Yeah? Whaddya want?"
					)
					(4
						(gMessager say: 23 0 7 0 self) ; "(SEXY VOICE)Hello? Robert?"
					)
					(5
						(gMessager say: 23 0 8 0 self) ; "Flanny's Pizza. May I take your order?"
					)
					(6
						(gMessager say: 23 0 9 0 self) ; "Hello. St. Genevieve's Wedding Chapel. How may I help you?"
					)
					(7
						(gMessager say: 23 0 10 0 self) ; "Allo? Qui est la?"
					)
				)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGkSound1 number: 2215 setLoop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance noMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 23 0 30 0 self) ; "(RRCC. FIRM. TO PLAYER.)No. I can't afford to call Germany again until I've figured more of this out."
			)
			(1
				(self dispose:)
				(phoneInset dispose:)
			)
		)
	)
)

(instance vetTeller of GKTeller
	(properties
		curNoun 28
		sayNoun 29
		verb 119
	)

	(method (showCases)
		(super
			showCases:
				13 ; Do you know anything about snakes?
				(not (IsFlag 313))
				21 ; Do you have a Madame Cazaunoux as a client?
				(not (IsFlag 315))
				22 ; Know anything about animal sacrifice?
				(not (IsFlag 317))
				23 ; About Madame Cazaunoux?
				(IsFlag 315)
				25 ; I'm worried about Castro. He's missed three dance lessons.
				(IsFlag 316)
		)
	)

	(method (cue)
		(cond
			((OneOf iconValue 27 24 26) ; Sorry. Wrong number., She's my aunt, and I've lost touch., She's won a major prize.
				(gEgo actions: 0)
				(callTheVet cue:)
			)
			((== iconValue 22) ; Know anything about animal sacrifice?
				(SetFlag 317)
				(gEgo actions: 0)
				(callTheVet cue:)
			)
			((== iconValue 21) ; Do you have a Madame Cazaunoux as a client?
				(SetFlag 315)
				(self doVerb: 11)
			)
			((== iconValue 13) ; Do you know anything about snakes?
				(SetFlag 313)
				(gEgo actions: 0)
				(callTheVet cue:)
			)
			((== iconValue 25) ; I'm worried about Castro. He's missed three dance lessons.
				(SetFlag 266)
				(gEgo actions: 0)
				(gEgo getPoints: -999 2)
				(callTheVet cue:)
			)
			(else
				(self doVerb: 11)
			)
		)
	)
)

(instance travelAgentTeller of GKTeller
	(properties
		curNoun 33
		sayNoun 29
		verb 113
	)

	(method (showCases)
		(super
			showCases:
				38 ; What are your specials?
				(not (IsFlag 342))
				39 ; How much for a trip to the Carribean?
				(and (not (IsFlag 343)) (IsFlag 342))
				40 ; I've always wanted to visit Anderson, Indiana.
				(and (IsFlag 343) (not (IsFlag 344)))
				41 ; Can you just get me out of here, please?
				(IsFlag 344)
				42 ; How much for a trip to Rittersberg, Germany?
				(and (IsFlag 447) (not (IsFlag 345)))
				43 ; What about that trip to Rittersberg, Germany?
				(IsFlag 345)
				44 ; Charge it to my Americans Repressed.
				(if (gEgo has: 71) ; master_card
				)
		)
	)

	(method (cue)
		(cond
			((== iconValue 38) ; What are your specials?
				(SetFlag 342)
				(self doVerb: 11)
			)
			((== iconValue 39) ; How much for a trip to the Carribean?
				(SetFlag 343)
				(self doVerb: 11)
			)
			((== iconValue 40) ; I've always wanted to visit Anderson, Indiana.
				(SetFlag 344)
				(self doVerb: 11)
			)
			((== iconValue 42) ; How much for a trip to Rittersberg, Germany?
				(SetFlag 345)
				(self doVerb: 11)
			)
			((or (== iconValue 46) (== iconValue 45)) ; Sorry, wrong number., I can't afford it. Sorry.
				(gEgo actions: 0)
				(callTravelAgent cue:)
			)
			((== iconValue 44) ; Charge it to my Americans Repressed.
				(SetFlag 269)
				(SetFlag 400)
				(gEgo actions: 0)
				(gEgo getPoints: -999 5)
				(callTravelAgent cue:)
			)
			(else
				(self doVerb: 11)
			)
		)
	)
)

(instance phoneInset of Inset
	(properties
		view 226
		loop 1
		x 42
		y 22
		disposeNotOnMe 1
		modNum 220
		noun 27
	)

	(method (doVerb)
		(cond
			((InRect 19 26 42 43 local23 local24)
				(self setScript: pushTheButton 0 1)
			)
			((InRect 46 26 70 43 local23 local24)
				(self setScript: pushTheButton 0 2)
			)
			((InRect 75 26 98 43 local23 local24)
				(self setScript: pushTheButton 0 3)
			)
			((InRect 19 46 42 62 local23 local24)
				(self setScript: pushTheButton 0 4)
			)
			((InRect 46 46 70 62 local23 local24)
				(self setScript: pushTheButton 0 5)
			)
			((InRect 75 46 98 62 local23 local24)
				(self setScript: pushTheButton 0 6)
			)
			((InRect 19 66 42 81 local23 local24)
				(self setScript: pushTheButton 0 7)
			)
			((InRect 46 66 70 81 local23 local24)
				(self setScript: pushTheButton 0 8)
			)
			((InRect 75 66 98 81 local23 local24)
				(self setScript: pushTheButton 0 9)
			)
			((InRect 46 86 70 100 local23 local24)
				(self setScript: pushTheButton 0 10)
			)
			((InRect 19 86 42 100 local23 local24)
				(self setScript: pushTheButton 0 11)
			)
			((InRect 75 86 98 100 local23 local24)
				(self setScript: pushTheButton 0 12)
			)
			((InRect 18 10 42 21 local23 local24)
				(self setScript: pushTheButton 0 14)
			)
			((InRect 46 10 70 21 local23 local24)
				(self setScript: pushTheButton 0 15)
			)
			((InRect 75 10 98 21 local23 local24)
				(self setScript: pushTheButton 0 16)
			)
			(else
				(gMessager say: noun 0 0 0 0 220) ; "There's nothing there to operate."
			)
		)
		(return 1)
	)

	(method (doit &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if (not (temp0 type:))
			(temp0 localize: (gCast plane:))
			(cond
				((not (self onMe: temp0))
					(if (!= gTheCursor myExitCursor)
						(gGame setCursor: myExitCursor 1)
					)
				)
				((!= gTheCursor myInsetArrowCursor)
					(gGame setCursor: myInsetArrowCursor 1)
				)
			)
		)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSEBUTTON)
			(= local23 (event x:))
			(= local24 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance whichButton of View
	(properties
		x 61
		y 47
		view 226
		loop 2
	)
)

(instance onLight of View
	(properties
		x 27
		y 2
		view 226
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 33)
	)
)

(instance offLight of View
	(properties
		x 55
		y 2
		view 226
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 33)
	)
)

(instance slotZero of View
	(properties
		x 93
		y 108
		view 226
		loop 6
	)
)

(instance slotOne of View
	(properties
		x 87
		y 108
		view 226
		loop 6
	)
)

(instance slotTwo of View
	(properties
		x 81
		y 108
		view 226
		loop 6
	)
)

(instance slotThree of View
	(properties
		x 75
		y 108
		view 226
		loop 6
	)
)

(instance slotFour of View
	(properties
		x 69
		y 108
		view 226
		loop 6
	)
)

(instance slotFive of View
	(properties
		x 63
		y 108
		view 226
		loop 6
	)
)

(instance slotSix of View
	(properties
		x 57
		y 108
		view 226
		loop 6
	)
)

(instance slotSeven of View
	(properties
		x 51
		y 108
		view 226
		loop 6
	)
)

(instance slotEight of View
	(properties
		x 45
		y 108
		view 226
		loop 6
	)
)

(instance slotNine of View
	(properties
		x 39
		y 108
		view 226
		loop 6
	)
)

(instance slotTen of View
	(properties
		x 33
		y 108
		view 226
		loop 6
	)
)

(instance myInsetArrowCursor of Cursor
	(properties
		view 999
	)
)

(instance myExitCursor of Cursor
	(properties
		view 961
	)
)

