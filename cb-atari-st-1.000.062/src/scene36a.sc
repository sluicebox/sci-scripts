;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene36a 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local2 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(puff cel: 0 setCycle: End show:)
	(localproc_0 &rest)
	(+= local2 (/ local2 4))
	(glorMouth setScript: cycleMouth)
	(Print &rest #at 160 120 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_2)
	(puff hide:)
	(localproc_0 &rest)
	(rudyMouth setScript: cycleMouth)
	(Print &rest #at 20 120 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_3)
	(|= gSpyFlags $0001)
	(= [gCycleTimers 0] 0)
	(= [gCycleTimers 2] 1800)
	(SetFlag 23)
	(SetFlag 24)
)

(instance scene36a of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(if (not (& gSpyFlags $0001))
			(if (== [gCycleTimers 0] 1)
				(localproc_3)
				(= global199 1)
			else
				(Load rsFONT 41)
				(LoadMany rsMESSAGE 406)
				(Load rsVIEW 642)
				(LoadMany rsSOUND 29 94 95 96)
				(Rudy setPri: 1 init: stopUpd:)
				(rudyMouth setPri: 2 init: hide:)
				(rudyEye setPri: 2 init: stopUpd: setScript: RudysEyes)
				(self setScript: speech36a)
			)
		)
		(if (== global199 1)
			(self setScript: noOne)
		else
			(Smoke setLoop: 4 setPri: 2 ignoreActors: 1 init: stopUpd: hide:)
			(glow init: stopUpd: hide:)
			(glorMouth setPri: 2 init:)
			(glorEye setPri: 2 init: stopUpd: setScript: GlorsEyes)
			(Gloria setPri: 1 init:)
			(puff setPri: 1 init: hide:)
			(Hand setLoop: 1 setCel: 0 setPri: 3 ignoreActors: 1 init: stopUpd:)
			(if (& gSpyFlags $0001)
				(self setScript: twice)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance RudysEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rudyEye setLoop: 8 setCel: 0 forceUpd:)
				(= seconds (Random 1 3))
			)
			(1
				(if (and (not local1) (== (Random 1 2) 1))
					(rudyEye setLoop: 7 setCel: 1 forceUpd:)
					(= local1 1)
					(= cycles 1)
				else
					(rudyEye setLoop: 8 setCel: 1 forceUpd:)
					(= local1 0)
					(= seconds (Random 1 3))
				)
				(= state -1)
			)
		)
	)
)

(instance GlorsEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(glorEye setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech36a of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(if (not (& gSpyFlags $0001))
				(localproc_3)
			)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (>= state 1)
			(cond
				((and (== (mod state 2) 0) state (!= state 12))
					(= local0 0)
					(glorMouth loop: 3 cycleSpeed: 0)
					(Hand setMotion: MoveTo 167 111)
					(glow hide:)
					(if (and (== (Hand x:) 167) (== (Hand y:) 111))
						(Smoke posn: 148 89 show: setCycle: Fwd)
					)
				)
				((and (== (Hand x:) 186) (== (Hand y:) 111) (== local0 0))
					(= local0 1)
					(glow show:)
					(glorMouth loop: 2 cycleSpeed: 3 setCycle: Fwd show:)
					(Smoke hide:)
				)
				((not local0)
					(Hand setMotion: MoveTo 186 111)
					(Smoke setMotion: MoveTo 169 89)
					(glorMouth setCycle: End)
				)
			)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local3 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0001))
							(|= gMustDos $0001)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
					(= cycles 1)
				)
				(1
					(= local4
						(Display 321 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_2 321 1) ; "What a skinflint Uncle Henri is. Man, what I could do with his dough!"
					(= seconds 10)
				)
				(2
					(localproc_1 321 2) ; "How rich is he, dahling?"
					(= seconds 4)
				)
				(3
					(localproc_2 321 3) ; "Don't know for sure. At least a couple mil."
					(= seconds 7)
				)
				(4
					(localproc_1 321 4) ; "If he's so rich, why doesn't he keep this place up better? It's such a dump."
					(= seconds 10)
				)
				(5
					(localproc_2 321 5) ; "The old miser wouldn't part with a penny if he could help it. I wonder if Fifi's getting any of his money, though."
					(= seconds 8)
				)
				(6
					(localproc_1 321 6) ; "I bet she's trying to, anyway. Why, she practically has him wound around her little finger. Dahling, it's disgusting!"
					(= seconds 10)
				)
				(7
					(localproc_2 321 7) ; "Speaking of disgusting, what are you going to do about Clarence?"
					(= seconds 8)
				)
				(8
					(localproc_1 321 8) ; "Oh, HIM. I've decided to break up with Clarence. I have a new beau, a director, no less. He's such a doll!"
					(= seconds 10)
				)
				(9
					(localproc_2 321 9) ; "Clarence isn't going to like it when you break it off. I don't trust him at all, the snake!"
					(= seconds 8)
				)
				(10
					(localproc_1 321 10) ; "Oh, dahling, that reminds me! Remember that little medical problem I had? I don't trust Wilbur to keep it quiet. It could ruin my career if it got out! I've got to talk to him."
					(= seconds 10)
				)
				(11
					(localproc_2 321 11) ; "You do that, my dear sister. As for me, I'm going to retire to my room for awhile. Kiss, kiss."
					(= seconds 8)
				)
				(12
					(cls)
					(Rudy
						setLoop: 1
						setStep: 5 5
						setMotion: MoveTo -40 (Rudy y:) self
					)
					(rudyEye hide:)
				)
				(13
					(localproc_3)
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Smoke posn: 148 89 show: setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(if (== global199 2)
					(Print 321 12 #dispose) ; "It's just Gloria listening to the Victrola."
				else
					(Print 321 13 #dispose) ; "Gloria is alone in the billiard room."
				)
				(= seconds 4)
			)
			(2
				(cls)
				(Smoke setMotion: MoveTo 169 89)
				(Hand setMotion: MoveTo 186 111 self)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance noOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 321 14 #at 65 67 #dispose) ; "There is nothing of interest in the billiard room."
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local3
			(= local3 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local2)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Gloria of Prop
	(properties
		y 110
		x 231
		view 367
		signal 16384
	)
)

(instance Rudy of Act
	(properties
		y 111
		x 97
		view 391
	)
)

(instance Smoke of Act
	(properties
		y 89
		x 148
		yStep 5
		view 367
		xStep 5
	)
)

(instance rudyMouth of Prop
	(properties
		y 95
		x 106
		view 391
		loop 2
	)
)

(instance glorMouth of Prop
	(properties
		y 96
		x 211
		view 367
		loop 3
	)
)

(instance rudyEye of Prop
	(properties
		y 72
		x 106
		view 391
		loop 8
	)
)

(instance glorEye of Prop
	(properties
		y 76
		x 204
		view 367
		loop 7
	)
)

(instance glow of Prop
	(properties
		y 89
		x 170
		view 367
		loop 1
		cel 1
	)
)

(instance puff of Prop
	(properties
		y 88
		x 196
		view 367
		loop 8
		signal 16384
	)
)

(instance Hand of Act
	(properties
		y 111
		x 167
		yStep 5
		view 367
		xStep 5
	)
)

(instance myMusic of Sound
	(properties)
)

