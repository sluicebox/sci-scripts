;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 243)
(include sci.sh)
(use Main)
(use eureka)
(use rm240)
(use Scaler)
(use Osc)
(use PolyPath)
(use ForwardCounter)
(use Rev)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	upFromThrakus 1
	putBeaInBox 2
	openChamber 4
	pickBeaUp 5
	getBeaFromChamber 6
	putBeaOnPad 7
	spikeNailsEgo 8
	putSpikeInTank 9
	spikeEscapes 10
	getSpike 11
	useAntAcids 12
	beamToGenetix 13
	specialBeam 14
	upFromKU 21
	putOnMask 22
	talkAboutBea 23
	cliffyGoesWith 24
	bounceEgo 25
	spikeEscapes2 26
	askAboutBea 27
	goliathConv 28
	upFromThrakus2 29
	funnyBeam 30
	upFromKU2 31
)

(local
	local0
)

(instance cliffyGoesWith of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 2 7 0 self) ; "Wait up, Cap'n. I'll go with ya."
			)
			(1
				(proc240_28 1)
				((ScriptID 240 21) setMotion: MoveTo 179 164 self) ; cliffy
			)
			(2
				((ScriptID 240 21) setMotion: MoveTo 176 152 self) ; cliffy
			)
			(3
				((ScriptID 240 21) setMotion: MoveTo 121 148 self) ; cliffy
			)
			(4
				((ScriptID 240 21) setHeading: 180 self) ; cliffy
			)
			(5
				((ScriptID 240 21) ; cliffy
					view: 33
					loop: 0
					cel: ((ScriptID 240 21) lastCel:) ; cliffy
				)
				(self dispose:)
			)
		)
	)
)

(instance spikeNailsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(gSq5Music1 number: 23 loop: -1 play:)
				((ScriptID 240 8) ; spike
					init: 1
					setCycle: Walk
					setScale: Scaler 85 50 144 122
					detailLevel: 0
					setMotion:
						MoveTo
						(+ (gEgo x:) 30)
						(+ (gEgo y:) 5)
						self
				)
			)
			(1
				(gEgo setHeading: 135 self)
				((ScriptID 240 8) setHeading: 270) ; spike
			)
			(2
				((ScriptID 240 8) dispose:) ; spike
				(= register 3)
				(= start 0)
				(gEgo
					view: 192
					loop: 0
					cel: 0
					setScale: Scaler 116 71 149 123
					setCycle: End self
				)
				(gSq5Music2 number: 246 loop: 1 play:)
			)
			(3
				(gEgo setCycle: CT 5 -1 self)
			)
			(4
				(gEgo setCycle: End self)
				(if (-- register)
					(-= state 2)
				)
			)
			(5
				(gSq5Music2 number: 2471 loop: -1 play:)
				(= register 3)
				(gEgo loop: 1 cel: 0)
				(= cycles 1)
			)
			(6
				(gEgo setCycle: CT 4 1 self)
			)
			(7
				(gEgo setCycle: CT 1 -1 self)
				(if (-- register)
					(-= state 2)
				)
			)
			(8
				(gEgo setCycle: End self)
				(gSq5Music2 number: 247 loop: 1 play:)
			)
			(9
				(gEgo view: 192 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(NormalEgo 0 4)
				(= gSpikeState 6)
				(gEgo get: 8) ; Spike
				(if (== client gCurRoom)
					(proc240_30)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance useAntAcids of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 223 146 self)
			)
			(2
				(if (IsFlag 43)
					(gEgo setHeading: 45 self)
				else
					(self setScript: (ScriptID 240 9) self) ; openTank
				)
			)
			(3
				(SetScore 171 20)
				(gEgo view: 243 loop: 0 cel: 0 looper: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg)
				((ScriptID 240 20) ; bubbles
					init:
					view: 244
					loop: 6
					cel: 0
					x: 251
					y: 100
					setPri: 12
					setCycle: End self
				)
				(gSq5Music2 number: 137 loop: 1 play:)
				((ScriptID 240 8) setCycle: 0) ; spike
			)
			(5
				(gSq5Music2 number: 137 loop: 1 play: self)
			)
			(6
				(gSq5Music2 number: 256 loop: 1 play:)
				((ScriptID 240 20) ; bubbles
					x: 244
					y: 101
					loop: 8
					cel: 0
					x: 254
					y: 101
					setCycle: End self
				)
				(bubbles2 init: setCycle: End self)
			)
			(7)
			(8
				((ScriptID 240 20) loop: 10 cel: 0 setCycle: Fwd) ; bubbles
				(bubbles2 loop: 9 setCycle: Fwd)
				(SetFlag 56)
				(gSq5Music2 stop:)
				(self setScript: (ScriptID 240 9) self) ; openTank
			)
			(9
				(gMessager say: 22 29 0 1 self) ; "Poor little fella must have eaten something that didn't agree with him. Those antacids should reduce the acidity of his metabolism."
			)
			(10
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(gMessager say: 22 29 0 2 self) ; "You're a genius, sir. I would have given him a chili dog."
				else
					(= cycles 1)
				)
			)
			(11
				(gGame handsOn:)
				((ScriptID 240 8) setCycle: Fwd) ; spike
				(NormalEgo 0 6)
				(gEgo put: 5) ; Antacid
				(bubbles2 dispose:)
				((ScriptID 240 20) ; bubbles
					view: 244
					loop: 3
					cel: 0
					x: 254
					y: 101
					dispose:
				)
				(self dispose:)
			)
		)
	)
)

(instance bubbles2 of Prop
	(properties
		x 252
		y 102
		view 244
		loop 7
		priority 10
		signal 16400
	)
)

(instance putSpikeInTank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gGame handsOff:)
				)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(if (IsFlag 43)
					(= cycles 1)
				else
					(self setScript: (ScriptID 240 9) self) ; openTank
				)
			)
			(2
				(gEgo setMotion: PolyPath 214 141 self)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(gEgo view: 192 loop: 2 cel: 15 setCycle: Beg self)
			)
			(5
				((ScriptID 240 27) noun: 25) ; tank
				(gEgo
					view: 243
					loop: 1
					cel: 0
					setScale: Scaler 116 71 149 123
					posn: 220 141
					setCycle: End self
				)
			)
			(6
				(SetScore 169 20)
				(NormalEgo 0 4)
				(gEgo setMotion: PolyPath 210 141 self)
				(= gSpikeState 2)
				((ScriptID 240 8) init: detailLevel: 3) ; spike
				(gEgo put: 8) ; Spike
			)
			(7
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance spikeEscapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gSpikeState 5)
				((ScriptID 240 8) detailLevel: 0 setCycle: Beg self) ; spike
			)
			(1
				(if (not (IsFlag 43))
					(= register 0)
					(extra2
						view: 244
						loop: 1
						cel: 0
						init:
						posn: 254 101
						setPri: 15
						setCycle: End self
					)
				else
					(= register 1)
					(= cycles (++ state))
				)
			)
			(2
				(extra2 setCycle: Beg self)
				((ScriptID 240 24) init: 1 setCycle: End self) ; tankTop
				(SetFlag 43)
				((ScriptID 240 20) init: cel: 0 setCycle: End) ; bubbles
			)
			(3
				(Face gEgo (ScriptID 240 8)) ; spike
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(= local0 ((ScriptID 240 21) view:)) ; cliffy
					(proc240_28 7)
					(Face (ScriptID 240 21) (ScriptID 240 8)) ; cliffy, spike
				)
				((ScriptID 240 24) stopUpd:) ; tankTop
				(extra2 dispose:)
				((ScriptID 240 8) ; spike
					view: 244
					loop: 5
					cel: 0
					posn: 251 100
					setCycle: End self
				)
			)
			(4
				((ScriptID 240 20) dispose:) ; bubbles
				(gSq5Music1 number: 23 loop: -1 play:)
				(proc240_29 1)
				((ScriptID 240 8) posn: 181 144 setMotion: MoveTo 181 189 self) ; spike
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(Face (ScriptID 240 21) (ScriptID 240 8)) ; cliffy, spike
				)
			)
			(5
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(Face (ScriptID 240 21) (ScriptID 240 8)) ; cliffy, spike
				)
				(Face gEgo (ScriptID 240 8) self) ; spike
			)
			(6
				(if register
					(gMessager say: 22 0 42 0 self) ; "Darn! I forgot to close the lid."
				else
					(gMessager say: 22 0 43 0 self) ; "HEEL BOY! HEEEEEEL!"
				)
			)
			(7
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(if register
						(gMessager say: 5 0 42 0 self) ; "Hey Cap'n, those tanks generally work a whole lot better if you keep the lid shut."
					else
						(gMessager say: 5 0 43 0 self) ; "Please do something about that critter of yours, Captain. I can't keep fixing the holes in the hull forever."
					)
				)
				(= cycles 1)
			)
			(8
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					((ScriptID 240 21) setHeading: 0 self) ; cliffy
				else
					(= cycles 1)
				)
			)
			(9
				(if (gCast contains: (ScriptID 240 21)) ; cliffy
					(if (== local0 248)
						((ScriptID 240 21) ; cliffy
							view: 248
							loop: 0
							cel: 0
							x: 226
							y: 170
							setPri: 13
							setScale: Scaler 116 71 149 123
							setCycle: Fwd
							setScript: (ScriptID 240 23) ; bang
						)
					else
						((ScriptID 240 21) ; cliffy
							view: 191
							loop: 0
							x: 239
							y: 164
							setPri: 13
							setScale: Scaler 116 71 149 123
							setScript: (ScriptID 240 23) ; bang
							setCycle: Fwd
						)
					)
				)
				(proc240_30)
				((ScriptID 240 8) dispose:) ; spike
				(self dispose:)
			)
		)
	)
)

(instance spikeEscapes2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gGame handsOff:)
				)
				(= gSpikeState 5)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 246 loop: 0 cel: 0 put: 8 setCycle: End self) ; Spike
			)
			(2
				(NormalEgo 0 2)
				(gSq5Music1 number: 23 loop: -1 play:)
				(proc240_29 1)
				((ScriptID 240 8) ; spike
					posn: (- (gEgo x:) 21) (+ (gEgo y:) 1)
					init: 1
					setMotion: MoveTo 79 187 self
				)
			)
			(3
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(proc240_30)
				((ScriptID 240 8) dispose:) ; spike
				(self dispose:)
			)
		)
	)
)

(instance upFromThrakus2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc240_30)
				(proc240_1 1)
				(gEgo
					setScale: 0
					init:
					get: 21 ; Oxygen_Mask
					view: 22
					loop: 0
					posn: 106 135
					cel: 0
					setCycle: End self
				)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(1
				(gSq5Music2 stop:)
				(gEgo loop: 1 cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(2
				(NormalEgo 0 2)
				(ClearFlag 109)
				(gEgo setScale: 0 posn: 109 135)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putOnMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (proc240_1))
						(gMessager say: 19 39 27 0) ; "The mask has a limited filtration capacity. Get on the pad before you put it on."
						(gGame handsOn:)
						(self dispose:)
					)
					(
						(or
							(and
								(gCast contains: (ScriptID 240 2)) ; bea
								(!= gBeaState 9)
							)
							(proc240_7)
							(and
								(IsFlag 63)
								(IsFlag 45)
								(not (OneOf gBeaState 1 8))
								(== gEurekaLocation 6) ; thrakus
							)
							(and
								(!= gPrevRoomNum 225)
								(== gEurekaLocation 8) ; genetix environdome
								(!= gBeaState 8)
							)
						)
						(gMessager say: 26 24 13 0) ; "Not a good plan, ace. If you don't get Bea on ice quickly, she'll croak."
					)
					(else
						(gGame handsOff:)
						(SetScore 183 20)
						(SetFlag 63)
						(SetFlag 109)
						(gEgo view: 22 loop: 1 cel: 0 setCycle: End self)
					)
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo
					loop: 0
					put: 21 ; Oxygen_Mask
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(3
				(gEgo dispose:)
				(= seconds 2)
			)
			(4
				(gSq5Music2 stop:)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance getSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (eureka puke:) 7)
					(SetScore 203 10)
				)
				((ScriptID 240 27) noun: 24) ; tank
				((ScriptID 240 8) setCycle: Beg self) ; spike
			)
			(1
				((ScriptID 240 8) view: 244 loop: 5 cel: 0 posn: 251 100) ; spike
				(gEgo
					view: 0
					looper: 0
					setCycle: Rev
					setLoop: 0
					setMotion: MoveTo 191 144 self
				)
			)
			(2
				(gEgo setCycle: 0)
				((ScriptID 240 20) dispose:) ; bubbles
				((ScriptID 240 8) setCycle: CT 5 1 self) ; spike
			)
			(3
				(spikeNailsEgo start: 2)
				(= next spikeNailsEgo)
				(self dispose:)
			)
		)
	)
)

(instance spikeSayNo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 240 8) view: 245 loop: 5 cel: 0 setCycle: End self) ; spike
			)
			(1
				((ScriptID 240 8) ; spike
					view: 245
					loop: 6
					cel: 0
					setCycle: ForwardCounter 5 self
				)
			)
			(2
				((ScriptID 240 8) view: 245 loop: 0 cel: 0) ; spike
				(self dispose:)
			)
		)
	)
)

(instance talkAboutBea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 103)
				(|= global169 $0002)
				(= gCliffyState 5)
				(proc240_1 1)
				(gEgo
					setScale: Scaler 116 71 149 123
					init:
					view: 6
					loop: 0
					posn: 106 135
					cel: 0
					setCycle: End self
				)
				(gSq5Music2 number: 260 loop: 1 play:)
				((ScriptID 240 21) setCycle: End self) ; cliffy
			)
			(1)
			(2
				(gSq5Music2 stop:)
				(proc240_28 1)
				((ScriptID 240 21) setMotion: MoveTo 214 145 self) ; cliffy
				(NormalEgo 0 2)
				(gEgo setScale: 0 posn: 109 135 setSpeed: 6)
				(self setScript: (ScriptID 240 3) self 0) ; getOffPad
			)
			(3)
			(4
				(gEgo setMotion: PolyPath 136 129 self)
			)
			(5
				(gEgo setHeading: 135 self)
				((ScriptID 240 21) setHeading: 0 self) ; cliffy
			)
			(6)
			(7
				(gMessager say: 15 0 0 1 2 self) ; "There's got to be some way to help Beatrice, Cliffy."
			)
			(8
				((ScriptID 240 8) setCycle: Beg) ; spike
				((ScriptID 240 21) setHeading: 90 self) ; cliffy
			)
			(9
				(gSq5Music1 number: 23 loop: -1 play:)
				(gMessager say: 15 0 0 3 self) ; "What's your beastie so excited about?"
			)
			(10
				((ScriptID 240 21) setHeading: 0 self) ; cliffy
			)
			(11
				((ScriptID 240 21) setMotion: MoveTo 238 162 self) ; cliffy
			)
			(12
				((ScriptID 240 21) setHeading: 0) ; cliffy
				((ScriptID 240 24) init: 1 setCycle: End) ; tankTop
				((ScriptID 240 20) dispose:) ; bubbles
				((ScriptID 240 8) ; spike
					view: 244
					loop: 5
					cel: 0
					posn: 251 100
					setCycle: End self
				)
				(gSq5Music2 number: 246 loop: 1 play:)
			)
			(13
				((ScriptID 240 21) ; cliffy
					view: 26
					loop: 0
					cel: 0
					setScript: (ScriptID 240 23) ; bang
				)
				((ScriptID 240 24) stopUpd:) ; tankTop
				(gMessager say: 15 0 0 4 self) ; "I think he's trying to tell us something! What is it boy?!"
			)
			(14
				(proc240_29 1)
				((ScriptID 240 8) posn: 181 144 setMotion: MoveTo 202 137 self) ; spike
			)
			(15
				(ClearFlag 43)
				((ScriptID 240 24) setCycle: Beg) ; tankTop
				((ScriptID 240 27) noun: 24) ; tank
				((ScriptID 240 8) ; spike
					view: 245
					loop: 0
					cel: 0
					posn: 197 139
					setPri: 14
					setCycle: End
					setMotion: JumpTo 185 115 self
				)
				(gSq5Music2 number: 246 loop: 1 play:)
			)
			(16
				((ScriptID 240 8) setCycle: ForwardCounter 5 self) ; spike
				(gSq5Music2 number: 246 loop: -1 play:)
			)
			(17
				(gSq5Music2 stop:)
				(gMessager say: 15 0 0 5 6 self) ; "He's jumping on the cryo chamber!"
			)
			(18
				((ScriptID 240 8) setCycle: End setMotion: JumpTo 159 140 self) ; spike
				(gSq5Music2 number: 246 loop: 1 play:)
			)
			(19
				(Face gEgo (ScriptID 240 8)) ; spike
				((ScriptID 240 8) ; spike
					setPri: -1
					setCycle: End
					setMotion: JumpTo 125 142 self
				)
				(gSq5Music2 number: 246 loop: 1 play:)
			)
			(20
				(Face gEgo (ScriptID 240 8)) ; spike
				((ScriptID 240 8) setCycle: ForwardCounter 5 self) ; spike
				(gSq5Music2 number: 246 loop: -1 play:)
			)
			(21
				(gSq5Music2 stop:)
				((ScriptID 240 8) ; spike
					loop: 2
					cel: 0
					setCycle: ForwardCounter 3 self
				)
			)
			(22
				((ScriptID 240 8) ; spike
					loop: 4
					cel: 0
					setCycle: ForwardCounter 3 self
				)
			)
			(23
				(gMessager say: 15 0 0 7 8 self) ; "I don't think so, sir."
			)
			(24
				(proc240_29 1)
				((ScriptID 240 8) posn: 129 137 setMotion: MoveTo 163 137 self) ; spike
			)
			(25
				(Face gEgo (ScriptID 240 8)) ; spike
				((ScriptID 240 8) setMotion: MoveTo 202 137 self) ; spike
			)
			(26
				(Face gEgo (ScriptID 240 21)) ; cliffy
				((ScriptID 240 8) ; spike
					view: 245
					loop: 0
					cel: 0
					posn: 197 139
					setPri: 10
					setCycle: End
					setMotion: JumpTo 185 115 self
				)
				(gSq5Music2 number: 246 loop: 1 play:)
				(= gSpikeState 7)
			)
			(27
				(= next askAboutBea)
				(self dispose:)
			)
		)
	)
)

(instance askAboutBea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 23 loop: -1 play:)
				((ScriptID 240 21) ; cliffy
					view: 26
					loop: 0
					setScript: (ScriptID 240 23) ; bang
				)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 136 129 self)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gMessager say: 15 0 0 9 self) ; "What do you think the critter is trying to tell us, Cap'n?"
			)
			(4
				(gGame handsOn:)
				(gGame setCursor: 999 1)
				((ScriptID 240 15) normal: 0 curNoun: 15 curVerb: 0 curCase: 20) ; tkrRoger
				(gMessager say: 15 0 20 1 self) ; "What're you trying to tell us, boy?"
			)
			(5
				(gGame handsOff:)
				((ScriptID 240 15) normal: 1) ; tkrRoger
				(cond
					((not ((ScriptID 240 15) whichSelect:)) ; tkrRoger
						(-= state 2)
						(= cycles 1)
					)
					((== ((ScriptID 240 15) whichSelect:) 4) ; tkrRoger
						((ScriptID 240 8) setCycle: ForwardCounter 5 self) ; spike
						(gSq5Music2 number: 246 loop: -1 play:)
					)
					(else
						(self setScript: spikeSayNo self)
					)
				)
			)
			(6
				(gSq5Music2 stop:)
				((ScriptID 240 15) normal: 1) ; tkrRoger
				(gMessager
					say:
						15
						0
						(switch ((ScriptID 240 15) whichSelect:) ; tkrRoger
							(1 21)
							(2 22)
							(3 23)
							(4 24)
						)
						0
						self
				)
			)
			(7
				(if (< ((ScriptID 240 15) whichSelect:) 4) ; tkrRoger
					(gGame handsOn:)
					(= next 0)
					(gEgo setSpeed: global123)
					(self dispose:)
				else
					((ScriptID 240 8) ; spike
						loop: 0
						cel: 0
						setCycle: End
						setMotion: JumpTo 155 109 self
					)
					(gSq5Music2 number: 246 loop: 1 play:)
				)
			)
			(8
				(spikeNailsEgo start: 2)
				(self setScript: spikeNailsEgo self)
			)
			(9
				(self setScript: putSpikeInTank self)
			)
			(10
				(= gCliffyState 12)
				(gEgo setSpeed: global123)
				(gSq5Music1 fade: 0 10 5 1)
				(self setScript: (ScriptID 240 9) self) ; openTank
			)
			(11
				(proc240_30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upFromThrakus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc240_1 1)
				(gCast eachElementDo: #stopUpd)
				(= seconds 3)
			)
			(1
				(gEgo
					init:
					get: 21 ; Oxygen_Mask
					setScale: 0
					cycleSpeed: 10
					view: 23
					loop: 0
					cel: 0
					posn: 124 135
					setCycle: End self
				)
				(ClearFlag 109)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(2
				((ScriptID 240 21) view: 26 loop: 0 cel: 0 stopUpd:) ; cliffy
				(gSq5Music2 stop:)
				(gEgo loop: 1 cel: 0 posn: 115 140 setCycle: End self)
			)
			(3
				(gEgo loop: 2 cel: 0 posn: 112 136 setCycle: End self)
			)
			(4
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gCast eachElementDo: #hide)
				(gSq5Music1 number: 33 loop: -1 play:)
				(gEgo ignoreActors: 1)
				(DrawPic 46 10 1)
				(= seconds 3)
			)
			(6
				(proc240_25 1)
				(proc240_26 1)
				(gMessager say: 1 2 1 1 10 self) ; "Ugh. Sorry, I tried to kick your butt back there on the planet, Captain Wilco. I thought you were one of those pukoid mutants."
			)
			(7
				(beaArm init:)
				(= seconds 5)
			)
			(8
				(gMessager say: 1 2 1 11 13 self) ; "They aren't going to get far without this. It's the Goliath's warp distributor cap."
			)
			(9
				(proc240_25 0)
				(proc240_26 0)
				(gSq5Music1 fade: 0 10 5 1 self)
				(gCast eachElementDo: #show)
				(gEgo ignoreActors: 0)
				(beaArm dispose:)
				(DrawPic 43 10 1)
				(gAddToPics eachElementDo: #init)
			)
			(10
				(proc240_30)
				(gMessager say: 1 2 1 14 17 self) ; "What the... Who's that Cap'n.?"
			)
			(11
				(gEgo
					view: 256
					loop: 0
					get: 3 ; Distributor_Cap
					cel: 4
					posn: 121 138
					setCycle: Beg self
				)
			)
			(12
				((ScriptID 240 2) init:) ; bea
				(NormalEgo 0 2)
				(gEgo posn: 123 137 setScale: Scaler 116 71 149 123)
				(= cycles 2)
			)
			(13
				((ScriptID 240 2) stopUpd:) ; bea
				(proc240_6 180 141)
				(= next (ScriptID 240 3)) ; getOffPad
				((ScriptID 240 3) register: 2) ; getOffPad
				(gCast eachElementDo: #startUpd)
				(gCast eachElementDo: #checkDetail)
				(self dispose:)
			)
		)
	)
)

(instance upFromGenetix of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc240_1 1)
				(= seconds 3)
			)
			(1
				(proc240_6 180 141)
				(= next (ScriptID 240 3)) ; getOffPad
				((ScriptID 240 3) register: 2) ; getOffPad
				(self dispose:)
			)
		)
	)
)

(instance putBeaOnPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(if (proc240_1)
					(= cycles 1)
				else
					(if (and (== (gEgo view:) 257) (== (gEgo loop:) 1))
						(gEgo posn: 158 136)
					)
					(gEgo
						view: 258
						looper: 0
						setLoop: 1
						cel: 0
						setCycle: Walk
						setMotion: MoveTo 119 138 self
					)
				)
			)
			(1
				1
				(gEgo
					view: 256
					looper: 0
					loop: 0
					cel: 7
					x: 121
					y: 138
					setCycle: CT 4 -1 self
				)
			)
			(2
				2
				((ScriptID 240 2) init:) ; bea
				(proc240_7 0)
				(gEgo setCycle: Beg self)
			)
			(3
				3
				(proc240_1 1)
				(NormalEgo 0 2)
				(gEgo posn: 123 137 setScale: 0)
				(if (== gCliffyState 12)
					(= next cureBea)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance cureBea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gBeaState 8)
				((ScriptID 240 2) stopUpd:) ; bea
				((ScriptID 240 21) startUpd:) ; cliffy
				(self setScript: (ScriptID 240 3) self 2) ; getOffPad
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gMessager say: 15 0 25 1 2 self) ; "Make it so, Cliffy."
			)
			(3
				(SetScore 188 50)
				(proc240_28 3)
				((ScriptID 240 21) setHeading: 90 self) ; cliffy
			)
			(4
				((ScriptID 240 21) ; cliffy
					view: 191
					loop: 4
					x: 239
					y: 164
					setPri: 13
					setScale: Scaler 116 71 149 123
					setCycle: End self
				)
			)
			(5
				((ScriptID 240 21) setCycle: End self) ; cliffy
				(gSq5Music2 number: 233 loop: 1 play:)
			)
			(6
				((ScriptID 240 21) setCycle: End self) ; cliffy
				(gSq5Music2 number: 233 loop: 1 play:)
			)
			(7
				(gSq5Music2 number: 233 loop: 1 play:)
				(proc240_28 0)
				((ScriptID 240 21) posn: 238 162 setHeading: 325 self) ; cliffy
			)
			(8
				((ScriptID 240 21) stopUpd:) ; cliffy
				((ScriptID 240 2) ; bea
					view: 256
					loop: 2
					cel: ((ScriptID 240 2) lastCel:) ; bea
					x: 119
					y: 183
					setCycle: Beg self
				)
				(gSq5Music2 number: 260 loop: 1 play: self)
			)
			(9
				((ScriptID 240 2) hide:) ; bea
			)
			(10
				((ScriptID 240 2) show: setCycle: End self) ; bea
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(11
				(gSq5Music2 stop:)
				((ScriptID 240 2) loop: 1 cel: 0 posn: 97 186 stopUpd:) ; bea
				(self setScript: (ScriptID 240 4) self 2) ; getOnPad
			)
			(12
				(gEgo setMotion: MoveTo 123 137 self)
			)
			(13
				((ScriptID 240 2) dispose:) ; bea
				(gEgo
					view: 256
					loop: 0
					cel: 0
					x: 121
					y: 138
					setCycle: CT 3 1 self
				)
			)
			(14
				(gSq5Music1 number: 34 loop: -1 play:)
				(gCast eachElementDo: #hide)
				(gEgo ignoreActors: 1)
				(DrawPic 46 10 1)
				(= seconds 3)
			)
			(15
				(proc240_26 1)
				(proc240_25 1)
				(gMessager say: 15 0 25 3 6 self) ; "Oh Bea... I thought you were puked for sure."
			)
			(16
				(gSq5Music2 number: 502 loop: 1 play:)
				(gMessager say: 15 0 44 0 self) ; "|f5|BUUURRRRP!"
			)
			(17
				(gMessager say: 15 0 25 7 self) ; "Ooops. Excuse me Roger."
			)
			(18
				(proc240_26 0)
				(proc240_25 0)
				(gCast eachElementDo: #show)
				(= gBeaState 8)
				(= gCliffyState 2)
				(gEgo ignoreActors: 0)
				(DrawPic 43 10 1)
				(gAddToPics eachElementDo: #init)
				(gSq5Music1 fade: 0 10 5 1 self)
			)
			(19
				(proc240_30)
				(pickBeaUp start: 3)
				(= next pickBeaUp)
				(self dispose:)
			)
		)
	)
)

(instance pickBeaUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (proc240_1))
					(self setScript: (ScriptID 240 4) self 2) ; getOnPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 123 137 self)
			)
			(2
				(gEgo
					view: 256
					loop: 0
					cel: 0
					x: 121
					y: 138
					setCycle: CT 3 1 self
				)
			)
			(3
				((ScriptID 240 2) dispose:) ; bea
				(gEgo setCycle: End self)
			)
			(4
				(proc240_1 0)
				(gEgo
					looper: 0
					view: 258
					setLoop: 0
					cel: 3
					setCycle: Walk
					setMotion: MoveTo 174 135 self
				)
			)
			(5
				(gEgo setCel: 3)
				(proc240_7 1)
				(if (== start 3)
					(= start 0)
					(= next putBeaInBox)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance putBeaInBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gEgo loop:) 1)
					(gEgo setCycle: Beg self)
				else
					(gEgo
						view: 257
						setLoop: 0
						cel: 0
						posn: 183 125
						setScale: 0
						setPri: 15
						setCycle: End self
					)
				)
			)
			(1
				(SetScore 185 20)
				(NormalEgo 0 0)
				(gEgo setScale: Scaler 116 71 149 123 x: 160 y: 136)
				((ScriptID 240 5) view: 280 loop: 1 cel: 0 setCycle: End self) ; chamber
			)
			(2
				((ScriptID 240 21) ; cliffy
					view: 191
					loop: 0
					x: 239
					y: 164
					setPri: 13
					setScale: Scaler 116 71 149 123
					setScript: (ScriptID 240 23) ; bang
				)
				(SetFlag 45)
				(proc240_7 0)
				((ScriptID 240 5) init:) ; chamber
				(gCast eachElementDo: #checkDetail)
				(UnLoad 128 280)
				(UnLoad 128 257)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goliathConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 225 146 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(if (& global169 $0008)
					((ScriptID 240 11) ; tkrCliffy
						normal: 0
						curNoun: 1
						curVerb: 2
						curCase: 4
					)
					(gGame handsOn:)
					(gGame setCursor: 999 1)
					(gMessager say: 1 2 4 1 self 246) ; "What do you want, Captain?"
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(3
				(gGame handsOff:)
				((ScriptID 240 11) normal: 1) ; tkrCliffy
				(switch ((ScriptID 240 11) whichSelect:) ; tkrCliffy
					(1
						(gMessager say: 1 2 1 0 self 246) ; "Ok, sir."
					)
					(2
						(gMessager say: 1 2 2 0 self 246) ; "I really can't tell, sir. The light reflecting off your bald spot is blinding me."
					)
					(3
						(gMessager say: 1 2 3 0 self 246) ; "Whatever you say, Cap'n."
					)
					(else
						(-= state 2)
						(= cycles 1)
					)
				)
			)
			(4
				(if (!= ((ScriptID 240 11) whichSelect:) 1) ; tkrCliffy
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(5
				(gCurRoom newRoom: 246)
			)
		)
	)
)

(instance openChamber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 192 135 self)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(gCast eachElementDo: #stopUpd)
				(NormalEgo 0 3)
				(if (and (not (IsFlag 45)) (== gEurekaLocation 6) (!= gPrevRoomNum 225)) ; thrakus
					(SetScore 184 20)
				)
				((ScriptID 240 5) ; chamber
					view: 280
					loop: (if (IsFlag 45) 1 else 0)
					cel: (if (IsFlag 45) 5 else 0)
					setCycle: (if (IsFlag 45) Beg else End) self
				)
			)
			(4
				(if (not ((ScriptID 240 5) loop:)) ; chamber
					((ScriptID 240 5) view: 259 loop: 2 setCel: 2) ; chamber
				)
				(gEgo setMotion: MoveTo 167 134 self)
			)
			(5
				(gCast eachElementDo: #checkDetail)
				((ScriptID 240 5) stopUpd:) ; chamber
				(UnLoad 128 280)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBeaFromChamber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 167 134 self)
			)
			(2
				((ScriptID 240 5) view: 259 loop: 2 cel: 2) ; chamber
				(= cycles 2)
			)
			(3
				(gCast eachElementDo: #stopUpd)
				(ClearFlag 45)
				(gEgo
					view: 257
					looper: 0
					setLoop: 1
					cel: 0
					x: 178
					y: 132
					setScale: 0
					setCycle: End self
				)
			)
			(4
				((ScriptID 240 5) stopUpd:) ; chamber
				(proc240_7 1)
				(if (== gBeaState 1)
					(= next breakBea)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance breakBea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 257
					loop: 2
					cel: 0
					x: 161
					y: 109
					setPri: 14
					setCycle: End self
				)
				(gSq5Music2 number: 267 loop: 1 play: self)
			)
			(1)
			(2
				(gMessager say: 2 0 2 0 self) ; "She's really going to pieces for you, Rog."
			)
			(3
				(EgoDead 47) ; "Beatrice really went to pieces on you: She now lies scattered on the floor in handy bite-sized chunks."
			)
		)
	)
)

(instance beamToGenetix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gEurekaLocation 14) ; goliath
					(gGame handsOff:)
				else
					(SetFlag 75)
				)
				(self setScript: blowFuse self)
				(gEgo setPri: 15 setCycle: Osc)
				(if (== gBeaState 9)
					((ScriptID 240 2) setPri: 15 setCycle: Osc) ; bea
				)
			)
			(1
				(if (== gEurekaLocation 14) ; goliath
					(SetFlag 72)
					(ClearFlag 73)
					(gEgo setCycle: End self)
					(if (== gBeaState 9)
						((ScriptID 240 2) setCycle: End) ; bea
					)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(2
				(if (== gEurekaLocation 14) ; goliath
					(gMessager say: 26 24 46 0 self) ; "Dang! This piece must have blown a circuit or something!"
				else
					(gCurRoom newRoom: 760)
				)
			)
			(3
				(gGame handsOn:)
				(if (== gBeaState 9)
					((ScriptID 240 2) setPri: -1) ; bea
				)
				(extra1 dispose:)
				(extra2 dispose:)
				(extra3 dispose:)
				(NormalEgo 0 2)
				(self dispose:)
			)
		)
	)
)

(instance bounceEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo show: setCycle: Osc)
				(gSq5Music2 number: 260 loop: -1 play:)
				(= seconds 4)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gSq5Music2 stop:)
				(cond
					((== gCliffyState 8)
						(if (not (& global169 $0010))
							(|= global169 $0010)
							(gMessager say: 4 0 0 0 self 246) ; "ARGH!"
						else
							(gMessager say: 4 0 5 0 self 246) ; "That won't work, Captain, the Goliath's shields are still up."
						)
					)
					((gCast contains: (ScriptID 240 21)) ; cliffy
						(gMessager say: 26 24 37 0 self) ; "Ooops! I plumb forgot cap'n. You can't beam over while their shields are up. Silly me."
					)
					(else
						(gMessager say: 26 24 54 0 self) ; "Their anti-teleportation shields must be up. Looks like you'll have to find another way..."
					)
				)
			)
			(3
				(gGame handsOn:)
				(NormalEgo 0 2)
				(proc240_1 1)
				(gEgo heading: 180)
				(self dispose:)
			)
		)
	)
)

(instance blowFuse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 145 loop: -1 play:)
				(extra3
					view: 253
					loop: 3
					cel: 0
					x: 135
					y: 174
					init:
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(1
				(extra1
					view: 253
					loop: 0
					cel: 0
					x: 126
					y: 164
					init:
					setCycle: Fwd
				)
				(extra2
					view: 253
					loop: 1
					cel: 0
					x: 119
					y: 146
					init:
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(2
				(extra1
					view: 253
					loop: 2
					cel: 0
					x: 98
					y: 134
					setPri: 15
					setCycle: Fwd
				)
				(extra2
					view: 253
					loop: 2
					cel: 0
					x: 119
					y: 137
					setPri: 15
					setCycle: Fwd
				)
				(extra3
					view: 253
					loop: 2
					cel: 0
					x: 135
					y: 134
					setPri: 15
					setCycle: Fwd
				)
				(gSq5Music2 client: 0 stop:)
				(self dispose:)
			)
		)
	)
)

(instance specialBeam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 225)
					(+= state 1)
					(= cycles 1)
				else
					(proc240_1 1)
					(gEgo
						setScale: Scaler 116 71 149 123
						init:
						view: 6
						loop: 0
						posn: 106 135
						cel: 0
						setCycle: End self
					)
					(gSq5Music2 number: 260 loop: 1 play:)
				)
			)
			(1
				(gSq5Music2 stop:)
				(NormalEgo 0 2)
				(gEgo setScale: 0 posn: 109 135)
				(self setScript: (ScriptID 240 3) self 1) ; getOffPad
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gMessager say: 28 0 40 1 self) ; "Hey Cliffy, I have something for you."
			)
			(4
				(gEgo view: 260 loop: 0 cel: 0 put: 20 setCycle: CT 3 1 self) ; WD40_Head
			)
			(5
				(extra1
					init:
					view: 260
					loop: 1
					cel: 3
					setCycle: Fwd
					setPri: 12
					posn: (+ (gEgo x:) 16) (- (gEgo y:) 39)
					setMotion: JumpTo 259 109 self
				)
				(gEgo setCycle: End self)
			)
			(6)
			(7
				(gSq5Music2 number: 233 loop: 1 play:)
				(NormalEgo 0 0)
				(extra1 setMotion: JumpTo 227 131 self)
			)
			(8
				(gSq5Music2 number: 233 loop: 1 play:)
				(gMessager say: 28 0 40 2 3 self) ; "I just wanted you to |f8|get ahead|f| BWAHAHHAHAHAHA!"
				(extra1 dispose:)
			)
			(9
				(gEgo setMotion: PolyPath 121 127 self)
				(proc240_28 3)
				((ScriptID 240 21) setMotion: MoveTo 168 160 self) ; cliffy
			)
			(10)
			(11
				(gEgo setHeading: 135)
				((ScriptID 240 21) setMotion: MoveTo 147 130 self) ; cliffy
			)
			(12
				(gEgo
					view: 248
					loop: 6
					cel: 0
					x: 129
					y: 130
					setCycle: End self
				)
				((ScriptID 240 21) hide:) ; cliffy
			)
			(13
				(gMessager say: 28 0 40 4 5 self) ; "I was puttin' this WD40 unit back together and I had a couple pieces left over. Thought you might like a souvenir. Here ya go!"
			)
			(14
				((ScriptID 240 21) show: setMotion: MoveTo 168 160 self) ; cliffy
				(NormalEgo 0 2)
				(gEgo get: 6) ; Ship_Opener
			)
			(15
				((ScriptID 240 21) setMotion: MoveTo 226 170 self) ; cliffy
			)
			(16
				((ScriptID 240 21) ; cliffy
					view: 248
					loop: 0
					cel: 0
					x: 226
					y: 170
					setPri: 13
					setScript: (ScriptID 240 23) ; bang
				)
				(= cycles 5)
			)
			(17
				((ScriptID 240 21) detailLevel: 2) ; cliffy
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upFromKUEgoAlone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 260 loop: 1 play:)
				(gEgo
					init:
					view: 21
					setLoop: 9
					cel: 0
					x: 91
					y: 77
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
					cycleSpeed: 6
					moveSpeed: 2
					setStep: 2 6
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 2
					cel: 0
					x: 107
					y: 108
					setMotion: MoveTo 107 135 self
				)
			)
			(2
				(gSq5Music2 number: 233 loop: 1 play:)
				(gEgo setCycle: End)
				(proc240_28 1)
				((ScriptID 240 21) setMotion: MoveTo 179 164 self) ; cliffy
			)
			(3
				((ScriptID 240 21) setMotion: MoveTo 159 139 self) ; cliffy
			)
			(4
				((ScriptID 240 21) setMotion: MoveTo 137 136 self) ; cliffy
			)
			(5
				((ScriptID 240 21) setHeading: 225 self) ; cliffy
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance upFromKUEgoAndCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 260 loop: 1 play:)
				(gEgo
					init:
					view: 21
					setLoop: 9
					cel: 0
					x: 91
					y: 77
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
					cycleSpeed: 6
					moveSpeed: 2
					setPri: 14
					setStep: 2 6
					setCycle: End self
				)
				((ScriptID 240 21) setCycle: End self) ; cliffy
			)
			(1)
			(2
				(gEgo
					setLoop: 2
					cel: 0
					x: 107
					y: 108
					setMotion: MoveTo 107 135 self
				)
				((ScriptID 240 21) ; cliffy
					setLoop: 10
					cel: 0
					x: 105
					y: 108
					moveSpeed: 2
					setStep: 2 6
					setPri: 14
					setMotion: MoveTo 105 135 self
				)
			)
			(3)
			(4
				(gSq5Music2 number: 233 loop: 1 play:)
				(gEgo setCycle: End self)
				((ScriptID 240 21) setCycle: End self) ; cliffy
			)
			(5)
			(6
				((ScriptID 240 21) ; cliffy
					setLoop: 4
					cel: 0
					x: 136
					y: 136
					setCycle: End self
				)
			)
			(7
				((ScriptID 240 21) ; cliffy
					setLoop: 6
					cel: 0
					x: 136
					y: 136
					setCycle: End self
				)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance upFromKU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 89)
				(gEgo put: 12) ; Cloaking_Device
				(if (& global169 $0020)
					(self setScript: upFromKUEgoAlone self)
				else
					(self setScript: upFromKUEgoAndCliffy self)
				)
			)
			(1
				(gMessager say: 26 0 34 0 self) ; "Oh wow chief. Did that hurt? It looked real painful. You OK?"
			)
			(2
				((ScriptID 240 21) hide:) ; cliffy
				(= register 3)
				(gEgo loop: 7 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: CT 2 -1 self)
			)
			(4
				(if (-- register)
					(-= state 2)
				)
				(gEgo setCycle: End self)
			)
			(5
				(gSq5Music2 number: 136 loop: 1 play:)
				(gEgo loop: 8 cel: 0 setCycle: End self)
			)
			(6
				(NormalEgo 0 3)
				(gEgo posn: 109 135 setScale: Scaler 116 71 149 123)
				(proc240_28 2)
				((ScriptID 240 21) ; cliffy
					show:
					setStep: 5 2
					setScale: Scaler 116 71 149 123
				)
				(if (== gWD40State 1)
					(= gCliffyState 4)
					(gMessager say: 26 0 36 0 self) ; "I'll get around to installing this device as soon as I finish my repairs to the android."
				else
					(= gCliffyState 1)
					(gMessager say: 26 0 35 0 self) ; "I'll take this cloaking gizmo and get to work installing it. It'll take some time though, Cap'n."
				)
			)
			(7
				(self setScript: (ScriptID 240 3) self 1) ; getOffPad
			)
			(8
				(self
					setScript:
						(if (== gWD40State 1)
							cliffyGoesBackToWD40
						else
							cliffyLeavesThruDoor
						)
						self
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upFromKU2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc240_1 1)
				(gEgo
					setScale: Scaler 116 71 149 123
					init:
					view: 6
					loop: 0
					posn: 109 135
					cel: 0
					setCycle: End self
				)
				(gSq5Music2 number: 260 loop: 1 play:)
				((ScriptID 240 21) init: setCycle: End self) ; cliffy
				(if (== gEurekaLocation 3) ; ku
					(|= global169 $0020)
				)
			)
			(1)
			(2
				(NormalEgo 0 2)
				(gEgo posn: 109 135 setScale: Scaler 116 71 149 123)
				(proc240_28 2)
				((ScriptID 240 21) show: posn: 122 147) ; cliffy
				(if (== gWD40State 1)
					(= gCliffyState 4)
				else
					(= gCliffyState 2)
				)
				(= cycles 2)
			)
			(3
				(self setScript: (ScriptID 240 3) self 1) ; getOffPad
			)
			(4
				(self setScript: cliffyGoesBackToWD40 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cliffyLeavesThruDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 240 21) setMotion: MoveTo 163 143 self) ; cliffy
			)
			(1
				((ScriptID 240 21) setMotion: MoveTo 143 130 self) ; cliffy
			)
			(2
				((ScriptID 240 21) setMotion: MoveTo 40 130 self) ; cliffy
			)
			(3
				((ScriptID 240 21) setHeading: 0 self) ; cliffy
			)
			(4
				((ScriptID 240 22) setCycle: End self) ; northDoor
			)
			(5
				((ScriptID 240 21) setPri: 1 setMotion: MoveTo 45 120 self) ; cliffy
			)
			(6
				((ScriptID 240 22) setCycle: Beg self) ; northDoor
			)
			(7
				(= gCliffyState 1)
				((ScriptID 240 21) dispose:) ; cliffy
				((ScriptID 240 22) stopUpd:) ; northDoor
				(self dispose:)
			)
		)
	)
)

(instance cliffyGoesBackToWD40 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 240 21) setMotion: MoveTo 164 145 self) ; cliffy
			)
			(1
				((ScriptID 240 21) setMotion: MoveTo 172 169 self) ; cliffy
			)
			(2
				(if (== gWD40State 1)
					((ScriptID 240 21) setMotion: MoveTo 227 170 self) ; cliffy
				else
					((ScriptID 240 21) setMotion: MoveTo 239 164 self) ; cliffy
				)
			)
			(3
				(if (== gWD40State 1)
					((ScriptID 240 21) setHeading: 0 self) ; cliffy
				else
					((ScriptID 240 21) setHeading: 90 self) ; cliffy
				)
			)
			(4
				(if (== gWD40State 1)
					((ScriptID 240 21) ; cliffy
						view: 248
						loop: 0
						cel: 0
						x: 226
						y: 170
						setPri: 13
						setScale: Scaler 116 71 149 123
						setCycle: Fwd
						setScript: (ScriptID 240 23) ; bang
					)
					(= gCliffyState 2)
				else
					((ScriptID 240 21) ; cliffy
						view: 191
						loop: 0
						x: 239
						y: 164
						detailLevel: 2
						setPri: 13
						setScale: Scaler 116 71 149 123
						setScript: (ScriptID 240 23) ; bang
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance funnyBeam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 7
					loop: (= register (Random 0 2))
					cel: 0
					setSpeed: 6
					setScale: 0
					setCycle: End self
				)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(1
				(gSq5Music2 number: 102 loop: 1 play:)
				(if (== register 2)
					(extra2
						view: 7
						x: (- (gEgo x:) 7)
						y: (- (gEgo y:) 51)
						loop: 3
						setPri: (+ (gEgo priority:) 1)
						init:
						cycleSpeed: 12
						setCycle: ForwardCounter 3 self
					)
				else
					(+= state 4)
					(= cycles 1)
				)
			)
			(2
				(extra2 loop: 4 setCycle: End self)
			)
			(3
				(extra2 setCycle: Beg self)
			)
			(4
				(extra2 loop: 5 setCycle: End self)
			)
			(5
				(extra2 setCycle: Beg self)
			)
			(6
				(if (gCast contains: extra2)
					(extra2 loop: 3 setCycle: Fwd)
				)
				(= seconds 3)
			)
			(7
				(extra2 cycleSpeed: 6 dispose:)
				(gEgo setCycle: Beg self)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(8
				(gEgo view: 6 loop: 0 cel: 0 setSpeed: 6 setCycle: End self)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(9
				(gSq5Music2 stop:)
				(self dispose:)
			)
		)
	)
)

(instance extra1 of Actor
	(properties
		x 126
		y 164
		view 253
		priority 14
		signal 16400
	)
)

(instance extra2 of Prop
	(properties
		x 119
		y 146
		view 253
		loop 1
		signal 16384
	)
)

(instance extra3 of Prop
	(properties
		x 135
		y 174
		view 253
		loop 3
		priority 13
		signal 16400
	)
)

(instance beaArm of Actor
	(properties
		x 150
		y 128
		view 261
		loop 2
		priority 10
		signal 26640
	)

	(method (init)
		(super init: &rest)
		(self setMotion: MoveTo 116 108 upFromThrakus)
	)
)

