;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use dummyClient)
(use Print)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	local0
	local1
	local2 = 100
)

(procedure (localproc_0)
	(fButt init: setCycle: Fwd)
	(lButt init: setCycle: Fwd)
	(radar init: setCycle: Fwd)
	((Prop new:) view: 404 loop: 1 cel: 2 posn: 4 54 ignoreActors: 1 addToPic:)
	(fScreen init:)
)

(instance rm360 of Rm
	(properties
		noun 7
		picture 400
		north 400
		south 340
	)

	(method (init)
		(gCMusic number: 17 setLoop: -1 play:)
		(super init:)
		(lever init:)
		(chipPanel init:)
		(chipPan_F init:)
		(chipProg init:)
		(ptrnPanel init:)
		(butt init:)
		(battery init:)
		(batteryCh init:)
		(chair init:)
		(if (not [global135 24])
			(lWin init:)
			(rWin init:)
		)
		(if [global135 25]
			(localproc_0)
			(= local0 2)
			(butt noun: 3)
			(ptrnPuz init:)
			(if [global135 24]
				(= local0 5)
				(bWin init:)
			)
		else
			(self setScript: comeIn)
			(bigArrows init: setCycle: Fwd)
		)
		(SetFlag 22)
		((ScriptID 365) init:) ; gates
		(= local2 gDifficulty)
	)

	(method (dispose)
		((ScriptID 370) dispose:) ; pattern
		(DisposeScript 370)
		((ScriptID 365) dispose:) ; gates
		(DisposeScript 365)
		(super dispose:)
	)
)

(instance bigArrows of Prop
	(properties
		x 168
		y 11
		noun 7
		view 404
		loop 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance lWin of Actor
	(properties
		x -1
		y 2
		noun 15
		view 408
		loop 8
		signal 30993
	)
)

(instance rWin of Actor
	(properties
		x 109
		noun 15
		view 408
		loop 12
		signal 30993
	)
)

(instance bWin of Feature
	(properties
		noun 13
		onMeCheck 128
	)
)

(instance rooroo of Prop
	(properties
		x 180
		y 109
		noun 21
		view 408
	)
)

(instance sparks of Prop
	(properties
		x 263
		y 53
		view 408
		loop 1
	)
)

(instance fButt of Prop
	(properties
		x 42
		y 47
		noun 7
		view 408
		loop 2
	)
)

(instance lButt of Prop
	(properties
		x 11
		y 171
		noun 7
		view 408
		loop 3
	)
)

(instance lever of Prop
	(properties
		x 107
		y 40
		noun 14
		view 408
		loop 4
		cel 3
		signal 30993
		cycleSpeed 15
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (== local0 2))
				(gCurRoom setScript: try2)
			)
			((and (== theVerb 4) (== local0 5))
				(gCurRoom setScript: try3)
			)
			(1
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance radar of Prop
	(properties
		x 78
		y 36
		noun 11
		view 408
		loop 5
		cycleSpeed 12
	)
)

(instance lightL of Prop
	(properties
		x 159
		y 6
		view 408
		loop 6
	)
)

(instance lightR of Prop
	(properties
		x 213
		view 408
		loop 7
		cel 1
	)
)

(instance ptrnPanel of Prop
	(properties
		x 85
		y 78
		noun 7
		view 408
		loop 10
		signal 16641
	)

	(method (onMe)
		(return 0)
	)
)

(instance blow of Prop
	(properties
		x 85
		y 78
		noun 7
		view 408
		loop 14
	)

	(method (onMe)
		(return 0)
	)
)

(instance chipPanel of Prop
	(properties
		x 161
		y 114
		noun 21
		view 408
		loop 13
		signal 16641
		cycleSpeed 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gMessager say: 9 9 0 1 self 20) ; "Good job! You have found my battery. It is imperative that you bring it to me immediately. And while you're at it, put a fresh charge on it."
			)
			(2
				(= ticks 30)
			)
			(3
				(gCSoundFX number: 233 loop: 1 play:)
				(ShakeScreen 20 ssLEFTRIGHT)
				(gMessager say: 22 9 0 0 self) ; "Wow! That was quite a shake. That one almost tore this room apart. What is causing these quakes?"
			)
			(4
				(= local0 0)
				(HandsOn)
			)
		)
	)

	(method (doit)
		(Palette palANIMATE 224 230 -4)
		(super doit:)
	)
)

(instance try1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bigArrows dispose:)
				(gCSoundFX number: 213 loop: 1 play:)
				(lightL init: setCycle: Fwd)
				(lightR init: setCycle: Fwd)
				(= ticks 90)
			)
			(1
				(gCSoundFX number: 176 loop: 1 play:)
				(fButt init: setCycle: Fwd)
				(radar init: setCycle: End self)
				((= register (Prop new:))
					view: 404
					loop: 1
					cycleSpeed: 12
					posn: 4 54
					init:
					setCycle: End
				)
			)
			(2
				(register setCycle: Beg)
				(lightL dispose:)
				(lightR dispose:)
				(fButt dispose:)
				(radar dispose:)
				(ptrnPanel
					signal: (& (ptrnPanel signal:) $feff)
					startUpd:
					setCycle: End self
				)
				(gCSoundFX number: 136 loop: 1 play:)
				(= ticks 10)
			)
			(3
				(blow init: setCycle: End self)
			)
			(4
				(gCSoundFX number: 191 loop: 1 play:)
			)
			(5
				(register dispose:)
				(blow loop: 15 setCycle: Fwd)
				(= local0 1)
				(butt noun: 3)
				(ptrnPuz init:)
				(ptrnPanel signal: (| (ptrnPanel signal:) $0100) stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ptrnScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (not (IsFlag 22)) (!= register gDifficulty))
					((ScriptID 370) dispose:) ; pattern
					(DisposeScript 370)
					(SetFlag 22)
				)
				(if (IsFlag 22)
					(ClearFlag 22)
					(= register gDifficulty)
					((ScriptID 370) init:) ; pattern
				)
				(if (not (ptrnPanel cel:))
					(ptrnPanel
						signal: (& (ptrnPanel signal:) $feff)
						startUpd:
						setCycle: End self
					)
				else
					(= cycles 1)
					(++ state)
				)
			)
			(1
				(gCSoundFX number: 191 loop: 1 play: self)
			)
			(2
				(HandsOn)
				((ScriptID 370) show:) ; pattern
				(if [global135 25]
					(HandsOff)
					(if (IsFlag 22)
						((ScriptID 370) dispose:) ; pattern
						(DisposeScript 370)
					)
					(blow dispose:)
					(ptrnPanel
						signal: (& (ptrnPanel signal:) $feff)
						startUpd:
						setCycle: Beg self
					)
				else
					(self dispose:)
				)
			)
			(3
				(ptrnPanel signal: (| (ptrnPanel signal:) $0100) stopUpd:)
				(gCSoundFX number: 191 loop: 1 play:)
				(if (>= local0 2)
					(HandsOn)
					(self dispose:)
				else
					(gCSoundFX number: 176 loop: 1 play:)
					(fButt init: setCycle: Fwd)
					(lButt init: setCycle: Fwd)
					(radar init: setCycle: Fwd)
					((= register (Prop new:))
						view: 404
						loop: 1
						cycleSpeed: 12
						posn: 4 54
						init:
						ignoreActors: 1
						setCycle: End self
					)
				)
			)
			(4
				(register addToPic:)
				(fScreen init:)
				(gMessager say: 7 9 15 0 self) ; "Throw |c2|the lever|c| forward."
			)
			(5
				(= local0 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance try2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lever
					signal: (& (lever signal:) $feff)
					startUpd:
					setCycle: Beg self
				)
			)
			(1
				(gCSoundFX number: 216 loop: 1 play:)
				(ShakeScreen 20 ssLEFTRIGHT)
				(lever setCycle: End self)
			)
			(2
				(lever signal: (| (lever signal:) $0100) stopUpd:)
				(gCSoundFX number: 221 loop: -1 play: self)
				(rooroo init: setCycle: Fwd)
				(= ticks 180)
			)
			(3
				(chipPanel
					signal: (& (chipPanel signal:) $feff)
					startUpd:
					setCycle: End self
				)
				(gCSoundFX number: 136 loop: 1 play:)
				(= ticks 18)
			)
			(4
				(blow init: loop: 11 x: 165 y: 120 setCycle: End self)
			)
			(5)
			(6
				(gCSoundFX number: 191 loop: 1 play:)
				(chipPanel dispose:)
				(blow dispose:)
				(= local0 3)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance logicScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetCursor 400 1 0)
				((= register (Prop new:))
					view: 404
					loop: 2
					cycleSpeed: 12
					posn: 0 122
					ignoreActors: 1
					init:
					setCycle: End self
				)
			)
			(1
				(DisposeScript 369)
				(= ticks 15)
			)
			(2
				(= local1 [global135 24])
				(HandsOn)
				(if (!= local2 gDifficulty)
					((ScriptID 365) dispose:) ; gates
					(DisposeScript 365)
					((ScriptID 365) init:) ; gates
					(= local2 gDifficulty)
				)
				(if (== ((ScriptID 365) show:) 1) ; gates
					(= local2 100)
				)
				(HandsOff)
				(register setCycle: Beg self)
			)
			(3
				(register dispose:)
				(if (or local1 (not [global135 24]))
					(HandsOn)
					(self dispose:)
				else
					(self setScript: (ScriptID 369) self 1) ; chipPull
				)
			)
			(4
				(chipPanel cel: 0 addToPic:)
				(sparks init: setCycle: Fwd)
				(gCSoundFX number: 229 loop: -1 play:)
				(= seconds 4)
			)
			(5
				(lWin
					signal: (& (lWin signal:) $feff)
					startUpd:
					setMotion: MoveTo (lWin x:) -39 self
				)
				(rWin
					signal: (& (rWin signal:) $feff)
					startUpd:
					setMotion: MoveTo (rWin x:) -24
				)
			)
			(6
				(rWin dispose:)
				(bWin init:)
				(lWin noun: 12 loop: 9 posn: 16 -27 setMotion: MoveTo 16 0 self)
			)
			(7
				(lWin signal: (| (lWin signal:) $0100) stopUpd:)
				(sparks dispose:)
				(gCSoundFX stop:)
				(gMessager say: 7 9 15 0 self) ; "Throw |c2|the lever|c| forward."
			)
			(8
				(= local0 5)
				(rooroo dispose:)
				(DisposeScript 369)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance try3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lever
					signal: (& (lever signal:) $feff)
					startUpd:
					setCycle: Beg self
				)
			)
			(1
				(lever signal: (| (lever signal:) $0100) stopUpd:)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance ptrnPuz of Feature
	(properties
		noun 16
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (>= local0 1))
			(gCurRoom setScript: ptrnScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance butt of Feature
	(properties
		noun 9
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== local0 0))
			(gCurRoom setScript: try1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chipPan_F of Feature
	(properties
		noun 21
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (>= local0 3))
			(if (== local0 3)
				(= local0 4)
				(gCurRoom setScript: (ScriptID 369)) ; chipPull
				((ScriptID 369) next: logicScr) ; chipPull
			else
				(gCurRoom setScript: logicScr)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chipProg of Feature
	(properties
		noun 19
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (>= local0 4))
			(gCurRoom setScript: logicScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fScreen of Feature
	(properties
		y 60
		noun 7
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 4))
			((Print new:) addIcon: 404 0 0 0 0 posn: 45 35 init:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance battery of Feature
	(properties
		noun 17
		onMeCheck 1024
	)
)

(instance batteryCh of Feature
	(properties
		noun 18
		onMeCheck 512
	)
)

(instance chair of Feature
	(properties
		noun 10
		onMeCheck 24
	)
)

