;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use RTEyeCycle)
(use PolyPath)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	dayOne 0
	dayTwo 1
	dayThree 2
	dayFour 3
	dayFive 4
	noRobeAbbeyMonkMet 5
	noRobeFensMonkMet 6
	secondNoRescue 7
	thirdNoRescue 8
	day6B 9
	day6A 10
	day7 11
	day8 12
	day8Puck 13
	day9Will 14
	day10 15
	day11 16
	day12 17
	day13 18
)

(local
	local0
	[local1 5] = [1151 0 1 2 0]
	[local6 5] = [1151 2 1 2 0]
	[local11 6] = [1151 4 1 2 2 0]
	[local17 6] = [1151 7 1 2 2 0]
	[local23 5] = [1151 10 1 2 0]
	[local28 58] = [1151 12 1 0 1151 13 1 2 0 1151 15 1 2 0 1151 17 1 0 1151 18 1 0 1151 19 1 2 0 1151 21 1 0 1151 22 1 0 1151 23 1 0 1151 24 1 1 0 1151 25 1 0 1151 26 2 1 2 0 1151 29 1 0]
	[local86 5] = [1151 30 2 1 0]
	[local91 5] = [1151 32 2 1 0]
	[local96 5] = [1151 34 1 2 0]
	[local101 5] = [1151 36 1 2 0]
	[local106 8] = [1151 38 1 1 1 2 1 0]
	[local114 5] = [1151 43 2 1 0]
	[local119 5] = [1151 45 2 1 0]
	[local124 12] = [1151 47 1 1 1 2 1 1 2 1 2 0]
	[local136 5] = [1151 56 2 1 0]
	[local141 5] = [1151 58 2 1 0]
	[local146 5] = [1151 60 1 2 0]
	[local151 5] = [1151 62 2 1 0]
	[local156 4] = [1151 64 1 0]
	[local160 9] = [1151 65 2 1 2 2 1 2 0]
	[local169 6] = [1151 71 1 2 2 0]
	[local175 8] = [1151 74 2 1 2 2 2 0]
	[local183 7] = [1151 79 2 1 2 2 0]
	[local190 10] = [1151 83 2 1 2 2 2 1 2 0]
	[local200 6] = [1151 90 2 1 2 0]
	[local206 10] = [1151 93 1 2 2 2 1 2 2 0]
	[local216 7] = [1151 123 1 2 2 1 0]
	[local223 5] = [1151 127 1 2 0]
	[local228 6] = [1151 131 2 1 2 0]
	[local234 5] = [1151 134 1 2 0]
	[local239 6] = [1151 136 1 2 2 0]
	[local245 5] = [1151 139 1 2 0]
	[local250 6] = [1151 141 1 1 2 0]
	[local256 6] = [1151 144 1 2 1 0]
	[local262 12] = [1151 147 2 2 2 1 1 2 1 2 1 0]
	[local274 6] = [1151 156 1 2 1 0]
	[local280 7] = [1151 159 2 2 2 1 0]
	[local287 4] = [1151 163 1 0]
	[local291 10] = [1151 164 3 1 3 3 3 2 3 0]
	[local301 14] = [1151 171 2 2 1 2 2 2 2 2 2 1 1 0]
	[local315 6] = [1151 182 1 1 1 0]
	[local321 10] = [1151 185 2 2 2 1 2 2 1 0]
	[local331 12] = [1151 192 2 2 2 1 2 2 2 1 2 0]
)

(instance pucksClothes of View
	(properties
		x 175
		y 129
		view 140
		loop 5
		cel 1
		priority 12
		signal 16401
	)
)

(instance dayOne of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 23) cycleSpeed: 24) ; Tuck
				((ScriptID 21) cycleSpeed: 18) ; Alan
				(Face (ScriptID 19) gEgo) ; John
				(Face (ScriptID 20) gEgo) ; Will
				(= ticks 30)
			)
			(1
				(gEgo stopUpd:)
				(Converse 2 @local1 13 0 16 3 self) ; "Morning. We've all broken our fasts, but mayhap Tuck will share some of his fish with you."
			)
			(2
				(Converse 2 @local6 15 0 16 3 self) ; "I'll remember that gibe when it comes time to dole out the stew tonight."
			)
			(3
				(Converse 2 @local11 3 0 14 3 self) ; "You know the old Norman saying, Alan, `Never make an enemy of the cook'."
			)
			(4
				((ScriptID 20) ignoreActors: 0 setMotion: PolyPath 320 70 self) ; Will
			)
			(5
				(Face gEgo (ScriptID 19) self) ; John
			)
			(6
				(gEgo stopUpd:)
				(Converse 2 @local17 3 0 13 3 self) ; "What of you, Little John?"
			)
			(7
				(Face gEgo (ScriptID 23) self) ; Tuck
			)
			(8
				(Converse 2 @local23 1 0 15 3 self) ; "Is that true?"
			)
			(9
				(Converse 1 @local28 13 0 self) ; "Well, I'm off then. Join me there if you have a mind to."
			)
			(10
				((ScriptID 19) ignoreActors: 0 setMotion: PolyPath -25 131 self) ; John
			)
			(11
				((ScriptID 20) dispose:) ; Will
				((ScriptID 19) dispose:) ; John
				(= cycles 1)
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance dayTwo of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 7 157)
				(Face (ScriptID 23) gEgo) ; Tuck
				(Face (ScriptID 19) gEgo) ; John
				(Face (ScriptID 21) gEgo) ; Alan
				(= ticks 30)
			)
			(1
				(NormalEgo)
				(= ticks 30)
			)
			(2
				(Converse 2 @local86 3 0 13 3 self) ; "Ah, so you live after all. Morning is nearly gone and we'd about given you up for dead."
			)
			(3
				(Converse 2 @local91 1 0 15 3 self) ; "You look a bit worse for wear, but you have an odd light in your eyes."
			)
			(4
				(Converse 2 @local96 16 0 13 3 self) ; "Not to wonder! Inspired by such mighty draughts of grog as you consumed--"
			)
			(5
				(Converse 2 @local101 1 0 16 3 self) ; "There was a woman with raven hair and a dress that moved like a white flame. I've never seen such a beautiful maid."
			)
			(6
				(Converse 2 @local106 1 0 13 3 self) ; "Hush, Alan! This is no jest to me."
			)
			(7
				(gEgo view: 7 loop: 5 cel: 0 setCycle: CT 4 1 self)
			)
			(8
				(gEgo signal: (| (gEgo signal:) $0100) stopUpd:)
				((ScriptID 19) setCycle: Walk setMotion: PolyPath 232 115) ; John
				((ScriptID 23) signal: 1) ; Tuck
				((ScriptID 21) setCycle: Walk setMotion: PolyPath 224 146 self) ; Alan
			)
			(9
				(gEgo signal: (& (gEgo signal:) $feff) startUpd:)
				(Converse 2 @local114 1 0 15 3 self) ; "By my troth! A real emerald."
			)
			(10
				(Converse 2 @local119 1 0 13 3 self) ; "I say you should have more dreams like this and we'll all be rich!"
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(NormalEgo 1)
				((ScriptID 20) setMotion: PolyPath 30 131 self) ; Will
			)
			(13
				(= notKilled 1)
				(Converse 2 @local124 14 0 1 3 self) ; "Robin, I'm glad you're finally up. I've just gotten an urgent message from a friend in town."
			)
			(14
				(Converse 2 @local136 3 0 16 3 self) ; "Why, there's nothing to it, Robin. Have a few more grogs and dream one up!"
			)
			(15
				(Face (ScriptID 19) (ScriptID 21)) ; John, Alan
				((ScriptID 21) ; Alan
					view: 157
					loop: 3
					cel: 5
					setCycle: Beg
					setMotion:
						PolyPath
						((ScriptID 21) x:) ; Alan
						(- ((ScriptID 21) y:) 3) ; Alan
						self
				)
			)
			(16
				(Converse 2 @local141 16 0 13 3 self) ; "Surely, Master."
			)
			(17
				(Converse 2 @local146 1 0 14 3 self) ; "What do you advise, Will?"
			)
			(18
				(Converse 2 @local151 1 0 15 3 self) ; "But even if Robin had a slipper, he cannot walk into Nottingham without being hanged upon the spot!"
			)
			(19
				(Converse 1 @local156 13 0 self) ; "As you will, Master. We all have tasks of our own, but we'll think upon it as well."
			)
			(20
				((ScriptID 19) setMotion: PolyPath 320 70) ; John
				((ScriptID 20) setMotion: PolyPath -15 131) ; Will
				(= cycles 50)
			)
			(21
				((ScriptID 21) ; Alan
					setCycle: StopWalk 158
					setMotion: PolyPath -15 188
				)
				(= cycles 65)
			)
			(22
				((ScriptID 23) setMotion: PolyPath 80 245 self) ; Tuck
			)
			(23
				((ScriptID 19) dispose:) ; John
				((ScriptID 20) dispose:) ; Will
				((ScriptID 21) dispose:) ; Alan
				((ScriptID 23) dispose:) ; Tuck
				(gEgo signal: (& (gEgo signal:) $feff) startUpd:)
				(= cycles 1)
			)
			(24
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance dayThree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 151)
				(= ticks 30)
			)
			(1
				(Converse @local160 1 13 self) ; "I had a bit of luck on Watling Street today and brought you a present."
			)
			(2
				((ScriptID 19) setMotion: PolyPath 325 73 self) ; John
			)
			(3
				((ScriptID 19) dispose:) ; John
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance dayFour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face (ScriptID 20) gEgo) ; Will
				(= ticks 30)
			)
			(1
				(Converse @local169 3 14 self) ; "Morning, Will. Any news?"
			)
			(2
				((ScriptID 20) ; Will
					setMotion: PolyPath (+ ((ScriptID 20) x:) 10) 240 self ; Will
				)
			)
			(3
				((ScriptID 20) dispose:) ; Will
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance dayFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Face (ScriptID 21) gEgo) ; Alan
				(Face gEgo (ScriptID 21)) ; Alan
				(= ticks 30)
			)
			(2
				(Converse @local175 3 16 self) ; "Top o'the morning to you."
			)
			(3
				((ScriptID 21) ; Alan
					setMotion: PolyPath (+ ((ScriptID 21) x:) 77) 83 self ; Alan
				)
			)
			(4
				((ScriptID 21) dispose:) ; Alan
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance noRobeFensMonkMet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face (ScriptID 19) gEgo) ; John
				(Face gEgo (ScriptID 19)) ; John
				(= ticks 30)
				(gEgo get: 5) ; pipe
				(gEgo get: 6) ; gems
				(gEgo put: 5 140) ; pipe
				(gEgo put: 6 140) ; gems
			)
			(1
				(Converse @local183 999 13 self) ; "There you are."
			)
			(2
				((ScriptID 19) setMotion: PolyPath 317 88 self) ; John
			)
			(3
				((ScriptID 19) dispose:) ; John
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance noRobeAbbeyMonkMet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face (ScriptID 23) gEgo) ; Tuck
				(Face gEgo (ScriptID 23)) ; Tuck
				(= ticks 30)
			)
			(1
				(Converse @local190 999 15 self) ; "You've missed the fun, I'm afraid. I waylaid one of those sluggish Abbey Monks and had a bit of sport with him."
			)
			(2
				((ScriptID 23) setMotion: PolyPath -15 131 self) ; Tuck
			)
			(3
				((ScriptID 23) dispose:) ; Tuck
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance secondNoRescue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 20)) ; Will
				(Face (ScriptID 20) gEgo) ; Will
				(= ticks 30)
			)
			(1
				((ScriptID 20) view: 161 loop: 0 cel: 0 setCycle: Walk) ; Will
				(= cycles 10)
			)
			(2
				(Converse @local200 9 14 self) ; "You're back. Any luck in town?"
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance thirdNoRescue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(Converse @local206 9 15 self) ; "Tuck, it's nearly sunset!"
			)
			(2
				(gEgo setMotion: PolyPath 145 110 self)
			)
			(3
				(= ticks 18)
			)
			(4
				((ScriptID 23) dispose:) ; Tuck
				(= ticks 6)
			)
			(5
				(gEgo hide:)
				(gCurRoom drawPic: 803 -32762)
				(= ticks 48)
			)
			(6
				(gCurRoom newRoom: 160)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day6B of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(Converse @local223 13 16 self) ; "Greetings, Master Hood! What a fine day it is."
			)
			(2
				((ScriptID 21) signal: (| ((ScriptID 21) signal:) $4001)) ; Alan, Alan
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day6A of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 22)) ; Much
				(Face (ScriptID 22) gEgo) ; Much
				(= ticks 30)
			)
			(1
				(Converse @local216 999 17 self) ; "You're looking thoughtful."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day7 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 23)) ; Tuck
				(= ticks 30)
			)
			(1
				(Face (ScriptID 23) gEgo) ; Tuck
				(= ticks 30)
			)
			(2
				(Converse @local228 999 15 self) ; "You look pleased with yourself."
			)
			(3
				(Converse @local234 999 15 self) ; "There's no need--"
			)
			(4
				((ScriptID 23) setMotion: PolyPath -15 131 self) ; Tuck
			)
			(5
				((ScriptID 23) dispose:) ; Tuck
				(= cycles 1)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day8 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo 1 0 1)
				(= ticks 30)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo signal: (| (gEgo signal:) $0100) stopUpd:)
				(Face (ScriptID 23) gEgo) ; Tuck
				(Face (ScriptID 21) gEgo) ; Alan
				(Face (ScriptID 19) gEgo) ; John
				(Face (ScriptID 22) gEgo self) ; Much
			)
			(3
				(Converse @local239 999 16 self) ; "What ho, lads? You all look a trifle glum?"
			)
			(4
				(Converse @local245 17 15 self) ; "...the archery tournament..."
			)
			(5
				(Converse @local250 999 13 self) ; "How could I forget my mission? I must find a safe way to go to the fair today."
			)
			(6
				(Converse @local256 999 13 self) ; "Well, go! You're all clever men. If you can find a means and wish to risk your necks, by all means do so."
			)
			(7
				((ScriptID 21) ; Alan
					setCycle: StopWalk 158
					setMotion: PolyPath 148 250 self
				)
			)
			(8
				((ScriptID 22) setMotion: PolyPath -20 172 self) ; Much
			)
			(9
				((ScriptID 19) setCycle: Walk setMotion: PolyPath 140 250 self) ; John
			)
			(10
				((ScriptID 23) setMotion: PolyPath 104 260 self) ; Tuck
			)
			(11
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 22) dispose:) ; Much
				((ScriptID 21) dispose:) ; Alan
				((ScriptID 19) setCycle: 0 dispose:) ; John
				(gEgo signal: (& (gEgo signal:) $feff) startUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day8Puck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(pucksClothes init:)
				(Face (ScriptID 19) gEgo) ; John
				(= ticks 30)
			)
			(1
				(Converse @local301 999 13 self) ; "Ah, there you are. The lads and I have been enjoying the Fair."
			)
			(2
				((ScriptID 19) hide:) ; John
				(gEgo hide:)
				(gCast eachElementDo: #hide)
				(pucksClothes dispose:)
				(gCurRoom drawPic: 803 8 1 0)
				(= cycles 10)
			)
			(3
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 150 8 1 0)
				(= gDisguiseNum 4) ; yeoman
				(= gRoomCount 43)
				(NormalEgo)
				((ScriptID 19) show:) ; John
				(gEgo posn: 275 125 show: setMotion: PolyPath 262 125 self)
			)
			(4
				(Converse 1 @local315 13 0 self) ; "You'll not be recognized in this disguise, Master!"
			)
			(5
				(if (gEgo has: 1) ; horn
					(gEgo put: 1 140) ; horn
				)
				(if (gEgo has: 2) ; halfHeart
					(gEgo put: 2 140) ; halfHeart
				)
				(if (gEgo has: 3) ; slipper
					(gEgo put: 3 140) ; slipper
				)
				(if (gEgo has: 15) ; comb
					(gEgo put: 15 140) ; comb
				)
				(if (gEgo has: 11) ; cask
					(gEgo put: 11 140) ; cask
				)
				(if (gEgo has: 14) ; amethyst
					(gEgo put: 14 140) ; amethyst
				)
				(if (gEgo has: 12) ; puzzleBox
					(gEgo put: 12 140) ; puzzleBox
				)
				(if (gEgo has: 10) ; fireRing
					(gEgo put: 10 140) ; fireRing
				)
				(if (gEgo has: 13) ; robes
					(gEgo put: 13 140) ; robes
				)
				(if (gEgo has: 4) ; net
					(gEgo put: 4 140) ; net
				)
				(if (gEgo has: 5) ; pipe
					(gEgo put: 5 140) ; pipe
				)
				(if (gEgo has: 6) ; gems
					(gEgo put: 6 140) ; gems
				)
				(if (gEgo has: 16) ; fulkScroll
					(gEgo put: 16 140) ; fulkScroll
				)
				(if (gEgo has: 18) ; waterRing
					(gEgo put: 18 140) ; waterRing
				)
				(if (gEgo has: 7) ; jewels
					(gEgo put: 7 140) ; jewels
				)
				(if (gEgo has: 8) ; rouge
					(gEgo put: 8 140) ; rouge
				)
				(if (gEgo has: 9) ; message
					(gEgo put: 9 140) ; message
				)
				(= ticks 6)
			)
			(6
				((ScriptID 19) setMotion: PolyPath 135 250 self) ; John
			)
			(7
				((ScriptID 19) dispose:) ; John
				(= cycles 1)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day9Will of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 20)) ; Will
				(Face (ScriptID 20) gEgo) ; Will
				(= ticks 30)
			)
			(1
				(Converse 2 @local321 999 0 14 3 self) ; "I was about to come for you, Robin."
			)
			(2
				((ScriptID 20) setMotion: PolyPath 110 245 self) ; Will
			)
			(3
				((ScriptID 20) dispose:) ; Will
				(= ticks 6)
			)
			(4
				(self dispose:)
				(HandsOn)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local262 2 13 self) ; "I was coming to get you. I have grievous news, my friend."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 23) ; Tuck
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: PolyPath 216 105 self
				)
			)
			(1
				(Face (ScriptID 23) gEgo) ; Tuck
				(= ticks 30)
			)
			(2
				(Converse @local274 3 15 self) ; "By the Virgin, I've never seen you breathless before. Is there a wolf at your heels?"
			)
			(3
				((ScriptID 23) ; Tuck
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 196 90 self
				)
			)
			(4
				((ScriptID 23) ; Tuck
					view: 143
					setLoop: 0
					setCel: 5
					posn: 194 87
					setCycle: Beg self
				)
			)
			(5
				(Converse @local280 3 15 self) ; "The Abbot's treasure train has been sighted!"
			)
			(6
				((ScriptID 23) signal: 1) ; Tuck
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 19)) ; John
				(Face (ScriptID 19) gEgo) ; John
				(= ticks 30)
			)
			(1
				(Converse 2 @local331 999 0 13 3 self) ; "It's good you're up. Will's sent me with a warning."
			)
			(2
				((ScriptID 19) setMotion: PolyPath 110 250 self) ; John
			)
			(3
				((ScriptID 19) dispose:) ; John
				(= ticks 6)
			)
			(4
				(self dispose:)
				(HandsOn)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

(instance day13 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face (ScriptID 20) gEgo) ; Will
				(Face gEgo (ScriptID 20)) ; Will
				(= ticks 30)
			)
			(1
				(Converse @local287 3 0 self) ; "A farthing for your thoughts, Will."
			)
			(2
				(Converse 3 @local291 1 0 2 0 14 3 self) ; "Eh? Oh, I was wondering what will happen to us if the King doesn't return."
			)
			(3
				((ScriptID 20) ; Will
					setMotion: PolyPath (- ((ScriptID 20) x:) 30) 240 self ; Will
				)
			)
			(4
				((ScriptID 20) dispose:) ; Will
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)
)

