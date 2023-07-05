;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use Track)
(use LoadMany)
(use StopWalk)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm460 0
	target 1
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
	[local9 6]
	local15
	[local16 10]
	[local26 6]
	[local32 12] = [92 128 88 131 84 134 250 131 258 135 260 138]
	local44
	[local45 5] = [0 -26 -27 -21 999]
	[local50 4]
	local54
	[local55 4] = [0 20 -37 999]
	[local59 7] = [0 -18 -23 24 25 -28 999]
	[local66 3] = [0 -23 999]
	[local69 3] = [0 22 999]
	[local72 4]
	local76
	local77
	local78
	local79
	local80
	local81
	local82
	local83
	local84
	local85
	local86
	local87
	local88
	local89
	local90
	local91
	local92
	local93
	local94
	local95
	local96
	local97
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 0)
	(= temp0
		(switch local81
			(1 150)
			(2 175)
			(3 200)
		)
	)
	(gEgo trySkill: 10 (- temp0 1)) ; throw
	(if (or (< [gEgoStats 10] temp0) (< [gEgoStats 0] temp0)) ; throw, strength
		(if
			(<
				(= temp1
					(-
						100
						(/
							(+ (- temp0 [gEgoStats 10]) (- temp0 [gEgoStats 0])) ; throw, strength
							2
						)
					)
				)
				10
			)
			(= temp1 10)
		)
		(if (> temp1 90)
			(= temp1 90)
		)
		(cond
			((>= temp1 (Random 1 100))
				(if (< local6 171)
					(= local6
						(Random (+ (target nsLeft:) 4) (+ (target nsLeft:) 6))
					)
				else
					(= local6
						(Random (- (target nsRight:) 7) (- (target nsRight:) 5))
					)
				)
				(= local7
					(Random (+ (target nsTop:) 3) (- (target nsBottom:) 8))
				)
			)
			((or (< local6 171) (== local92 -1))
				(= local6 (Random (targArea nsLeft:) (- (target nsLeft:) 1)))
			)
			(else
				(= local6 (Random (+ (target nsRight:) 1) (targArea nsRight:)))
			)
		)
	else
		(if
			(and
				local91
				(= temp2 (- (= temp2 local91) (/ (- [gEgoStats 0] temp0) 10))) ; strength
			)
			(+= local6 (* local92 temp2))
		)
		(if (<= (= temp4 (/ (- (+ temp0 100) [gEgoStats 10]) 10)) 2) ; throw
			(= temp4 2)
		)
		(+= local6 (- temp4 (Random 0 (+ temp4 temp4))))
		(+= local7 (- temp4 (Random 0 (+ temp4 temp4))))
	)
	(localproc_2)
)

(procedure (localproc_1 &tmp temp0)
	(while 1
		(if (= temp0 (localproc_8))
			(break)
		)
	)
)

(procedure (localproc_2)
	(cond
		((< local6 110)
			(= local6 110)
		)
		((> local6 226)
			(= local7 226)
		)
	)
	(cond
		((< local7 44)
			(= local5 0)
			(= local7 65)
		)
		((< 64 local7 80)
			(= local5 0)
		)
		((>= local7 80)
			(= local5 0)
			(= local7 80)
		)
		(else
			(= local5 1)
		)
	)
)

(procedure (localproc_3)
	(if local0
		(HandsOff)
		(localproc_4)
		(if (!= local1 3)
			(gMessager say: 26 61 61) ; "You rerack your spears, just like your mother always taught you."
		)
		(HandsOn)
	)
	(= local44 0)
	(if (competeVSUhura script:)
		((competeVSUhura script:) dispose:)
	)
	(if ((ScriptID 34 1) script:) ; Uhura
		(((ScriptID 34 1) script:) dispose:) ; Uhura
		((ScriptID 34 1) view: 971 setCycle: StopWalk 969 setHeading: 270) ; Uhura
	)
	((gTheIconBar at: 3) cursor: 942)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
		(if (IsObject [local9 temp0])
			([local9 temp0] dispose:)
		)
		((= [local26 temp0] (rackSpear new:))
			loop: (if (< temp0 3) 4 else 3)
			cel: (Random 0 3)
			x: [local32 (* temp0 2)]
			y: [local32 (+ (* temp0 2) 1)]
			init:
			stopUpd:
		)
	)
	(= local0 0)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(switch local81
		(1
			(= temp0 150)
			(= temp1 150)
		)
		(2
			(= temp0 175)
			(= temp1 175)
		)
		(3
			(= temp0 200)
			(= temp1 200)
		)
	)
	(if (and (>= [gEgoStats 10] temp0) (>= [gEgoStats 0] temp1)) ; throw, strength
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_6 &tmp temp0)
	(for ((= temp0 3)) (<= temp0 local76) ((++ temp0))
		(if (IsObject [local9 temp0])
			([local9 temp0] dispose:)
		)
		((= [local26 temp0] (rackSpear new:))
			loop: 3
			cel: (Random 0 3)
			x: [local32 (* temp0 2)]
			y: [local32 (+ (* temp0 2) 1)]
			init:
		)
	)
)

(procedure (localproc_7)
	(gTheIconBar enable: 3 curIcon: (gTheIconBar at: 3))
	(User canInput: 1)
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
)

(procedure (localproc_8)
	(return (- (Random 0 2) 1))
)

(procedure (localproc_9) ; UNUSED
	(= local6 (+ (* (localproc_1) 10) (- (target x:) 1)))
	(= local7 (+ (* (localproc_1) 10) (- (target y:) 17)))
	(= local5 0)
)

(procedure (localproc_10)
	(cond
		((and (not (& local88 $0001)) (< [gEgoStats 0] 150)) ; strength
			(gMessager say: 2 6 6) ; "You do not yet be having the strength to hit the target. You will need to build up your muscles through combat or practice. Try throwing another spear. I then can judge how well you throw."
			(|= local88 $0001)
		)
		((and (not (& local88 $0002)) (< [gEgoStats 10] 150)) ; throw
			(gMessager say: 2 6 1) ; "I be thinking maybe it will take a good many practices before you have the throwing skill for the spear to hit the target. It will take time, but I be certain you can be more skilled at throwing."
			(|= local88 $0002)
		)
		((and (not (& local88 $0004)) (< [gEgoStats 0] 150)) ; strength
			(gMessager say: 2 6 7) ; "You will need more strength to reach that target with a spear. This will come with practice. Throw another spear, and I will be telling how well you throw."
			(|= local88 $0004)
		)
		((and (not (& local88 $0008)) (< [gEgoStats 10] 150)) ; throw
			(gMessager say: 2 6 2) ; "You will need to practice your throwing skills for a while before you will be able to hit the target. It is only a matter of time and exercise."
			(|= local88 $0008)
		)
		((and (not (& local88 $0010)) (< [gEgoStats 0] 175) (== local81 3)) ; strength
			(gMessager say: 2 6 8) ; "It takes a great deal of strength to throw a spear to that target. You will need to work up your muscles if you wish to be skilled at spear throwing. Try throwing again and I will tell you about your throwing skill."
			(|= local88 $0010)
		)
		((and (not (& local88 $0020)) (< [gEgoStats 10] 150) (!= local81 1)) ; throw
			(gMessager say: 2 6 3) ; "You will need to practice your throwing skills more before you can hit that target. Show me again how you throw a spear."
			(|= local88 $0020)
		)
		((and (not (& local88 $0040)) (< [gEgoStats 10] 170) (!= local81 1)) ; throw
			(gMessager say: 2 6 4) ; "You be good at throwing, but not good enough to throw a spear. With more practice, you will be skilled. Try throwing another spear."
			(|= local88 $0040)
		)
		((and (not (& local88 $0080)) (< [gEgoStats 10] 200) (== local81 3)) ; throw
			(gMessager say: 2 6 5) ; "You know how to throw some things, but not how to throw a spear. With more practice, you will be a fine thrower of spears. Try again."
			(|= local88 $0080)
		)
		((and (not (& local88 $0100)) (< [gEgoStats 10] 200) (== local81 3)) ; throw
			(gMessager say: 2 6 31) ; "Very, very good. You have practice throwing things before. Now you need to be practicing throwing the spear and soon you will be skilled. Show me your spear throwing again."
			(|= local88 $0100)
		)
		((and (not (& local88 $0200)) (== local81 3))
			(gMessager say: 2 6 34) ; "A really skilled thrower of spears must always watch to see which way the wind blows. A spear may sometimes miss the target because of the wind. Always aim into the wind."
			(|= local88 $0200)
		)
		((and (not (& local88 $0400)) (!= local81 1))
			(gMessager say: 2 6 33) ; "Once you have the skills of strength and throwing, it is only a matter of judgement to hit the target."
			(|= local88 $0400)
		)
		((not local94)
			(= local94 1)
			(gMessager say: 2 6 30) ; "Hero, do not be discouraged because you need to practice more. Remember that a Simbani Warrior practices spear throwing from the time a Simbani can walk without falling down."
		)
		((not (Random 0 5))
			(gMessager say: 2 6 30) ; "Hero, do not be discouraged because you need to practice more. Remember that a Simbani Warrior practices spear throwing from the time a Simbani can walk without falling down."
		)
	)
)

(procedure (localproc_11)
	(cond
		((and (not (& local88 $0001)) (< [gEgoStats 0] 125)) ; strength
			(gMessager say: 1 6 6) ; "As the spear only traveled about ten feet from you, you get the feeling you should have eaten more wheaties. Either that or practice building up your strength some more."
			(|= local88 $0001)
		)
		((and (not (& local88 $0002)) (< [gEgoStats 0] 150) (!= local81 1)) ; strength
			(gMessager say: 1 6 7) ; "Your spear needed more force to hit the target and you don't yet have enough strength. You'll need to get some more exercise to build up those muscles. Practice won't hurt, either."
			(|= local88 $0002)
		)
		((and (not (& local88 $0004)) (< [gEgoStats 0] 175) (== local81 3)) ; strength
			(gMessager say: 1 6 8) ; "Since the spear fell far short of the target, you guess you'd better build up your strength as well as your throwing skills before you are good with spears."
			(|= local88 $0004)
		)
		((and (not (& local88 $0008)) (< [gEgoStats 10] 100)) ; throw
			(gMessager say: 1 6 1) ; "Judging from that throw, you figure it's going to take an awful lot of practice before you get good at it."
			(|= local88 $0008)
		)
		((and (not (& local88 $0010)) (< [gEgoStats 10] 150)) ; throw
			(gMessager say: 1 6 2) ; "As you watch the spear sail through the air, you have a feeling you are going to need a lot of practice before you are skilled at spear throwing."
			(|= local88 $0010)
		)
		((and (not (& local88 $0020)) (< [gEgoStats 10] 145) (!= local81 1)) ; throw
			(gMessager say: 1 6 3) ; "You really have to concentrate to throw the spear, so you figure it is going to take quite a bit of practice before spear throwing becomes easy."
			(|= local88 $0020)
		)
		((and (not (& local88 $0040)) (< [gEgoStats 10] 170) (!= local81 1)) ; throw
			(gMessager say: 1 6 4) ; "Your throwing skill has improved greatly since you first started adventuring, but you have a feeling you have a long way to go before you are skilled at spear throwing."
			(|= local88 $0040)
		)
		((and (not (& local88 $0080)) (< [gEgoStats 10] 195) (== local81 3)) ; throw
			(gMessager say: 1 6 5) ; "You can tell it's going to take more spear throwing practice before you manage to hit that target, but you are getting better at it."
			(|= local88 $0080)
		)
	)
)

(procedure (localproc_12 param1) ; UNUSED
	(HandsOff)
	(switch (- local79 local87)
		(0
			(gMessager say: 4 6 47 0 param1) ; "The spear missed the target. No points."
		)
		(1
			(gMessager say: 4 6 48 0 param1) ; "The spear hit the outside of the target. One point."
		)
		(2
			(gMessager say: 4 6 49 0 param1) ; "The spear hit the center of the target. Two points."
		)
	)
	(= local87 local79)
)

(procedure (localproc_13 param1)
	(cond
		((and (not (& local90 $0001)) (< [gEgoStats 0] 100)) ; strength
			(gMessager say: 1 6 14 0 param1) ; "You are used to throwing, but not at such a distance. You are going to have to build up your strength through practice before you can hit that target."
			(|= local90 $0001)
		)
		((and (not (& local90 $0002)) (< [gEgoStats 0] 125) (!= local81 1)) ; strength
			(gMessager say: 1 6 15 0 param1) ; "As your dagger falls short of the target, you get the feeling you need to build up your muscles more. You never know when a well-thrown dagger might come in handy."
			(|= local90 $0002)
		)
		((and (not (& local90 $0004)) (< [gEgoStats 0] 150) (== local81 3)) ; strength
			(gMessager say: 1 6 16 0 param1) ; "Your dagger lands this side of the target, and it isn't because of headwind. You need to build up your strength to throw a dagger that far."
			(|= local90 $0004)
		)
		((and (not (& local90 $0008)) (< [gEgoStats 10] 100)) ; throw
			(gMessager say: 1 6 9 0 param1) ; "Considering how badly you missed the target, you get the feeling you need a lot of dagger throwing practice."
			(|= local90 $0008)
		)
		((and (not (& local90 $0010)) (< [gEgoStats 10] 125)) ; throw
			(gMessager say: 1 6 10 0 param1) ; "Since the dagger didn't even come close to the target, you realize you badly need some more throwing practice."
			(|= local90 $0010)
		)
		((and (not (& local90 $0020)) (< [gEgoStats 10] 150) (!= local81 1)) ; throw
			(gMessager say: 1 6 11 0 param1) ; "If that target had been a monster, you'd be running for your life right now. You guess you need some more throwing practice, just in case you do meet a monster."
			(|= local90 $0020)
		)
		((and (not (& local90 $0040)) (< [gEgoStats 10] 175) (!= local81 1)) ; throw
			(gMessager say: 1 6 12 0 param1) ; "Your daggers get close to the target, but you are still missing. If you want to get good, you are going to have to practice more."
			(|= local90 $0040)
		)
		((and (not (& local90 $0080)) (< [gEgoStats 10] 185) (== local81 3)) ; throw
			(gMessager say: 1 6 13 0 param1) ; "Well, you know your throwing skill has really improved, but you can't blame the daggers for missing. You just need to practice some more."
			(|= local90 $0080)
		)
		(else
			(param1 cue:)
		)
	)
)

(instance rm460 of Rm
	(properties
		noun 5
		picture 460
	)

	(method (init &tmp temp0 temp1)
		(= local97 0)
		(= local3 1)
		(= [local50 0] @local45)
		(= [local50 1] 999)
		(egoActions init: gEgo @local45 @local50)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 164 278 160 260 146 232 146 232 126 101 126 39 188
					yourself:
				)
		)
		(HandsOff)
		(target setLoop: 0 ignoreActors: 1 init:)
		(barrier init:)
		(leftBush init:)
		(leftRocks init:)
		(rightRocks init:)
		(leftTreeTop init:)
		(leftTreeBot init:)
		(rightTrees init:)
		(plant1 init:)
		(plant2 init:)
		(plant3 init:)
		(plant4 init:)
		(plant5 init:)
		(plant6 init:)
		(targArea init:)
		(= local95 0)
		(= local96 0)
		(= local94 0)
		(for ((= temp1 0)) (< temp1 6) ((++ temp1))
			((= [local26 temp1] (rackSpear new:))
				loop: (if (< temp1 3) 4 else 3)
				cel: (Random 0 3)
				x: [local32 (* temp1 2)]
				y: [local32 (+ (* temp1 2) 1)]
				init:
			)
		)
		(spearRack approachVerbs: 4 init:) ; Do
		(flag init:)
		(if (IsFlag 56)
			(LoadMany rsVIEW 980 981 989)
		else
			(LoadMany rsVIEW 46 971 972 969)
		)
		(super init:)
		(gEgo
			normalize:
			setScale:
			scaleX: 128
			scaleY: 128
			actions: egoActions
			noun: 3
			init:
			hide:
		)
		(cond
			((and (IsFlag 56) (not gNight) (not (IsFlag 16)))
				(= local1 3)
				(gEgo x: 103 y: 148 setHeading: 15 show:)
				((ScriptID 39 1) ; Yesufu
					view: 984
					x: 242
					y: 144
					loop: 4
					cel: 0
					setScale:
					scaleX: 128
					scaleY: 128
					init:
				)
				(gEgo setScript: startContest)
			)
			((== gPrevRoomNum 480)
				(gEgo setScript: enterFromEast)
			)
			(else
				(gCurRoom setScript: enterRoom)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(gMessager say: 27 6 66) ; "Hero, resting here could be hazardous to your health. Best to reconsider."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((gEgo script:) 0)
			((and (gEgo mover:) local44)
				(localproc_3)
			)
			((>= (gEgo y:) 183)
				(gCurRoom setScript: walkEgoOut)
			)
			((>= (gEgo x:) 315)
				(gCurRoom setScript: exitTo480)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (!= (gLongSong number:) 160)
			(gLongSong changeTo: 160)
		)
		((gTheIconBar at: 3) cursor: 942)
		(UnLoad 128 46)
		(UnLoad 128 9)
		(UnLoad 128 10)
		(UnLoad 128 971)
		(UnLoad 128 972)
		(UnLoad 128 969)
		(UnLoad 128 980)
		(UnLoad 128 981)
		(UnLoad 128 989)
		(LoadMany 0 34 39 991 955 53)
		(super dispose:)
	)
)

(instance egoActions of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-26
				(gCast contains: (ScriptID 34 1)) ; Uhura
				-27
				(gCast contains: (ScriptID 34 1)) ; Uhura
				-21
				(and
					(gCast contains: (ScriptID 34 1)) ; Uhura
					(== local1 2)
					(not local78)
				)
		)
	)

	(method (doChild)
		(switch query
			(-26
				(if (not (IsFlag 155))
					(SetFlag 155)
					(gEgo addHonor: 4)
				)
				(return 1)
			)
			(-27
				(gEgo addHonor: 2)
				(localproc_3)
				(gCurRoom setScript: uhuraLeave)
				(return 0)
			)
			(-21
				(uhuraActions query: -37)
				(uhuraActions doChild:)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

(instance uhuraActions of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-18
				(and (== local1 1) (not local54))
				20
				(!= local1 1)
				-37
				(not local78)
				-28
				[gEgoStats 10] ; throw
		)
	)

	(method (doChild)
		(switch query
			(-37
				(= local78 1)
				(= local77 0)
				(localproc_4)
				((ScriptID 34 1) setScript: competeVSUhura) ; Uhura
				(return 0)
			)
			(-18
				(gMessager say: 2 5 18) ; "To hit your target with the spear takes both strength and throwing skill. You can build up your strength through practice, but you will be needing to use your brains to improve your throwing skill."
				(gCurRoom setScript: uhuraThrow)
				(return 0)
			)
			(-23
				(super doChild: &rest)
			)
			(-28
				(= local2 1)
				(return 1)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(else
				((ScriptID 34 1) doVerb: theVerb) ; Uhura
			)
		)
	)
)

(instance enterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 330 y: 170 show: setMotion: PolyPath 300 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yesufuThrows of Script
	(properties)

	(method (doit)
		(cond
			((not (target script:)) 0)
			((!= state 0) 0)
			((and (== (target x:) 202) (== local4 -1))
				(= local6 155)
				(= local7 (+ (target y:) (Random 0 2)))
				(self cue:)
			)
			((and (== (target x:) 140) (== local4 1))
				(= local6 158)
				(= local7 (+ (target y:) (Random 0 2)))
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local97 0)
				(if (not (target script:))
					(= local6 (target x:))
					(= local7 (target y:))
					(+= local6 (- 7 (Random 0 14)))
					(+= local7 (- 6 (Random 0 12)))
					(= cycles 1)
				)
			)
			(1
				(= local85 (+ local84 3))
				(switch local81
					(1
						(= temp2 150)
					)
					(2
						(= temp2 175)
					)
					(3
						(= temp2 200)
					)
				)
				(= local86 0)
				([local26 local85] dispose:)
				((ScriptID 39 1) ; Yesufu
					setCel: 0
					loop: 2
					setScale:
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(2
				((ScriptID 39 1) loop: 3 cel: 0 setCycle: CT 3 1 self) ; Yesufu
				(= local97 0)
			)
			(3
				((ScriptID 39 1) setCycle: End self) ; Yesufu
				(+=
					local95
					(+
						(Abs (- (target x:) local6))
						(Abs (- (target y:) local7))
					)
				)
				((= local97 (= [local9 local85] (spear new:)))
					x: 200
					y: 79
					setLoop: 1
					setScale:
					scaleX: 128
					scaleY: 128
					setCycle: CT 4 1 self
					setPri: (if (< local6 (+ (target nsLeft:) 2)) 3 else 5)
					init:
					setMotion: JumpTo local6 local7 self
				)
			)
			(4 1)
			(5
				(if (> (local97 x:) (+ (target x:) 4))
					(local97 x: (- (local97 x:) 3))
				)
				(if (< (local97 x:) (- (target x:) 4))
					(local97 x: (+ (local97 x:) 3))
				)
				(= cycles 1)
			)
			(6
				(gLongSong2 number: 461 setLoop: 1 play: 127)
				((ScriptID 39 1) ; Yesufu
					loop: 4
					setCel: 0
					setScale:
					scaleX: 128
					scaleY: 128
				)
				(= temp0 (- ([local9 local85] x:) (target x:)))
				(= temp1 (- ([local9 local85] y:) (target y:)))
				(if (target script:)
					(if (target onMe: [local9 local85])
						([local9 local85]
							setMotion: (trackSpear new:) target temp0 temp1
							setPri: (if local5 5 else 2)
						)
					else
						([local9 local85] setPri: 2)
					)
				)
				([local9 local85] setCycle: 0)
				(= cycles 2)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance startContest of Script
	(properties)

	(method (doit)
		(if local83
			(= local83 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= ticks 1)
			)
			(1
				(gLongSong changeTo: 490)
				(= ticks 30)
			)
			(2
				(gMessager say: 4 6 39 0 self) ; "Yesufu and the hero from far away will now compete at the throwing of spears. They will be judged spear by spear, for one will throw and then the other."
			)
			(3
				(gMessager say: 4 6 46 0 self) ; "The hero from far lands may throw the first spear."
			)
			(4
				(= local81 global209)
				(self setScript: throwMode self)
			)
			(5
				(localproc_7)
				(User canControl: 0)
			)
			(6
				(= cycles 1)
			)
			(7
				(self setScript: yesufuThrows self)
			)
			(8
				(if (< (++ local84) 3)
					(self changeState: (- state 3))
				else
					(= local84 0)
					(= cycles 1)
				)
			)
			(9
				(= local0 6)
				(localproc_4)
				(if (> local96 local95)
					(gMessager say: 4 6 50 0 self) ; "Yesufu has won the throwing of spears at the target which does not move."
				else
					(gMessager say: 4 6 51 0 self) ; "Yesufu and the hero have both won the throwing of spears at the target which does not move."
				)
				(target setScript: moveTarget)
				(= local79 (= local87 (= local80 (= local0 0))))
			)
			(10
				(localproc_7)
				(User canControl: 0)
			)
			(11
				(= cycles 1)
			)
			(12
				(self setScript: yesufuThrows self)
			)
			(13
				(if (< (++ local84) 3)
					(self changeState: (- state 3))
				else
					(= cycles 1)
				)
			)
			(14
				(if (< local96 local95)
					(SetFlag 78)
					(gMessager say: 4 6 55 0 self) ; "The winner of the throwing of spears be the hero from far lands!"
				else
					(gMessager say: 4 6 54 0 self) ; "The winner of the throwing of spears be Yesufu!"
				)
			)
			(15
				(if (< local96 local95)
					(gEgo view: 32 loop: 0 cel: 0 setCycle: End self)
					(gLongSong setLoop: 1 number: 462 play:)
					(gEgo solvePuzzle: 278 5 9)
				else
					(= cycles 1)
				)
			)
			(16
				(localproc_3)
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance competeVSUhura of Script
	(properties)

	(method (doit)
		(if local77
			(= local77 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gMessager say: 2 6 39 0 self) ; "To win a spear throwing contest try to hit the center of the target. Center of the target counts as two points, outside of target counts as one."
			)
			(1
				(gMessager say: 2 6 40 0 self) ; "You throw, then I throw."
			)
			(2
				(localproc_4)
				(switch local81
					(1
						(= temp1 180)
					)
					(2
						(= temp1 215)
					)
					(3
						(= temp1 240)
					)
				)
				(= local96 (= local79 (= local80 0)))
			)
			(3
				(= local3 0)
				(HandsOff)
				(= local76 3)
				(if (and (not local82) (>= local79 5))
					(= temp0 1)
				else
					(= temp0 2)
				)
				(self setScript: uhuraThrowSp self temp0)
			)
			(4
				(= cycles 3)
			)
			(5
				(++ local76)
				(if (and (not local82) (>= local79 4))
					(= temp0 1)
				else
					(= temp0 2)
				)
				(self setScript: uhuraThrowSp self temp0)
			)
			(6
				(= cycles 3)
			)
			(7
				(++ local76)
				(if (and (not local82) (>= local79 3))
					(= temp0 1)
				else
					(= temp0 2)
				)
				(self setScript: uhuraThrowSp self temp0)
			)
			(8
				(= cycles 1)
			)
			(9
				(HandsOn)
				(= local3 1)
				(localproc_6)
				(if (< local95 local96)
					(= local95 0)
					(gMessager say: 2 6 43 0 self) ; "I have won this contest but you have improved greatly with spear throwing since you started practicing here. With more practice you will be very good."
				else
					(= local95 0)
					(gMessager say: 2 6 44 0 self) ; "You have beaten me at the throwing of spears. Do not stop practicing, though. There are many who be better throwing spears than I. Still, you are very, very good."
				)
				(SetFlag 64)
			)
			(10
				(gMessager say: 2 6 45 0 self) ; "To be winning at a Simbani initiation contest, you will need to be even more skilled at throwing than I."
			)
			(11
				((ScriptID 34 1) ; Uhura
					view: 971
					setCycle: StopWalk 969
					setHeading: 270
				)
			)
			(12
				(gEgo solvePuzzle: 277 3 9)
				(gCurRoom setScript: uhuraLeave)
				(self dispose:)
			)
		)
	)
)

(instance uhuraLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_6)
				(gMessager say: 3 5 27 0 self) ; "You tell Uhura good-bye."
			)
			(1
				((ScriptID 34 1) ; Uhura
					view: 971
					setCycle: StopWalk 969
					setMotion: PolyPath ((ScriptID 34 1) x:) 235 self ; Uhura
					setCycle: StopWalk 969
				)
			)
			(2
				(gLongSong changeTo: 160)
				(= local88 0)
				(= local1 0)
				((ScriptID 34 1) dispose:) ; Uhura
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance uhuraEnterAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 460)
				(= local1 2)
				(= local88 0)
				(if (not register)
					(gMessager say: 2 6 35 0 self) ; "You be getting pretty good with your spear throwing hero. Maybe you as good as I."
				else
					(gMessager say: 2 6 56 0 self) ; "You throw with spirit, but need more practice. Don't feel bad, all Simbani throw spears from when they little. You practice more, maybe be as good as me someday."
				)
			)
			(1
				(self setScript: uhuraEnter self)
			)
			(2
				(gMessager say: 2 6 36 0 self) ; "Maybe you and I should be seeing who is the better thrower of spears. Do you wish to compete with me?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance uhuraThrowSp of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				([local26 local76] dispose:)
				((ScriptID 34 1) view: 973 setCel: 0 loop: 0 setCycle: End self) ; Uhura
			)
			(1
				((ScriptID 34 1) loop: 2 cel: 0 setCycle: CT 3 1 self) ; Uhura
			)
			(2
				((ScriptID 34 1) setCycle: End self) ; Uhura
				(= temp0 (target x:))
				(= temp1 (target y:))
				(+= temp0 (- 9 (Random 0 18)))
				(+= temp1 (- 9 (Random 0 18)))
				(+=
					local95
					(+ (Abs (- (target x:) temp0)) (Abs (- (target y:) temp1)))
				)
				((= [local9 local76] (spear new:))
					x: 200
					y: 79
					setLoop: 1
					setScale:
					scaleX: 128
					scaleY: 128
					setCycle: CT 4 1
					setPri: (if (< temp0 (+ (target nsLeft:) 2)) 3 else 5)
					setMotion: JumpTo temp0 temp1 self
					init:
				)
			)
			(3
				(Animate (gCast elements:) 1)
				(= cycles 5)
			)
			(4
				(if
					(and
						(< 168 ([local9 local76] x:) 174)
						(< 52 ([local9 local76] y:) 58)
					)
					(+= local80 2)
				else
					(+= local80 1)
				)
				(gLongSong2 number: 461 setLoop: 1 play: 127)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance uhuraThrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local54 1)
				(= local76 4)
				(self setScript: uhuraThrowSp self)
			)
			(1
				(if (== global209 1)
					((ScriptID 34 1) view: 971 setCycle: StopWalk 969) ; Uhura
					(self dispose:)
				else
					(gMessager say: 2 6 38 0 self) ; "You need to be using your head to judge such things as how high to throw a spear so that it falls to the target and how much strength to be using."
				)
			)
			(2
				(= local76 5)
				(self setScript: uhuraThrowSp self)
			)
			(3
				((ScriptID 34 1) view: 971 setCycle: StopWalk 969) ; Uhura
				(self dispose:)
			)
		)
	)
)

(instance throwMode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gTheIconBar at: 3) cursor: 947)
				(= local44 1)
				(= local81 global209)
				(gEgo setHeading: 15)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance uhuraEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 460)
				(HandsOff)
				(gEgo setHeading: 90)
				(SetFlag 53)
				((ScriptID 34 1) ; Uhura
					x: 230
					y: 200
					setCycle: StopWalk 969
					setScale:
					scaleX: 128
					scaleY: 128
					noun: 2
					init:
					setMotion: MoveTo 242 144 self
				)
			)
			(1
				((ScriptID 34 1) setHeading: 270) ; Uhura
				(= cycles 18)
			)
			(2
				(if (== local1 1)
					(= [local72 0] @local59)
					(= [local72 1] @local69)
					(uhuraActions init: (ScriptID 34 1) @local59 @local72 @local66) ; Uhura
					(gMessager say: 2 6 17 0 self) ; "This be the place where the Simbani practice throwing spears. No Simbani Warrior will ever use a sword, since you cannot very well throw a sword in battle."
				else
					(= [local72 0] @local55)
					(uhuraActions init: (ScriptID 34 1) @local55 @local72) ; Uhura
					(= cycles 1)
				)
			)
			(3
				(if (and (== local1 1) (== gBaseHeroType 0)) ; Fighter
					(gMessager say: 2 6 19 0 self) ; "If you are interested, I will be happy to teach you how to throw a spear."
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwSpear of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(Load rsVIEW 10)
				(= local89 1)
				(= local93 0)
				(if (!= local1 3)
					(HandsOff)
				else
					(gTheIconBar disable: 3)
					(gGame setCursor: gWaitCursor 1)
				)
				(if (== [gEgoStats 10] 0) ; throw
					(gMessager say: 26 61 57) ; "It appears you could use more practice. Like a lot more!"
					(localproc_3)
					(HandsOn)
					(self dispose:)
				else
					([local26 local0] dispose:)
					(gEgo view: 10 loop: 0 cel: 0 setCycle: CT 4 1 self)
				)
			)
			(1
				(gEgo setCycle: End)
				(switch local81
					(1
						(= temp0 150)
					)
					(2
						(= temp0 175)
					)
					(3
						(= temp0 200)
					)
				)
				(localproc_0)
				((= [local9 local0] (spear new:))
					init:
					ignoreActors: 1
					illegalBits: 0
					setLoop: 5
					setPri: (if (< local6 (+ (target nsLeft:) 2)) 3 else 5)
					setCycle: CT 2 1
					cycleSpeed: 6
					setScale:
					scaleX: 128
					scaleY: 128
					setStep: 30 20
					setMotion: MoveTo local6 local7 self
				)
			)
			(2
				(if
					(and
						(<
							(+ (target nsLeft:) 2)
							local6
							(- (target nsRight:) 2)
						)
						(< (target nsTop:) local7 (- (target nsBottom:) 5))
					)
					(if (target mover:)
						(= temp1 (- local6 (target x:)))
						(= temp2 (- local7 (target y:)))
						([local9 local0]
							setMotion: (trackSpear new:) target temp1 temp2
							setPri: 5
						)
					)
					(= register 0)
					(gLongSong2 number: 461 setLoop: 1 play: 127)
				else
					(= register 1)
				)
				([local9 local0] setCycle: End self)
			)
			(3
				(+=
					local96
					(+
						(Abs (- (target x:) local6))
						(Abs (- (target y:) local7))
					)
				)
				(cond
					(register
						(cond
							(
								(and
									(gCast contains: (ScriptID 34 1)) ; Uhura
									local2
									(== local1 1)
									[gEgoStats 10] ; throw
								)
								(= local89 1)
								(localproc_10)
							)
							((and (== local1 0) [gEgoStats 10]) ; throw
								(= local89 1)
								(localproc_11)
							)
						)
						([local9 local0] setPri: 3)
					)
					(
						(and
							(== local1 1)
							local2
							(gCast contains: (ScriptID 34 1)) ; Uhura
						)
						(gMessager say: 2 6 29) ; "You be doing very well. I think you soon be giving a Simbani Warrior challenges at spear throwing."
					)
				)
				(= local89 0)
				(if (== (++ local0) 3)
					(= ticks 120)
				else
					(= ticks 60)
				)
			)
			(4
				(if (and (!= local1 3) (== local0 3))
					(= local77 1)
					(gMessager say: 26 61 58) ; "Faster than a speeding bullet you retrieve your spears."
					(localproc_4)
				)
				(gEgo normalize: 3 setHeading: 15)
				(if
					(and
						(IsFlag 53)
						(== gBaseHeroType 0) ; Fighter
						(not (IsFlag 64))
						(not (gCast contains: (ScriptID 34 1))) ; Uhura
						(localproc_5)
					)
					(self setScript: uhuraEnterAgain self register)
				else
					(= cycles 1)
				)
			)
			(5
				(= local83 1)
				(if (or (not local3) (== local1 3))
					0
				else
					(HandsOn)
				)
				(UnLoad 128 10)
				(self dispose:)
			)
		)
	)
)

(instance moveTarget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 1)
				(target setMotion: MoveTo 215 55 self)
			)
			(1
				(= local4 -1)
				(target setMotion: MoveTo 120 55 self)
			)
			(2
				(self changeState: (- state 2) &rest)
			)
		)
	)
)

(instance exitTo480 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance walkEgoOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 65) self
				)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 160 y: 200 show: setMotion: PolyPath 160 180 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 9)
				(= local81 global209)
				(if (== [gEgoStats 10] 0) ; throw
					(gMessager say: 26 61 57) ; "It appears you could use more practice. Like a lot more!"
					(self dispose:)
				else
					(HandsOff)
					(gEgo setMotion: PolyPath 103 148 self)
				)
			)
			(1
				(gEgo view: 9 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCycle: End)
				(localproc_0)
				((= [local16 local15] (dagger new:))
					setCycle: Fwd
					cycleSpeed: 2
					moveSpeed: 2
					setScale: 115
					origStep: 2570
					setMotion: MoveTo local6 local7 self
					init:
				)
				(gEgo drop: 10 1) ; theDaggers
			)
			(3
				(if (not (and local5 (< 157 local6 185)))
					([local16 local15] hide:)
					(localproc_13 self)
				else
					(gLongSong2 number: 461 setLoop: 1 play: 127)
					(= cycles 1)
				)
			)
			(4
				(if (not (& ([local16 local15] signal:) $0080))
					([local16 local15] setCycle: 0 cel: 3)
				)
				(++ local15)
				(HandsOn)
				(if (== local15 10)
					(for ((= local15 0)) (< local15 10) ((++ local15))
						([local16 local15] dispose:)
					)
					(gEgo get: 10 10) ; theDaggers
					(= local15 0)
					(gMessager say: 26 61 59) ; "The daggers you threw, the daggers you retrieve."
				)
				(gEgo normalize: 6)
				(UnLoad 128 9)
				(self dispose:)
			)
		)
	)
)

(instance spearRack of Feature
	(properties
		x 90
		y 120
		nsTop 85
		nsLeft 50
		nsBottom 152
		nsRight 100
		sightAngle 40
		approachX 103
		approachY 148
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (IsFlag 53)) (not gNight))
					(= local1 1)
					(gCurRoom setScript: uhuraEnter)
				else
					(gCurRoom setScript: throwMode)
				)
				(return 1)
			)
			(1 ; Look
				(gCurRoom doVerb: 1 &rest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance targArea of Feature
	(properties
		x 159
		y 40
		nsTop 34
		nsLeft 73
		nsBottom 88
		nsRight 246
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCurRoom script:) 0)
					(local44
						(= local6 gMouseX)
						(= local7 (- gMouseY 10))
						(gCurRoom setScript: throwSpear)
						(return 1)
					)
				)
			)
			(20 ; theDaggers
				(cond
					((gCurRoom script:) 0)
					((not local44)
						(= local6 gMouseX)
						(= local7 (- gMouseY 10))
						(gCurRoom setScript: throwDagger)
					)
					(else
						(gMessager say: 26 61 60) ; "This is not a good time to do that."
					)
				)
			)
			(1 ; Look
				(gCurRoom doVerb: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rackSpear of View
	(properties
		noun 10
		approachX 103
		approachY 148
		view 460
		cel 1
		signal 26624
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: 1 &rest)
		else
			(spearRack doVerb: theVerb &rest)
		)
	)
)

(instance barrier of Feature
	(properties
		x 169
		y 108
		noun 12
		nsTop 106
		nsLeft 82
		nsBottom 110
		nsRight 256
		sightAngle 180
	)
)

(instance leftBush of Feature
	(properties
		x 14
		y 169
		noun 13
		nsTop 158
		nsBottom 181
		nsRight 29
		sightAngle 180
	)
)

(instance leftRocks of Feature
	(properties
		x 35
		y 145
		noun 14
		nsTop 129
		nsBottom 162
		nsRight 70
		sightAngle 180
	)
)

(instance rightRocks of Feature
	(properties
		x 294
		y 135
		noun 15
		nsTop 117
		nsLeft 270
		nsBottom 154
		nsRight 319
		sightAngle 180
	)
)

(instance leftTreeTop of Feature
	(properties
		x 65
		y 20
		noun 16
		nsBottom 41
		nsRight 130
		sightAngle 180
	)
)

(instance leftTreeBot of Feature
	(properties
		x 58
		y 67
		noun 17
		nsTop 48
		nsLeft 14
		nsBottom 87
		nsRight 103
		sightAngle 180
	)
)

(instance rightTrees of Feature
	(properties
		x 273
		y 40
		noun 18
		nsLeft 228
		nsBottom 80
		nsRight 319
		sightAngle 180
	)
)

(instance plant1 of Feature
	(properties
		x 78
		y 173
		noun 19
		nsTop 165
		nsLeft 62
		nsBottom 181
		nsRight 95
		sightAngle 180
	)
)

(instance plant2 of Feature
	(properties
		x 183
		y 135
		noun 20
		nsTop 127
		nsLeft 167
		nsBottom 144
		nsRight 200
		sightAngle 180
	)
)

(instance plant3 of Feature
	(properties
		x 224
		y 130
		noun 21
		nsTop 124
		nsLeft 201
		nsBottom 136
		nsRight 247
		sightAngle 180
	)
)

(instance plant4 of Feature
	(properties
		x 213
		y 172
		noun 22
		nsTop 166
		nsLeft 202
		nsBottom 178
		nsRight 225
		sightAngle 180
	)
)

(instance plant5 of Feature
	(properties
		x 123
		y 95
		noun 23
		nsTop 89
		nsLeft 111
		nsBottom 101
		nsRight 135
		sightAngle 180
	)
)

(instance plant6 of Feature
	(properties
		x 235
		y 88
		noun 24
		nsTop 81
		nsLeft 219
		nsBottom 95
		nsRight 252
		sightAngle 180
	)
)

(instance flag of Prop
	(properties
		x 33
		y 98
		noun 8
		view 460
		loop 5
	)

	(method (doit &tmp temp0)
		(if (!= global209 1)
			(if (and (not (self cycler:)) (== loop 5))
				(= local91 10)
				(if (Random 0 1)
					(= local92 1)
				else
					(= local92 -1)
				)
				(self loop: (if (> local92 0) 1 else 2) setCycle: Fwd)
			)
			(if (< (= temp0 (Random 0 3600)) 10)
				(= local92 1)
				(= loop 1)
			)
			(if (> temp0 3590)
				(= local92 -1)
				(= loop 2)
			)
		else
			(if local91
				(= local92 (= local91 0))
			)
			(if (!= loop 5)
				(self setCycle: 0 loop: 5)
			)
		)
		(super doit: &rest)
	)
)

(instance target of Actor
	(properties
		x 171
		y 55
		noun 9
		view 460
		priority 4
		signal 24592
		xStep 1
		moveSpeed 0
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(!= ((gTheIconBar at: 3) cursor:) 3)
						(IsObject [local16 0])
					)
					(for ((= temp0 0)) (< temp0 local15) ((++ temp0))
						([local16 temp0] dispose:)
						(gEgo get: 10) ; theDaggers
					)
					(gMessager say: 26 61 59) ; "The daggers you threw, the daggers you retrieve."
					(= local15 0)
				else
					(targArea doVerb: theVerb &rest)
				)
			)
			(20 ; theDaggers
				(targArea doVerb: theVerb &rest)
			)
			(13 ; theFineSpear
				(gMessager say: 27 4 62) ; "You reconsider throwing the fine spear, you wouldn't want to damage it."
			)
			(33 ; theRocks
				(gMessager say: 27 4 63) ; "This area is only for throwing spears and daggers, not rocks."
			)
			(12 ; theFineDagger
				(gMessager say: 27 4 64) ; "This is a very fine dagger, you had better not risk damaging it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spear of Actor
	(properties
		x 128
		y 92
		noun 10
		view 46
		loop 5
		signal 24576
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(targArea doVerb: theVerb &rest)
		)
	)
)

(instance dagger of Actor
	(properties
		x 95
		y 110
		noun 11
		view 46
		loop 2
		priority 5
		signal 26640
	)
)

(instance spearPath of JumpTo ; UNUSED
	(properties
		waitApogeeX 0
		waitApogeeY 0
	)
)

(instance trackSpear of Track
	(properties)

	(method (doit)
		(client
			x: (+ (who x:) xOffset)
			y: (+ (who y:) yOffset)
			z: (+ (who z:) zOffset)
		)
	)
)

