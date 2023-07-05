;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 623)
(include sci.sh)
(use Main)
(use n079)
(use TTDialer)
(use System)

(public
	neighborScr 0
	sexLineScr 1
)

(instance neighborScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound1 fade: 95 10 10 0)
				(= ticks 30)
			)
			(1
				(switch (++ global196)
					(5
						(Load rsSOUND 421)
						(Load rsSOUND 2)
						(Load rsSOUND 144)
						(self setScript: poundScr1 self)
					)
					(6
						(Load rsSOUND 908)
						(Load rsSOUND 657)
						(Load rsSOUND 652)
						(Load rsSOUND 910)
						(self setScript: poundScr2 self)
						(= global196 0)
					)
					(1
						(Load rsSOUND 421)
						(Load rsSOUND 144)
						(Load rsSOUND 913)
						(Load rsSOUND 912)
						(self setScript: poundScr3 self)
					)
					(2
						(Load rsSOUND 325)
						(Load rsSOUND 386)
						(Load rsSOUND 911)
						(Load rsSOUND 386)
						(self setScript: poundScr4 self)
					)
					(3
						(Load rsSOUND 325)
						(Load rsSOUND 386)
						(Load rsSOUND 911)
						(Load rsSOUND 908)
						(Load rsSOUND 2)
						(self setScript: poundScr5 self)
					)
					(4
						(Load rsSOUND 907)
						(Load rsSOUND 909)
						(Load rsSOUND 901)
						(Load rsSOUND 910)
						(if (== 1 (Random 0 6))
							(self setScript: poundScr6 self)
						else
							(Load rsSOUND 421)
							(Load rsSOUND 144)
							(Load rsSOUND 913)
							(Load rsSOUND 912)
							(self setScript: poundScr3 self)
						)
					)
				)
			)
			(2
				(gGlobalSound1 fade: 127 10 10 0)
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 623)
			)
		)
	)
)

(instance poundScr1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 8)
				((ScriptID 620 5) number: 421 loop: -1 play:) ; sfxL
				(= cycles 2)
			)
			(1
				(switch register
					(6
						((ScriptID 620 2) number: 2 loop: 1 play: self) ; sfx
					)
					(4
						((ScriptID 620 2) number: 144 loop: 1 play: self) ; sfx
					)
					(2
						((ScriptID 620 2) number: 2 loop: 1 play: self) ; sfx
					)
					(else
						(= ticks 30)
					)
				)
			)
			(2
				(if (OneOf register 6 4 2)
					((ScriptID 620 5) play:) ; sfxL
				)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 30)
			)
			(3
				((ScriptID 620 5) number: 0 stop:) ; sfxL
				(self dispose:)
			)
		)
	)
)

(instance poundScr2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 6)
				(= cycles 2)
			)
			(1
				(switch register
					(6
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(5
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(4
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(3
						((ScriptID 620 2) number: 657 loop: 1 play: self) ; sfx
					)
					(2
						((ScriptID 620 2) number: 652 loop: 1 play: self) ; sfx
					)
					(1
						((ScriptID 620 2) number: 652 loop: 1 play: self) ; sfx
					)
					(0
						((ScriptID 620 2) number: 910 loop: 1 play: self) ; sfx
					)
				)
			)
			(2
				(if (OneOf register 3 0)
					(= ticks 60)
				else
					(= ticks 20)
				)
				(if (!= (-- register) -1)
					(-= state 2)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poundScr3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 620 5) number: 421 loop: -1 play:) ; sfxL
				(= register 9)
				(= cycles 2)
			)
			(1
				(switch register
					(7
						((ScriptID 620 2) number: 913 loop: 1 play: self) ; sfx
					)
					(5
						((ScriptID 620 2) number: 913 loop: 1 play: self) ; sfx
					)
					(3
						((ScriptID 620 2) number: 144 loop: 1 play: self) ; sfx
					)
					(1
						((ScriptID 620 2) number: 912 loop: 1 play: self) ; sfx
					)
					(else
						(= ticks 30)
					)
				)
			)
			(2
				(if (OneOf register 7 5 3 1)
					((ScriptID 620 5) play:) ; sfxL
				)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 120)
			)
			(3
				((ScriptID 620 5) number: 0 stop:) ; sfxL
				(self dispose:)
			)
		)
	)
)

(instance poundScr4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 6)
				((ScriptID 620 5) number: 325 loop: -1 play:) ; sfxL
				(= cycles 2)
			)
			(1
				(switch register
					(5
						((ScriptID 620 2) number: 386 loop: 1 play: self) ; sfx
					)
					(3
						((ScriptID 620 2) number: 911 loop: 1 play: self) ; sfx
					)
					(1
						((ScriptID 620 2) number: 386 loop: 1 play: self) ; sfx
					)
					(else
						(= ticks 90)
					)
				)
			)
			(2
				(if (OneOf register 5 3 1)
					((ScriptID 620 5) play:) ; sfxL
				)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 90)
			)
			(3
				((ScriptID 620 5) number: 0 stop:) ; sfxL
				(self dispose:)
			)
		)
	)
)

(instance poundScr5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 10)
				(= cycles 2)
			)
			(1
				(switch register
					(10
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(9
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(8
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(7
						((ScriptID 620 2) number: 911 loop: 1 play: self) ; sfx
					)
					(6
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(5
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(4
						((ScriptID 620 2) number: 2 loop: 1 play: self) ; sfx
					)
					(3
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(2
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(1
						((ScriptID 620 2) number: 908 loop: 1 play: self) ; sfx
					)
					(0
						((ScriptID 620 2) number: 911 loop: 1 play: self) ; sfx
					)
				)
			)
			(2
				(if (!= (-- register) -1)
					(-= state 2)
				)
				(= ticks 30)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poundScr6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 5)
				(= cycles 2)
			)
			(1
				(switch register
					(5
						((ScriptID 620 2) number: 907 loop: 1 play: self) ; sfx
					)
					(4
						((ScriptID 620 2) number: 909 loop: 1 play: self) ; sfx
					)
					(3
						((ScriptID 620 2) number: 901 loop: 1 play: self) ; sfx
					)
					(2
						((ScriptID 620 2) number: 910 loop: 1 play: self) ; sfx
					)
					(1
						((ScriptID 620 2) number: 907 loop: 1 play: self) ; sfx
					)
					(0
						((ScriptID 620 2) number: 901 loop: 1 play: self) ; sfx
					)
				)
			)
			(2
				(if (!= (-- register) -1)
					(-= state 2)
				)
				(= ticks 30)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sexLineScr of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 623)
	)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(SetFlag 97)
				(gMessager say: 1 4 67 0 self 610) ; "Welcome to La Costa Lotta's Telephone Sex Service."
			)
			(1
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(2
				(switch register
					(1
						(gMessager say: 1 4 71 1 self 610) ; "You selected 1, Straight Sex.  Press 1 for teenager. Press 2 for age 20-29. Press 3 for age 30-39. Press 4 for "mature" women. Press 5 for perversions."
					)
					(else
						(= state 0)
						(gMessager say: 1 4 70 0 self 610) ; "That is not a valid selection... for you!"
					)
				)
			)
			(3
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(4
				(switch register
					(5
						(= state 19)
						(gCast eachElementDo: #stopUpd)
						(= ticks 90)
					)
					(else
						(gMessager say: 1 4 71 2 self 610) ; "DOS Error on File Server: PHONESEX  "Sector worn out." Contact SysOp or defrag.  ErrNum: 134802,69"
					)
				)
			)
			(5
				(proc610_2)
				(SetFlag 57)
				(proc610_3)
				(self dispose:)
			)
			(20
				(gMessager say: 1 4 88 0 self 610) ; "(Oh, boy! This oughta be great!!)"
			)
			(21
				(= ticks 90)
			)
			(22
				(= gQuit 1)
			)
		)
	)
)

