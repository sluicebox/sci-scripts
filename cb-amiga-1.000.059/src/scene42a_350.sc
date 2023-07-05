;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene42a 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local0 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1 param1)
	(if (= local4 param1)
		(coloEyes hide:)
	else
		(coloEyes show:)
	)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(fifiMouth setScript: cycleMouth)
	(Print &rest #at 160 115 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_3)
	(localproc_0 &rest)
	(+= local0 (/ local0 4))
	(coloMouth setScript: cycleMouth)
	(Print &rest #at 20 115 #font 4 #width 140 #mode 1 #dispose)
)

(instance Fifi of Act
	(properties)
)

(instance Smoke of Act
	(properties)
)

(instance fifiMouth of Prop
	(properties)
)

(instance Colonel of Prop
	(properties)
)

(instance coloFace of Prop
	(properties)
)

(instance coloMouth of Prop
	(properties)
)

(instance coloEyes of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene42a of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(if (and (not (& gSpyFlags $0040)) (!= [gCycleTimers 3] 1))
			(|= gSpyFlags $0040)
			(= global124 1)
			(Load rsFONT 41)
			(LoadMany rsMESSAGE 406)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 94 95 96 29)
			(coloEyes
				view: 303
				loop: 4
				cel: 0
				posn: 147 80
				setPri: 5
				cycleSpeed: 2
				init:
				hide:
			)
			(coloMouth
				view: 303
				loop: 3
				cel: 0
				posn: 145 88
				setPri: 2
				init:
				hide:
			)
			(coloFace
				view: 303
				loop: 5
				cel: 0
				posn: 146 88
				setPri: 3
				cycleSpeed: 1
				init:
				hide:
			)
			(Colonel
				view: 305
				posn: 140 102
				loop: 2
				cel: 0
				setPri: 1
				cycleSpeed: 1
				ignoreActors: 1
				init:
			)
			(Fifi
				view: 305
				loop: 0
				cel: 0
				posn: 162 102
				setPri: 3
				cycleSpeed: 2
				init:
			)
			(fifiMouth
				view: 303
				loop: 2
				cel: 0
				posn: 173 85
				cycleSpeed: 1
				setPri: 4
				init:
				hide:
			)
			(self setScript: speech42a)
		else
			(Colonel
				view: 311
				posn: 101 105
				loop: 1
				cel: 0
				setPri: 1
				init:
				stopUpd:
			)
			(coloFace
				view: 311
				posn: 114 88
				loop: 0
				cel: 0
				setPri: 2
				init:
				stopUpd:
			)
			(coloEyes
				view: 311
				posn: 114 (- (coloFace y:) 15)
				loop: 2
				cel: 0
				setPri: 3
				setScript: ColoEyes
				init:
				stopUpd:
			)
			(coloMouth
				view: 311
				posn: 114 88
				loop: 4
				cel: 0
				setPri: 2
				cycleSpeed: 1
				init:
				hide:
			)
			(= local3 Fifi)
			(local3
				view: 311
				posn: 128 136
				setLoop: 1
				setCel: 1
				setPri: 3
				moveSpeed: 1
				illegalBits: 0
				ignoreActors: 1
				init:
				hide:
			)
			(Smoke
				view: 311
				setLoop: 3
				setCycle: Walk
				setPri: 3
				illegalBits: 0
				ignoreActors: 1
				init:
				hide:
			)
			(self setScript: twice)
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

(instance speech42a of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(not script)
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not local4) (<= (-- local5) 0))
			(= local5 (Random 10 30))
			(if (coloEyes cycler:)
				(coloEyes setCycle: 0 hide:)
			else
				(coloEyes setCycle: Fwd show:)
			)
		)
		(if (== state 14)
			(cond
				((and (not (fifiMouth script:)) (not (Fifi mover:)))
					(Fifi view: 305 setLoop: 1 x: (+ (Fifi x:) 43))
					(Fifi
						setCel: (Fifi lastCel:)
						setCycle: Walk
						setMotion: MoveTo 325 102 self
					)
				)
				((> (Fifi x:) 245)
					(cls)
				)
			)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0008))
							(|= gMustDos $0008)
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
					(= local2
						(Display 350 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(Colonel setCycle: End)
					(Fifi setCycle: End self)
				)
				(2
					(localproc_1 0)
					(Colonel view: 303 loop: 1 cel: 0)
					(Fifi view: 303 loop: 0 cel: 0)
					(localproc_2 350 1) ; "Oh, mon ami, I find it difficult to refuse you. I am so attracted to you."
					(= seconds 7)
				)
				(3
					(localproc_1 1)
					(cls)
					(Colonel setCycle: End self)
				)
				(4
					(coloFace cel: 0 show: setCycle: End)
					(Fifi setCycle: End self)
				)
				(5
					(Fifi setCycle: Beg self)
					(coloFace hide:)
				)
				(6
					(Colonel setCycle: Beg self)
				)
				(7
					(localproc_1 0)
					(localproc_3 350 2) ; "Well, I WAS quite a blade in my younger days!"
					(= seconds 7)
				)
				(8
					(localproc_2 350 3) ; "Oh la la, I can tell, Henri, I can tell!"
					(= seconds 7)
				)
				(9
					(localproc_1 1)
					(cls)
					(Colonel setCycle: End self)
				)
				(10
					(coloFace cel: 0 show: setCycle: End)
					(Fifi setCycle: End self)
				)
				(11
					(Fifi setCycle: Beg self)
					(coloFace hide:)
				)
				(12
					(Colonel setCycle: Beg self)
				)
				(13
					(localproc_1 0)
					(localproc_3 350 4) ; "Ah, Fifi, my dear. I DO appreciate you, but you'd better leave now before we're noticed."
					(= seconds 10)
				)
				(14
					(Colonel stopUpd:)
					(localproc_2 350 5) ; "If you say so, Henri. Au revoir, mon cheri."
				)
				(15
					(++ gFifiState)
					(|= gSpyFlags $0040)
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local1
			(= local1 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local0)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance ColoEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state -1)
				(if (^= local4 $0001)
					(coloEyes hide:)
					(= seconds (Random 2 3))
				else
					(coloEyes cel: (/ (Random 1 29999) 10000) forceUpd: show:)
					(= cycles 3)
				)
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== (Smoke cel:) (- (NumCels Smoke) 1)))
			(Smoke hide:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 350 6 #dispose) ; "You see the Colonel sitting in his room."
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y:) 15) forceUpd:)
				(local3 show: setMotion: MoveTo 116 116 self)
			)
			(1
				(local3 stopUpd:)
				(coloMouth show: setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(coloMouth setCycle: End)
				(local3 setMotion: MoveTo 128 136 self)
			)
			(3
				(local3 hide:)
				(coloFace cel: 1 forceUpd:)
				(coloMouth hide:)
				(coloEyes y: (- (coloFace y:) 16) forceUpd:)
				(Smoke show: cel: 0 posn: 113 79 setMotion: MoveTo 128 101 self)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

