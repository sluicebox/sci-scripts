;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0 = 2
	local1 = 2
	[local2 2] = [2 10]
	local4 = 10
	[local5 4] = [3 3 3 2]
	local9 = 160
	local10 = 120
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
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
)

(procedure (localproc_0)
	(SetCursor gTheCursor 1)
	(gCurRoom newRoom: 202) ; selChar
)

(instance intro of Rm
	(properties
		picture 400
		style 8
	)

	(method (init)
		(LoadMany rsPIC 460 400 906)
		(LoadMany rsVIEW 906 907 908 918 919 913 5 7 430 460 462)
		(super init:)
		(HandsOff)
		(cond
			((== global212 1)
				(Load rsSOUND 201)
				(introMusic number: 201)
			)
			((<= global212 4)
				(Load rsSOUND 301)
				(introMusic number: 301)
			)
			(else
				(Load rsSOUND 1)
				(introMusic number: 1)
			)
		)
		(gKeyHandler add: self)
		(gMouseHandler add: self)
		(self setScript: page1Script)
	)

	(method (handleEvent event)
		(cond
			((== (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(gContMusic stop:)
				(localproc_0)
			)
			((super handleEvent: event))
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(event claimed: 1)
						(gContMusic stop:)
						(localproc_0)
					)
					(KEY_F2
						(proc997_0)
					)
					(KEY_CONTROL
						(PromptQuit)
					)
				)
			)
			(else
				(event claimed: 1)
			)
		)
	)
)

(instance page1Script of Script
	(properties)

	(method (doit)
		(switch (introMusic prevSignal:)
			(20
				(= local11 4)
			)
			(30
				(= local11 6)
			)
			(40
				(= local11 9)
			)
			(50
				(= local11 13)
			)
		)
		(if (and (> local11 state) (or seconds cycles))
			(= seconds (= cycles 0))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 0)
				(= cycles 2)
			)
			(1
				(SetCursor gTheCursor 0)
				(introMusic init: play:)
				(= cycles 1)
			)
			(2
				(gCurRoom drawPic: 906)
				(if (== gHowFast 0)
					(self cue:)
				else
					(= seconds local1)
				)
			)
			(3
				(sierraText cel: 0 init: stopUpd:)
				(presentsText cel: 0 init: stopUpd:)
				(= seconds 8)
			)
			(4
				(claw1 cel: 0 init: cycleSpeed: 2 setCycle: End self)
			)
			(5
				(ShakeScreen 3)
				(= seconds 5)
			)
			(6
				(claw1 stopUpd:)
				(claw2 cel: 0 init: cycleSpeed: 2 setCycle: End)
				(= cycles local4)
			)
			(7
				(claw2 stopUpd:)
				(ShakeScreen 3)
				(head
					setLoop: 2
					cel: 0
					setPri: 6
					posn: 83 68
					init:
					cycleSpeed: (if (== gHowFast 0) 0 else 2)
					setCycle: End self
				)
			)
			(8
				(head setLoop: 3 cel: 0 posn: 87 49 init: setCycle: CT 4 1)
				(= seconds 5)
			)
			(9
				(head setCycle: CT 5 1 self)
			)
			(10
				(flame
					posn: 85 76
					setLoop: 0
					setCel: -1
					cel: 0
					setPri: 8
					ignoreActors:
					illegalBits: 0
					init:
					xStep: 3
					yStep: 6
					setMotion: MoveTo 218 228
					setCycle: End self
				)
			)
			(11
				(sierraText cycleSpeed: 2 setCycle: CT 2 1 self)
				(flame
					setLoop: 1
					cel: 0
					cycleSpeed: (if (== gHowFast 0) 0 else 1)
					setMotion: MoveTo 158 228
					setCycle: Fwd
				)
				(head setCycle: End)
			)
			(12
				(sierraText setCycle: End)
				(presentsText cycleSpeed: 2 setCycle: End)
				(= seconds (+ gHowFast 3))
			)
			(13
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(client setScript: page2Script)
			)
		)
	)
)

(instance page2Script of Script
	(properties)

	(method (doit)
		(if (== -1 (introMusic prevSignal:))
			(= local11 15)
		)
		(if (and (> local11 state) (or seconds cycles))
			(= seconds (= cycles 0))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 0)
				(gCurRoom drawPic: 400)
				(switch gHowFast
					(0
						(questText posn: 117 70 cycleSpeed: 0 cel: 2)
						(forText posn: 162 70 cycleSpeed: 0 cel: 2)
						(gloryText posn: 208 70 cycleSpeed: 0 cel: 2)
					)
					(1
						(questText posn: 133 115 cycleSpeed: 1 cel: 0)
						(forText posn: 161 115 cycleSpeed: 1 cel: 0)
						(gloryText posn: 189 115 cycleSpeed: 1 cel: 0)
					)
					(2
						(questText posn: 150 160 cycleSpeed: 2 cel: 0)
						(forText posn: 160 160 cycleSpeed: 2 cel: 0)
						(gloryText posn: 170 160 cycleSpeed: 2 cel: 0)
					)
					(else
						(questText posn: 160 200 cycleSpeed: 2 cel: 0)
						(forText posn: 160 200 cycleSpeed: 2 cel: 0)
						(gloryText posn: 160 200 cycleSpeed: 2 cel: 0)
						(if (> global107 80)
							(questText moveSpeed: 1)
							(forText moveSpeed: 1)
							(gloryText moveSpeed: 1)
						)
					)
				)
				(questText
					setLoop: 0
					setPri: 1
					ignoreActors:
					illegalBits: 0
					xStep: 16
					yStep: 10
					init:
					setCycle: End
					setMotion: MoveTo 76 37 self
				)
				(forText
					setLoop: 1
					setPri: 1
					ignoreActors:
					illegalBits: 0
					xStep: 16
					yStep: 10
					init:
					setCycle: End
					setMotion: MoveTo 150 59 self
				)
				(gloryText
					setLoop: 2
					setPri: 1
					ignoreActors:
					illegalBits: 0
					xStep: 16
					yStep: 10
					init:
					setCycle: End
					setMotion: MoveTo 243 99 self
				)
			)
			(1)
			(2)
			(3
				(questText view: 919 setLoop: 0 cel: 0 setCycle: Fwd)
				(forText view: 919 setLoop: 1 cel: 0 setCycle: Fwd)
				(gloryText view: 919 setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds (if (== gHowFast 0) 1 else 5))
			)
			(4
				(questText stopUpd:)
				(forText stopUpd:)
				(gloryText stopUpd:)
				(cond
					((== gHowFast 0)
						(saurus posn: 200 137 cycleSpeed: 0 moveSpeed: 0)
						(aHero posn: 120 137 cycleSpeed: 0 moveSpeed: 0)
					)
					((== gHowFast 1)
						(saurus posn: 90 137 cycleSpeed: 1 moveSpeed: 1)
						(aHero posn: 0 137 cycleSpeed: 1 moveSpeed: 1)
					)
					((== gHowFast 2)
						(saurus posn: 0 137 cycleSpeed: 1 moveSpeed: 1)
						(aHero posn: -100 137 cycleSpeed: 1 moveSpeed: 1)
					)
					(else
						(saurus posn: -50 137 cycleSpeed: 1 moveSpeed: 1)
						(aHero posn: -170 137 cycleSpeed: 1 moveSpeed: 1)
					)
				)
				(saurus
					setLoop: 0
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo 400 137
				)
				(aHero
					setLoop: 0
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo 340 137 self
				)
			)
			(5
				(saurus hide: stopUpd:)
				(aHero hide: stopUpd:)
				(if (>= gHowFast 2)
					(questText startUpd:)
					(forText startUpd:)
					(gloryText startUpd:)
				)
				(if (!= gHowFast 0)
					(titleSpell
						setLoop: 0
						cel: -1
						setPri: 8
						ignoreActors:
						illegalBits: 0
						xStep: 8
						yStep: 8
						posn: local9 local10
						init:
						setCycle: End self
					)
					(if (== gHowFast 3)
						(titleSpell cycleSpeed: 2 moveSpeed: 2)
					)
				else
					(self cue:)
				)
			)
			(6
				(if (!= gHowFast 0)
					(titleSpell2
						setLoop: 0
						cel: (titleSpell cel:)
						setPri: 8
						ignoreActors:
						illegalBits: 0
						xStep: 8
						yStep: 8
						posn: local9 local10
						init:
						setCycle: Fwd
						setMotion: MoveTo 231 160
					)
					(titleSpell setCycle: Fwd setMotion: MoveTo 89 160 self)
					(if (== gHowFast 3)
						(titleSpell2 cycleSpeed: 2 moveSpeed: 2)
					)
				else
					(self cue:)
				)
			)
			(7
				(soYou init: stopUpd:)
				(want init: stopUpd:)
				(toBeA init: stopUpd:)
				(heroWord init: stopUpd:)
				(if (!= gHowFast 0)
					(titleSpell setCycle: End)
					(titleSpell2 setCycle: End self)
				else
					(self cue:)
				)
			)
			(8
				(if (!= gHowFast 0)
					(titleSpell dispose:)
					(titleSpell2 dispose:)
				)
				(questText stopUpd:)
				(forText stopUpd:)
				(gloryText stopUpd:)
				(saurus
					view: 460
					setLoop: 1
					cel: 0
					xStep: 8
					yStep: 5
					cycleSpeed: 0
					moveSpeed: 0
					show:
				)
				(aHero
					view: 7
					setLoop: 0
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					show:
				)
				(switch gHowFast
					(0
						(aHero posn: 330 137 setMotion: MoveTo 230 137 self)
						(saurus posn: 390 137 setMotion: MoveTo 250 137)
					)
					(3
						(aHero posn: 400 137 setMotion: MoveTo 100 137 self)
						(saurus posn: 500 137 setMotion: MoveTo 120 137)
					)
					(else
						(aHero posn: 350 137 setMotion: MoveTo 140 137 self)
						(saurus posn: 420 137 setMotion: MoveTo 160 137)
					)
				)
			)
			(9
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(gCurRoom drawPic: 460)
				(quest2Text setPri: 1 ignoreActors: init: stopUpd:)
				(for2Text setPri: 1 ignoreActors: init: stopUpd:)
				(glory2Text setPri: 1 ignoreActors: init: stopUpd:)
				(dragonTail cycleSpeed: 4 init:)
				(if (== gHowFast 0)
					(dragonTail stopUpd:)
				else
					(dragonTail setScript: drTailScript)
				)
				(dragonHead
					setPri: 10
					init:
					cycleSpeed: 1
					setCycle: CT 5 1 self
				)
			)
			(10
				(if (== gHowFast 0)
					(self changeState: 14)
				)
				(= cycles 8)
			)
			(11
				(dragonHead cycleSpeed: 2 setCycle: CT 1 1 self)
			)
			(12
				(= cycles 8)
			)
			(13
				(dragonHead setCycle: CT 5 1 self)
			)
			(14
				(dragonHead stopUpd:)
				(dragonTail setCycle: 0 setScript: 0 stopUpd:)
				(quest2Text setCycle: Fwd)
				(for2Text setCycle: Fwd)
				(glory2Text setCycle: Fwd)
				(= seconds 15)
			)
			(15
				(dragonHead stopUpd:)
				(dragonTail setCycle: 0 setScript: 0 stopUpd:)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 2)
				)
			)
			(16
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(client setScript: creditScript)
			)
		)
	)
)

(instance creditScript of Script
	(properties)

	(method (doit)
		(switch (gContMusic prevSignal:)
			(10
				(= local11 3)
			)
			(20
				(= local11 6)
			)
			(30
				(= local11 9)
			)
			(40
				(= local11 12)
			)
			(50
				(= local11 15)
			)
			(60
				(= local11 18)
			)
			(70
				(= local11 21)
			)
		)
		(if (and (> local11 state) (or seconds cycles))
			(= seconds (= cycles 0))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 0)
				(Load rsPIC 903)
				(Load rsVIEW 901)
				(Load rsVIEW 902)
				(Load rsSOUND (SoundFX 61))
				(Load rsSOUND (SoundFX 73))
				(gCurRoom drawPic: 903 0)
				(leftDrag
					view: 901
					loop: 0
					cel: 0
					posn: 285 168
					priority: 12
					init:
					stopUpd:
				)
				(rightDrag
					view: 901
					loop: 1
					cel: 0
					posn: 32 168
					priority: 12
					init:
					stopUpd:
				)
				(andAnd view: 902 loop: 3 cel: 0 posn: 155 23 init: hide:)
				(byBy view: 902 loop: 0 cel: 1 posn: 155 40 init: hide:)
				(= cycles 1)
			)
			(1
				((= local12 (View new:))
					view: 902
					loop: 0
					cel: 0
					posn: 110 23
					init:
					stopUpd:
				)
				(andAnd show:)
				((= local14 (View new:))
					view: 902
					loop: 0
					cel: 3
					posn: 203 23
					init:
					stopUpd:
				)
				(byBy show:)
				((= local16 (View new:))
					view: 902
					loop: 1
					cel: 0
					posn: 157 90
					init:
					stopUpd:
				)
				(= seconds 4)
			)
			(2
				(gContMusic number: (SoundFX 61) loop: -1 play:)
				(= seconds 5)
			)
			(3
				(local16 dispose:)
				(local12 dispose:)
				(local14 dispose:)
				(byBy hide:)
				(andAnd dispose:)
				(= seconds 1)
			)
			(4
				((= local17 (View new:))
					view: 902
					loop: 0
					cel: 4
					posn: 157 28
					init:
					stopUpd:
				)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(5
				((= local18 (View new:))
					view: 902
					loop: 1
					cel: 1
					posn: 158 80
					init:
					stopUpd:
				)
				((= local19 (View new:))
					view: 902
					loop: 1
					cel: 2
					posn: 158 107
					init:
					stopUpd:
				)
				((= local20 (View new:))
					view: 902
					loop: 3
					cel: 2
					posn: 158 134
					init:
					stopUpd:
				)
				((= local21 (View new:))
					view: 902
					loop: 3
					cel: 3
					posn: 158 161
					init:
					stopUpd:
				)
				(= seconds 11)
			)
			(6
				(local17 dispose:)
				(local18 dispose:)
				(local19 dispose:)
				(local20 dispose:)
				(local21 dispose:)
				(= seconds 1)
			)
			(7
				((= local22 (View new:))
					view: 902
					loop: 0
					cel: 5
					posn: 143 18
					init:
					stopUpd:
				)
				(byBy loop: 3 cel: 0 posn: 201 18 show:)
				((= local23 (View new:))
					view: 902
					loop: 0
					cel: 6
					posn: 124 36
					init:
					stopUpd:
				)
				((= local24 (View new:))
					view: 902
					loop: 0
					cel: 7
					posn: 211 36
					init:
					stopUpd:
				)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(8
				((= local27 (View new:))
					view: 902
					loop: 1
					cel: 3
					posn: 158 80
					init:
					stopUpd:
				)
				((= local28 (View new:))
					view: 902
					loop: 3
					cel: 1
					posn: 158 107
					init:
					stopUpd:
				)
				((= local25 (View new:))
					view: 902
					loop: 1
					cel: 4
					posn: 158 134
					init:
					stopUpd:
				)
				((= local26 (View new:))
					view: 902
					loop: 5
					cel: 2
					posn: 158 161
					init:
					stopUpd:
				)
				(= seconds 9)
			)
			(9
				(local22 dispose:)
				(local23 dispose:)
				(local24 dispose:)
				(byBy hide:)
				(local27 dispose:)
				(local25 dispose:)
				(local26 dispose:)
				(local28 dispose:)
				(= seconds 1)
			)
			(10
				((= local29 (View new:))
					view: 902
					loop: 5
					cel: 0
					posn: 156 21
					init:
					stopUpd:
				)
				(byBy loop: 0 cel: 1 posn: 156 36 show:)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(11
				((= local30 (View new:))
					view: 902
					loop: 5
					cel: 1
					posn: 159 98
					init:
					stopUpd:
				)
				(= seconds 7)
			)
			(12
				(local29 dispose:)
				(byBy hide:)
				(local30 dispose:)
				(= seconds 1)
			)
			(13
				((= local31 (View new:))
					view: 902
					loop: 0
					cel: 8
					posn: 99 22
					init:
					stopUpd:
				)
				((= local32 (View new:))
					view: 902
					loop: 0
					cel: 9
					posn: 180 22
					init:
					stopUpd:
				)
				((= local33 (View new:))
					view: 902
					loop: 0
					cel: 10
					posn: 156 37
					init:
					stopUpd:
				)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(14
				((= local35 (View new:))
					view: 902
					loop: 2
					cel: 0
					posn: 157 76
					init:
					stopUpd:
				)
				((= local34 (View new:))
					view: 902
					loop: 2
					cel: 1
					posn: 157 98
					init:
					stopUpd:
				)
				((= local36 (View new:))
					view: 902
					loop: 2
					cel: 2
					posn: 158 122
					init:
					stopUpd:
				)
				((= local37 (View new:))
					view: 902
					loop: 2
					cel: 3
					posn: 158 146
					init:
					stopUpd:
				)
				(= seconds 9)
			)
			(15
				(local31 dispose:)
				(local32 dispose:)
				(local33 dispose:)
				(local35 dispose:)
				(local34 dispose:)
				(local36 dispose:)
				(local37 dispose:)
				(= seconds 1)
			)
			(16
				((= local38 (View new:))
					view: 902
					loop: 0
					cel: 11
					posn: 157 23
					init:
					stopUpd:
				)
				(byBy loop: 0 cel: 1 posn: 156 40 show:)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(17
				((= local39 (View new:))
					view: 902
					loop: 4
					cel: 0
					posn: 106 81
					init:
					stopUpd:
				)
				((= local40 (View new:))
					view: 902
					loop: 4
					cel: 1
					posn: 159 98
					init:
					stopUpd:
				)
				((= local41 (View new:))
					view: 902
					loop: 4
					cel: 2
					posn: 211 116
					init:
					stopUpd:
				)
				(= seconds 9)
			)
			(18
				(local38 dispose:)
				(byBy dispose:)
				(local39 dispose:)
				(local40 dispose:)
				(local41 dispose:)
				(= seconds 1)
			)
			(19
				((= local42 (View new:))
					view: 902
					loop: 0
					cel: 12
					posn: 158 21
					init:
					stopUpd:
				)
				((= local43 (View new:))
					view: 902
					loop: 0
					cel: 13
					posn: 159 36
					init:
					stopUpd:
				)
				(if (== gHowFast 0)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(20
				((= local44 (View new:))
					view: 902
					loop: 4
					cel: 3
					posn: 159 98
					init:
					stopUpd:
				)
				(= seconds 10)
			)
			(21
				(localproc_0)
			)
		)
	)
)

(instance claw1 of Prop
	(properties
		y 92
		x 51
		view 906
		priority 3
	)
)

(instance claw2 of Prop
	(properties
		y 87
		x 127
		view 906
		loop 1
		cel 1
		priority 3
	)
)

(instance head of Prop
	(properties
		y 49
		x 87
		view 906
		loop 2
	)
)

(instance flame of Act
	(properties
		view 907
	)
)

(instance sierraText of Prop
	(properties
		y 168
		x 128
		view 908
		priority 12
	)
)

(instance presentsText of Prop
	(properties
		y 182
		x 130
		view 908
		loop 1
		priority 12
	)
)

(instance questText of Act
	(properties
		y 160
		x 150
		view 918
	)
)

(instance quest2Text of Act
	(properties
		y 37
		x 76
		view 919
		illegalBits 0
	)
)

(instance forText of Act
	(properties
		y 160
		x 150
		view 918
		loop 1
	)
)

(instance for2Text of Act
	(properties
		y 59
		x 150
		view 919
		loop 1
		illegalBits 0
	)
)

(instance gloryText of Act
	(properties
		y 160
		x 150
		view 918
		loop 2
		priority 12
	)
)

(instance glory2Text of Act
	(properties
		y 99
		x 243
		view 919
		loop 2
		illegalBits 0
	)
)

(instance titleSpell of Act
	(properties
		view 913
	)
)

(instance titleSpell2 of Act
	(properties
		view 913
	)
)

(instance soYou of View
	(properties
		y 160
		x 50
		view 913
		loop 1
		priority 7
	)
)

(instance want of View
	(properties
		y 160
		x 127
		view 913
		loop 1
		cel 1
		priority 7
	)
)

(instance toBeA of View
	(properties
		y 160
		x 209
		view 913
		loop 1
		cel 2
		priority 7
	)
)

(instance heroWord of View
	(properties
		y 160
		x 286
		view 913
		loop 1
		cel 3
		priority 7
	)
)

(instance introMusic of Sound
	(properties
		number 1
	)
)

(instance saurus of Act
	(properties
		y 137
		x -20
		yStep 4
		view 430
		xStep 6
	)
)

(instance aHero of Act
	(properties
		y 137
		x -80
		yStep 4
		view 5
		xStep 7
	)
)

(instance dragonHead of Prop
	(properties
		y 118
		x 170
		view 462
	)
)

(instance dragonTail of Prop
	(properties
		y 121
		x 87
		view 462
		loop 1
		priority 8
	)
)

(instance drTailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= state -1)
				(client setCycle: Beg self)
			)
		)
	)
)

(instance leftDrag of View
	(properties)
)

(instance rightDrag of View
	(properties)
)

(instance andAnd of View
	(properties)
)

(instance byBy of View
	(properties)
)

