;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use Sound)
(use Actor)
(use System)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	proc11_3 3
	proc11_4 4
	EgoDead 5
	proc11_6 6
	proc11_7 7
	proc11_8 8
)

(local
	local0
	local1
)

(procedure (IsFlag param1 param2 &tmp temp0)
	(= temp0 (& [global127 (/ param1 16)] (>> $8000 (mod param1 16))))
	(if (not param2)
		(return temp0)
	else
		(return temp0)
	)
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(= [global127 (/ param1 16)]
		(| [global127 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global127 (/ param1 16)]
		(& [global127 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc11_3 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (not (> argc 3))
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 temp3)
)

(procedure (proc11_4 &tmp temp0 temp1) ; UNUSED
	(= temp0 (Print new:))
	(temp0 x: 85 y: 32 margin: 0)
	((temp0 addIcon: 952 0 0 0 0) state: 0)
	((temp0 addIcon: 952 1 0 6 100) value: 1 state: 3)
	((temp0 addIcon: 952 2 0 101 100) value: 0 state: 3)
	((temp0 dialog:) mouseHiliting: 1)
	(= temp1 (temp0 init:))
)

(procedure (proc11_6 param1 param2 param3 &tmp temp0 temp1 temp2)
	(switch argc
		(0
			(if (gCurRoom inset:)
				(= temp1 15)
				(= temp2 10)
			)
		)
		(1
			(= temp1 15)
			(= temp2 10)
		)
		(2
			(= temp1 param2)
			(= temp2 10)
		)
		(3
			(= temp1 param2)
			(= temp2 param3)
		)
	)
	(global123 eachElementDo: #perform disableHotCode)
	(= temp0 (ExitButton new:))
	(temp0
		view: 984
		loop: 0
		cel: 0
		posn: temp1 temp2
		roomNum: param1
		disposeNow: 0
		code: 0
		init:
		setHotspot: 0 10 8 ; Exit, Do
	)
)

(procedure (proc11_7 param1 &tmp temp0 temp1)
	(= temp0 (FirstNode (global123 elements:)))
	(while temp0
		(if ((= temp1 (NodeValue temp0)) isKindOf: ExitButton)
			(break)
		else
			(= temp0 (NextNode temp0))
		)
	)
	(temp1 code: param1)
)

(procedure (EgoDead param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18)
	(= temp7 (= temp8 (= temp9 (= temp10 0))))
	(if
		(and
			(OneOf
				gCurRoomNum
				4350
				4400
				4050
				4000
				4101
				4102
				4200
				4250
				4300
				4600
				4500
				4550
				4650
				4450
				4700
			)
			(not (OneOf param1 57 19))
			(gCast contains: (= temp7 (ScriptID 4001 3))) ; myBoogeyMan
		)
		(temp7 dispose:)
		((ScriptID 4001 0) setScript: 0) ; OogaBooga
	)
	(= temp5 0)
	(= temp1 gCast)
	((= gPlane (Plane new:))
		setRect: 0 0 319 (gThePlane bottom:)
		back: 0
		picture: -1
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(SetFlag 5)
	(if (gKqMusic1 handle:)
		(gKqMusic1 stop:)
		(= temp13 1)
	else
		(= temp13 0)
	)
	(gSounds eachElementDo: #pause 1)
	(deathSong init: number: 800 setLoop: 1 play: setVol: 0 fade: 127 10 20 0)
	((= temp0 (Prop new:))
		view:
			(if (== gValOrRoz -3) ; Roz
				(if (IsFlag 55) 912 else 913)
			else
				911
			)
		loop: 0
		cel: 0
		x:
			(if (== gValOrRoz -3) ; Roz
				(if (IsFlag 55) 103 else 126)
			else
				121
			)
		y: (if (and (== gValOrRoz -3) (not (IsFlag 55))) 106 else 111) ; Roz
		z: 0
		scaleSignal: 0
		init:
	)
	(= temp11 ((ScriptID 13 0) client:)) ; aEgoTalker
	(= temp14 ((ScriptID 13 0) view:)) ; aEgoTalker
	(= temp15 ((ScriptID 13 0) loop:)) ; aEgoTalker
	(= temp16 ((ScriptID 13 0) mouth_x:)) ; aEgoTalker
	(= temp17 ((ScriptID 13 0) mouth_y:)) ; aEgoTalker
	(= temp18 ((ScriptID 13 0) hide_mouth:)) ; aEgoTalker
	((ScriptID 13 0) ; aEgoTalker
		client: temp0
		view: (temp0 view:)
		loop: -1
		mouth_x: -999
		mouth_y: -999
		hide_mouth: 0
	)
	((Prop new:) view: 982 loop: 0 cel: 0 x: 80 y: 52 init:)
	((= temp3 (View new:)) view: 982 loop: 1 cel: 0 x: 151 y: 93 init:)
	((= temp4 (View new:)) view: 982 loop: 2 cel: 0 x: 204 y: 93 init:)
	(FrameOut)
	(switch param1
		(70
			(gMessager say: 0 0 80 0 0 30) ; "I just sat there and let those--THINGS come in and get me! I'll never do that again. I'll find someway to stop them!"
		)
		(1
			(if (== gValOrRoz -4) ; Val
				(gMessager say: 0 0 1 0 0 30) ; "Hmph. Wandering through the desert got me nowhere fast."
			else
				(gMessager say: 0 0 42 0 0 30) ; "I guess going for a long walk in the desert wasn't such a good idea."
			)
		)
		(2
			(gMessager say: 0 0 4 0 0 30) ; "Oh dear. I suppose you can't just take things out of an offering bowl."
		)
		(3
			(gMessager say: 0 0 2 0 0 30) ; "I've got to find a way to get rid of that horrible thing--or at least distract it for a while."
		)
		(4
			(gMessager say: 0 0 3 0 0 30) ; "I guess I just took too long in there."
		)
		(5
			(gMessager say: 0 0 6 0 0 30) ; "Well, Valanice, drinking a pot full of salt water wasn't the smartest thing you've ever done."
		)
		(6
			(gMessager say: 0 0 5 0 0 30) ; "Drinking that water didn't help me for long, did it. This desert is treacherous!"
		)
		(7
			(gMessager say: 0 0 49 0 0 30) ; "SHE'S not very hospitable, is she."
		)
		(8
			(gMessager say: 0 0 38 0 0 30) ; "Well, that'll teach me to be a slowpoke."
		)
		(9
			(gMessager say: 0 0 37 0 0 30) ; "That darned little dog! His nose is just too sharp!"
		)
		(10
			(gMessager say: 0 0 62 0 0 30) ; "That horrid little creature! I wish I could think of a way to distract him!"
		)
		(11
			(gMessager say: 0 0 36 0 0 30) ; "Oh, that was brilliant, Rosella! Next time, we HIDE from the nasty faerie!"
		)
		(12
			(gMessager say: 0 0 61 0 0 30) ; "I hate to hide like a mouse...but I guess sometimes that's the only thing you can do."
		)
		(13
			(gMessager say: 0 0 28 0 0 30) ; "I'll never trust foliage again!"
		)
		(14
			(gMessager say: 0 0 10 0 0 30) ; "Very good, Rosella. Now you know that carts with three wheels don't go in a straight line. Sheesh."
		)
		(15
			(gMessager say: 0 0 11 0 0 30) ; "You know, using that shield was a darned good idea. If only I'd attached it to the cart somehow!"
		)
		(16
			(gMessager say: 0 0 29 0 0 30) ; "Geez. These Ooga Boogites sure aren't very trustworthy!"
		)
		(17
			(gMessager say: 0 0 30 0 0 30) ; "Those nasty little guys are keeping me on my toes, that's for sure! I need to think fast around them!"
		)
		(18
			(gMessager say: 0 0 56 0 0 30) ; "I'm just not good at this sneaking around business. I suppose I should have taken less time in there."
		)
		(19
			(if
				(or
					(IsFlag 557)
					(and
						(== gCurRoomNum 4650)
						(== gValOrRoz -3) ; Roz
						(not (IsFlag 151))
					)
				)
				(gMessager say: 0 0 23 0 0 30) ; "I should have listened to King Otar. It really isn't safe for me to be seen around here."
			else
				(gMessager say: 0 0 22 0 0 30) ; "That guy is bad news! Next time, I'm not waiting to find out just HOW bad!"
			)
		)
		(20
			(gMessager say: 0 0 26 0 0 30) ; "Hmmph. I guess I should have read the headstone more carefully."
		)
		(21
			(gMessager say: 0 0 54 0 0 30) ; "Oh dear. I think I should have paid attention to that epitaph."
		)
		(22
			(gMessager say: 0 0 25 0 0 30) ; "I can't BELIEVE I did that. My mother taught me to have better sense!"
		)
		(23
			(gMessager say: 0 0 53 0 0 30) ; "I have NO idea why I did that. (SIGH)"
		)
		(24
			(gMessager say: 0 0 18 0 0 30) ; "What could I have been thinking? I'm not a fish!"
		)
		(25
			(gMessager say: 0 0 19 0 0 30) ; "Well, that'll teach me to go slogging through the mud. I'll never do THAT again."
		)
		(26
			(gMessager say: 0 0 31 0 0 30) ; "Oh boy. I THOUGHT that looked like a spider web."
		)
		(27
			(gMessager say: 0 0 57 0 0 30) ; "Oh boy. I should be more careful around big spiders."
		)
		(28
			(gMessager say: 0 0 32 0 0 30) ; "That was awful! I should have DONE something!"
		)
		(29
			(gMessager say: 0 0 34 0 0 30) ; "How did that gargoyle find us so fast? I guess I should have kept the troll king disguised!"
		)
		(30
			(gMessager say: 0 0 27 0 0 30) ; "I think it's going to take drastic measures to get past that nasty thing."
		)
		(31
			(gMessager say: 0 0 35 0 0 30) ; "I HATE that gargoyle! Maybe I'd just better stay away from it!"
		)
		(32
			(gMessager say: 0 0 52 0 0 30) ; "My goodness! Could she ever use a facial!"
		)
		(33
			(gMessager say: 0 0 24 0 0 30) ; "Yikes! I guess some people just like to be left alone!"
		)
		(35
			(gMessager say: 0 0 58 0 0 30) ; "Hmm. It would seem that keeping a lit firecracker in one's pocket isn't the best course of action..."
		)
		(34
			(gMessager say: 0 0 59 0 0 30) ; "Now I know how it feels to be a rabbit in the carriage lights! I should have done something decisive."
		)
		(36
			(gMessager say: 0 0 21 0 0 30) ; "That'll teach me to look a gift shovel in the mouth."
		)
		(37
			(gMessager say: 0 0 69 0 0 30) ; "Hmmph. Next time, I'm staying close to the wall!"
		)
		(38
			(gMessager say: 0 0 70 0 0 30) ; "That's obviously not a safe place to stay. I should have gotten out of there, and fast!"
		)
		(39
			(gMessager say: 0 0 14 0 0 30) ; "Oh, blast. I suppose I should have done something to take that beast's attention away from me."
		)
		(40
			(gMessager say: 0 0 71 0 0 30) ; "(SIGH)I fought the lava and the lava won. I just should have moved faster."
		)
		(41
			(gMessager say: 0 0 15 0 0 30) ; "What an unfriendly creature! I'll never be able to get past him...unless I do something drastic."
		)
		(42
			(gMessager say: 0 0 39 0 0 30) ; "That's one tough guy! I need something that could knock him for a loop!"
		)
		(43
			(gMessager say: 0 0 68 0 0 30) ; "Drat it. I just should have been more decisive."
		)
		(44
			(gMessager say: 0 0 73 0 0 30) ; "I should have used that magical device when I had the chance."
		)
		(45
			(gMessager say: 0 0 20 0 0 30) ; "That was the loudest bird I've ever met! I have to find a way to get it to trust me."
		)
		(46
			(gMessager say: 0 0 9 0 0 30) ; "That troll won't be reasoned with. I think something else is in order!"
		)
		(47
			(gMessager say: 0 0 65 0 0 30) ; "I know the Dream Weaver told me something important about those horrible creatures. What did he say...?"
		)
		(48
			(gMessager say: 0 0 45 0 0 30) ; "I'm getting awfully sick of that creature. I'd like to scare him off for good!"
		)
		(49
			(gMessager say: 0 0 47 0 0 30) ; "I'm never going to get past that thing if I don't get some help."
		)
		(50
			(gMessager say: 0 0 66 0 0 30) ; "Well, I NEVER! Some people are so RUDE!"
		)
		(51
			(gMessager say: 0 0 63 0 0 30) ; "What a hideous beast! I could use some advice on how to avoid that thing."
		)
		(52
			(gMessager say: 0 0 64 0 0 30) ; "The Fates were serious when they told me I would need that strange device. I should have listened to them."
		)
		(53
			(gMessager say: 0 0 65 0 0 30) ; "I know the Dream Weaver told me something important about those horrible creatures. What did he say...?"
		)
		(54
			(if (== gValOrRoz -3) ; Roz
				(gMessager say: 0 0 35 0 0 30) ; "I HATE that gargoyle! Maybe I'd just better stay away from it!"
			else
				(gMessager say: 0 0 78 0 0 30) ; "I hate to admit it, but I think the direct approach isn't the best one around here.""
			)
		)
		(55
			(gMessager say: 0 0 48 0 0 30) ; "I knew I shouldn't have trusted that fellow."
		)
		(56
			(gMessager say: 0 0 36 0 0 30) ; "Oh, that was brilliant, Rosella! Next time, we HIDE from the nasty faerie!"
		)
		(57
			(gMessager say: 0 0 60 1 0 30) ; "Now THERE'S an unpleasant fellow. I'm staying out of his way from now on."
		)
		(58
			(gMessager say: 0 0 32 0 0 30) ; "That was awful! I should have DONE something!"
		)
		(59
			(gMessager say: 0 0 51 0 0 30) ; "Yikes! I can't believe I got attacked by a pile of cranky sticks!"
		)
		(61
			(gMessager say: 0 0 7 0 0 30) ; "Ooooh! I can't believe I ate BUGS! I'll never do THAT again!"
		)
		(60
			(gMessager say: 0 0 8 0 0 30) ; "I guess I got a little too close to the edge."
		)
		(62
			(gMessager say: 0 0 12 0 0 30) ; "(SIGHS)Father always told me to let sleeping dragons lie--or at least stay out of the way of their tails!"
		)
		(63
			(gMessager say: 0 0 15 0 0 30) ; "What an unfriendly creature! I'll never be able to get past him...unless I do something drastic."
		)
		(64
			(gMessager say: 0 0 68 0 0 30) ; "Drat it. I just should have been more decisive."
		)
		(66
			(gMessager say: 0 0 55 0 0 30) ; "Those dreadful little urchins! I'd best stay out of their way until they learn some manners!"
		)
		(67
			(gMessager say: 0 0 76 0 0 30) ; "I knew there was a reason I always hated those things as a child."
		)
		(68
			(gMessager say: 0 0 77 0 0 30) ; "I'm NEVER giving one of those things to my children. Never, ever, ever!"
		)
		(65
			(gMessager say: 0 0 22 0 0 30) ; "That guy is bad news! Next time, I'm not waiting to find out just HOW bad!"
		)
		(69
			(gMessager say: 0 0 79 0 0 30) ; "That current is STRONG! I think I'd better find another way to cross the river."
		)
		(71
			(gMessager say: 0 0 67 0 0 30) ; "...Oops..."
		)
		(72
			(gMessager say: 0 0 39 1 0 30) ; "That's one tough guy! I need something that could knock him for a loop!"
		)
		(73
			(gMessager say: 0 0 40 1 0 30) ; "I still think that was a pretty good idea...if only the pellet had some more force behind it. Hmmm..."
		)
		(else 0)
	)
	(FrameOut)
	(while (and gTalkers (gTalkers size:))
		(= gGameTime (+ gTickOffset (GetTime)))
		(gTalkers
			eachElementDo: #doit
			firstTrue: #handleEvent ((gUser curEvent:) new:)
		)
		(gSounds eachElementDo: #check)
		(FrameOut)
	)
	(= local1 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(for
		((= temp2 ((gUser curEvent:) new:)))
		(temp2 type:)
		((= temp2 ((gUser curEvent:) new:)))
	)
	(while 1
		(while (or (not (temp2 type:)) (not (& (temp2 type:) $0001)))
			(cond
				((or (temp3 onMe: temp2) (temp4 onMe: temp2))
					(if (or (> (= temp7 (- (GetTime) temp8)) 5) (not temp9))
						(= temp8 (GetTime))
						(= temp9 1)
						(if (> (++ temp10) 4)
							(= temp10 0)
						)
						(gNormalCursor cel: temp10)
						(gGame setCursor: gNormalCursor 1)
					)
				)
				((gNormalCursor cel:)
					(gNormalCursor cel: 0)
					(gGame setCursor: gNormalCursor 1)
				)
			)
			(= temp2 ((gUser curEvent:) new:))
		)
		(cond
			((temp3 onMe: temp2)
				(= temp2 ((gUser curEvent:) new:))
				(while (not (temp2 type:))
					(= temp2 ((gUser curEvent:) new:))
					(cond
						((temp3 onMe: temp2)
							(if
								(or
									(> (= temp7 (- (GetTime) temp8)) 5)
									(not temp9)
								)
								(= temp8 (GetTime))
								(= temp9 1)
								(if (> (++ temp10) 4)
									(= temp10 0)
								)
								(gNormalCursor cel: temp10)
								(gGame setCursor: gNormalCursor 1)
							)
							(if (not (temp3 cel:))
								(temp3 cel: 1)
								(UpdateScreenItem temp3)
								(FrameOut)
							)
						)
						((temp3 cel:)
							(temp3 cel: 0)
							(UpdateScreenItem temp3)
							(FrameOut)
						)
					)
				)
				(cond
					((temp3 onMe: temp2)
						(break)
					)
					((temp3 cel:)
						(gNormalCursor cel: 0)
						(gGame setCursor: gNormalCursor 1)
						(temp3 cel: 0)
						(UpdateScreenItem temp3)
						(FrameOut)
					)
				)
			)
			((temp4 onMe: temp2)
				(= temp2 ((gUser curEvent:) new:))
				(while (not (temp2 type:))
					(= temp2 ((gUser curEvent:) new:))
					(cond
						((temp4 onMe: temp2)
							(if
								(or
									(> (= temp7 (- (GetTime) temp8)) 5)
									(not temp9)
								)
								(= temp8 (GetTime))
								(= temp9 1)
								(if (> (++ temp10) 4)
									(= temp10 0)
								)
								(gNormalCursor cel: temp10)
								(gGame setCursor: gNormalCursor 1)
							)
							(if (not (temp4 cel:))
								(temp4 cel: 1)
								(UpdateScreenItem temp4)
								(FrameOut)
							)
						)
						((temp4 cel:)
							(gNormalCursor cel: 0)
							(gGame setCursor: gNormalCursor 1)
							(temp4 cel: 0)
							(UpdateScreenItem temp4)
							(FrameOut)
						)
					)
				)
				(cond
					((temp4 onMe: temp2)
						(= temp5 1)
						(break)
					)
					((temp4 cel:)
						(temp4 cel: 0)
						(UpdateScreenItem temp4)
						(FrameOut)
					)
				)
			)
		)
		(gNormalCursor cel: 0)
		(gGame setCursor: gNormalCursor 1)
		(= temp2 ((gUser curEvent:) new:))
	)
	((ScriptID 13 0) ; aEgoTalker
		client: temp11
		view: temp14
		loop: temp15
		mouth_x: temp16
		mouth_y: temp17
		hide_mouth: temp18
	)
	(deathSong dispose:)
	(gSounds eachElementDo: #pause 0)
	(cond
		((or (and (> argc 2) param3) temp5) 1)
		(temp13
			(gKqMusic1 play:)
		)
	)
	(if (gEgo has: 74) ; Firecracker
		((ScriptID 4001 6) setCycle: (ScriptID 4001 6) 12000) ; firecrackerTimer, firecrackerTimer
	)
	(gCast dispose:)
	(= gCast temp1)
	(if (gCast contains: gEgo)
		(gEgo show:)
	)
	(if global308
		(global308 show:)
		(= global308 0)
		(gUser message: (gUser dftMessage:))
	)
	(if (or (== local1 gNormalCursor) (== local1 gWaitCursor))
		(gGame oldCurs: gNormalCursor setCursor: local1 1)
	else
		(= gTheCursor gNormalCursor)
		(gGame setCursor: gNormalCursor 1)
	)
	(if temp5
		(if param2
			(param2 cue: param1)
		)
		(SetFlag 561)
	else
		(gPlane dispose:)
		(if param2
			(param2 cue: param1)
		)
	)
)

(procedure (proc11_8 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

(instance deathSong of Sound
	(properties)
)

(class ExitButton of View
	(properties
		x 15
		y 10
		view 989
		disposeNow 0
		roomNum 0
		code 0
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(or
				global308
				(== gTheCursor gTheUseObjCursor)
				(not (self onMe: event))
				(not (event type:))
				(not (gUser input:))
			)
			(super handleEvent: event)
			(return)
		)
		(= temp1 0)
		(while 1
			(= temp0 ((gUser curEvent:) new:))
			(temp0 localize: gThePlane)
			(cond
				((== (temp0 type:) 2)
					(break)
				)
				((self onMe: temp0)
					(= temp1 (= cel 1))
					(UpdateScreenItem self)
				)
				(else
					(= temp1 (= cel 0))
					(UpdateScreenItem self)
				)
			)
			(FrameOut)
			(temp0 dispose:)
		)
		(= cel 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(event claimed: 1)
			(self doVerb:)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if disposeNow
			(if (gCurRoom inset:)
				(SetFlag 551)
			else
				(gCurRoom newRoom: roomNum)
			)
		)
	)

	(method (doVerb)
		(if code
			(code doit:)
		else
			(= disposeNow 1)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance disableHotCode of Code
	(properties)

	(method (doit param1)
		(if (and (param1 scratch:) (param1 respondsTo: #exitDir))
			(param1 setHotspot: 0)
		)
	)
)

