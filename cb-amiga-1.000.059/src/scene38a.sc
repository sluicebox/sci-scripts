;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene38a 0
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
	(if (< (= local2 (/ (StrLen @temp0) 2)) 20)
		(= local2 20)
	)
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(gertMouth setScript: cycleMouth)
	(Print &rest #at 140 110 #font 4 #width 160 #mode 1 #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(/= local2 2)
	(clarMouth setScript: cycleMouth)
	(Print &rest #at 10 110 #font 4 #width 160 #mode 1 #dispose)
)

(procedure (localproc_3)
	(|= gSpyFlags $0002)
	(= [gCycleTimers 1] 0)
	(++ global197)
	(SetFlag 16)
	(SetFlag 18)
	(SetFlag 21)
)

(instance scene38a of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(LoadMany rsFONT 4 41)
		(LoadMany rsMESSAGE 406)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 29 94 95 96)
		(HandsOff)
		(Clarence setPri: 1 init:)
		(clarMouth setPri: 2 init: hide:)
		(clarEye setLoop: 8 setPri: 2 init: stopUpd: setScript: ClarsEye)
		(Hand setLoop: 0 setCel: 1 setPri: 1 init:)
		(Smoke setPri: 2 init: hide:)
		(myMusic number: 27 loop: -1 play:)
		(if (not (& gSpyFlags $0002))
			(localproc_3)
			(if (!= [gCycleTimers 1] 1)
				(gertEye setPri: 2 init: stopUpd: setScript: GertsEye)
				(gertMouth setPri: 2 init: hide:)
				(Gertie setPri: 1 init:)
				(gertGlass setLoop: 3 setCel: 0 setPri: 3 ignoreActors: 1 init:)
			)
			(self setScript: speech38a)
		else
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

(instance ClarsEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clarEye cel: (^ (clarEye cel:) $0001) forceUpd:)
				(= state -1)
				(if (clarEye cel:)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance GertsEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gertEye cel: (^ (gertEye cel:) $0001) forceUpd:)
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance speech38a of Script
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
			(if (not (& gSpyFlags $0002))
				(localproc_3)
			)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (>= state 1)
			(if (== (mod state 2) 0)
				(gertGlass setMotion: MoveTo 222 118)
				(if (and (== (Hand x:) 122) (== (Hand y:) 135))
					(Smoke show: setCycle: End)
				)
				(Hand setMotion: MoveTo 122 135)
			else
				(gertGlass setMotion: MoveTo 246 138)
				(Hand setMotion: MoveTo 140 190)
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
						((not (& gMustDos $0002))
							(|= gMustDos $0002)
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
						(Display 301 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_2 301 1) ; "I've offered her a fair deal many times for her property along the river, but the old biddy won't sell! Soon she's gonna force me into taking some sort of action!"
					(= seconds 10)
				)
				(2
					(localproc_1 301 2) ; "What could you possibly want with that swampy land, anyway? It's no good for anybody."
					(= seconds 10)
				)
				(3
					(localproc_2 301 3) ; "Little do you know, Gertie, my dear. Let's just say that I happen to know it's worth a great deal, and I have several rich potential investors who would back me up on any plan to exploit, 'er, develop it."
					(= seconds 10)
				)
				(4
					(localproc_1 301 4) ; "Well, tell me!"
					(= seconds 3)
				)
				(5
					(localproc_2 301 5) ; "I've said too much already. You'll probably go and blab everything to Ethel."
					(= seconds 10)
				)
				(6
					(localproc_1 301 6) ; "Of all the nerve! Well, if I were Ethel, I wouldn't sell you any land, either! You're no better than a low-down snake-in-the-grass! I don't know what my daughter sees in you!"
					(= seconds 10)
				)
				(7
					(localproc_2 301 7) ; "My affair with Gloria is none of your business. Besides, she doesn't care what you think."
					(= seconds 10)
				)
				(8
					(localproc_1 301 8) ; "You're trying to exploit my daughter just like you try to exploit everyone else! Well, I've got the goods on you, Mister! I KNOW about your little racehorse scam. If you don't watch your P's and Q's I'm gonna tell him all about it!"
					(= seconds 10)
				)
				(9
					(localproc_2 301 9) ; "Try it, Lady!!"
					(= seconds 4)
				)
				(10
					(localproc_1 301 10) ; "I've had enough of this!"
					(= seconds 4)
				)
				(11
					(gertEye hide:)
					(gertGlass hide:)
					(Gertie
						setLoop: 0
						setCel: 1
						setStep: 5 5
						setMotion: MoveTo 340 (Gertie y:) self
					)
				)
				(12
					(cls)
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
				(Hand setMotion: MoveTo 122 135 self)
				(Print 301 11 #dispose) ; "It's only Clarence sitting alone at the bar."
				(clarMouth cycleSpeed: 1)
			)
			(1
				(= local2 4)
				(clarMouth setScript: cycleMouth)
				(= cycles 1)
			)
			(2
				(if (clarMouth script:)
					(= cycles (= state 1))
				else
					(Smoke show: setCycle: End self)
					(if (< (++ local1) 2)
						(= state 0)
					)
				)
			)
			(3
				(Hand setMotion: MoveTo 140 190)
				(= cycles 10)
			)
			(4
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

(instance Gertie of Act
	(properties
		y 104
		x 213
		view 345
	)
)

(instance Clarence of Prop
	(properties
		y 115
		x 102
		view 409
	)
)

(instance Smoke of Prop
	(properties
		y 82
		x 116
		view 409
		loop 4
	)
)

(instance clarMouth of Prop
	(properties
		y 94
		x 114
		view 409
		loop 2
	)
)

(instance gertMouth of Prop
	(properties
		y 85
		x 213
		view 345
		loop 2
	)
)

(instance gertEye of Prop
	(properties
		y 66
		x 219
		view 345
		loop 1
	)
)

(instance gertGlass of Act
	(properties
		y 138
		x 246
		yStep 5
		view 345
		xStep 5
	)
)

(instance Hand of Act
	(properties
		y 190
		x 140
		yStep 5
		view 409
	)
)

(instance clarEye of Prop
	(properties
		y 72
		x 118
		view 409
	)
)

(instance myMusic of Sound
	(properties)
)

