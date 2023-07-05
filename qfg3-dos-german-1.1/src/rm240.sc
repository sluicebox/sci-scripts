;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use Teller)
(use Vendor)
(use bazaarR)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm240 0
	aWeaponSeller 2
	aSanford 3
	aSon 4
	aHoneySeller 5
	aOilSeller 6
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 = 1
	local11
	[local12 4]
	local16
	[local17 9] = [0 -92 -93 -105 -43 -72 -97 -98 999]
	[local26 7] = [0 82 83 84 -86 -85 999]
	[local33 7] = [0 76 77 47 78 24 999]
	[local40 5] = [0 79 80 25 999]
	[local45 5] = [0 104 81 26 999]
	[local50 6] = [0 -36 35 -100 -101 999]
	[local56 7] = [0 37 38 39 40 2 999]
	[local63 3] = [0 -36 999]
	[local66 6] = [0 63 35 -100 -101 999]
	[local72 6] = [0 -48 35 -100 -101 999]
	[local78 4] = [0 49 -91 999]
	[local82 3] = [0 -48 999]
	[local85 6] = [0 52 35 -100 -101 999]
	[local91 4]
	[local95 4]
	[local99 4]
	[local103 5]
	[local108 5]
	[local113 5]
	[local118 5]
)

(procedure (localproc_0)
	(if (not (= local3 (Random 0 3)))
		(if
			(or
				(== (weaponSellerFirst state:) -1)
				(== (weaponSellerFirst state:) 10)
			)
			(= local3 0)
		else
			(= local3 1)
		)
	)
	(= local0 0)
	([local12 local3] cel: 0 setCycle: End aOilSeller)
)

(procedure (localproc_1 param1)
	(switch param1
		(1
			(DisposeScript 245)
		)
		(7
			(DisposeScript 246)
		)
		(6
			(DisposeScript 246)
		)
		(4
			(DisposeScript 247)
		)
		(5
			(DisposeScript 248)
		)
	)
)

(instance rm240 of Rm
	(properties
		noun 26
		picture 240
		horizon -20
		vanishingY -300
	)

	(method (init)
		(LoadMany rsMESSAGE 240)
		(gWalkHandler addToFront: self)
		(self setRegions: 51) ; bazaarR
		(gEgo
			noun: 2
			init:
			normalize:
			edgeHit: EDGE_NONE
			scaleSignal: 1
			scaleX: 120
			scaleY: 120
		)
		(if (or gNight (IsFlag 135))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 283 189 239 149 319 137
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 95 0 0 319 0 319 104 284 104 255 89 230 104 128 118 109 108 52 114
						yourself:
					)
			)
			(if (and (> gDay 4) (not (IsFlag 172)))
				(|= local11 $2000)
				(if (and (!= global451 gDay) (IsFlag 40))
					(if (IsFlag 46)
						(SetFlag 47)
					else
						(SetFlag 46)
					)
				)
				(gEgo code: nightCode)
				((ScriptID 241 0) ; aHarami
					view: 954
					loop: 1
					cel: 0
					x: 149
					y: 105
					init:
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
				)
				(= [local95 0] @local26)
				(nightTell init: gEgo @local26 @local95)
			else
				(gEgo code: nightCodeX)
			)
		else
			(if (!= (gLongSong2 number:) 924)
				(gLongSong2 number: 924 setLoop: -1 play: 127)
			)
			(cond
				(
					(or
						(and
							(!= (gLongSong number:) 923)
							(!= (gLongSong number:) 230)
						)
						(and
							(== (gLongSong number:) 923)
							(== (gLongSong prevSignal:) -1)
						)
					)
					(gLongSong setLoop: -1 number: 923 play: 60)
				)
				((!= (gLongSong number:) 230)
					(gLongSong fade: 60 10 5 0)
				)
				(else
					(gLongSong client: self)
				)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 240 189 141 189 114 165 218 150 262 186
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 273 189 236 146 319 137
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 100 0 0 319 0 319 98 291 102 270 93 271 105 187 117 51 117
						yourself:
					)
			)
			(= [local91 0] @local17)
			(egoTell init: gEgo @local17 @local91)
			(= [local118 0] @local66)
			(junkTell init: aSanford @local66 @local118)
			(= [local108 0] @local85)
			(oilTell init: aOilSeller @local85 @local108)
			(= [local103 0] @local50)
			(= [local103 1] @local56)
			(= [local103 2] @local56)
			(weaponTell init: aWeaponSeller @local50 @local103 @local63)
			(= [local113 0] @local72)
			(= [local113 1] @local78)
			(honeyTell init: aHoneySeller @local72 @local113 @local82)
			(gEgo code: bazCode)
			(mooseHead init: addToPic:)
			(if (and (== gHeroType 2) (not (IsFlag 147))) ; Thief
				(blackBird init: stopUpd:)
			)
			(spearsLeft setPri: 7 init: addToPic:)
			(spearsRight setPri: 8 init: addToPic:)
			(junkRight setPri: 0 init: addToPic:)
			(honeyOnShelf setPri: 11 init: addToPic:)
			(oilRug setPri: 0 init: addToPic:)
			(oilBottles setPri: 14 init: addToPic:)
			(= [local12 0] (aWeaponSeller init:))
			(aSanford init: stopUpd:)
			(= [local12 1] (aSon init:))
			(= [local12 2] (aHoneySeller init:))
			(= [local12 3] (aOilSeller init:))
			(aWeaponSeller stopUpd:)
			(aSon stopUpd:)
			(aHoneySeller stopUpd:)
			(aOilSeller stopUpd:)
			(leftoilbottles init:)
			(bigoilbottle init:)
			(rightoilbottles init:)
			(oilrug init:)
			(weapon_stand init:)
			(honeystand init:)
			(pansonrope init:)
			(leftjunk init:)
			(junkdealertent init:)
			(purplepot init:)
			(platerows init:)
			(righttable init:)
			(largeurns init:)
		)
		(super init: &rest)
		(HandsOn)
		(switch gPrevRoomNum
			(230
				(= style -32759)
				(if (and (< gDay 5) (IsFlag 22) (not (IsFlag 36)))
					((ScriptID 241 0) init: addToPic:) ; aHarami
					((View new:)
						view: 240
						loop: 2
						cel: 1
						x: 146
						y: 117
						init:
						addToPic:
					)
					(aWeaponSeller addToPic:)
					(aSon addToPic:)
					(aHoneySeller addToPic:)
					(aOilSeller addToPic:)
					(aSanford addToPic:)
					(self setScript: thiefChase self)
				else
					(self setScript: from230)
				)
			)
			(250
				(= style -32761)
				(self setScript: from250)
			)
			(270
				(= style -32761)
				(self setScript: from270)
			)
			(else
				(gEgo x: 35 y: 120)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun 1 0 (if gNight 0 else 1))
			)
			(3 ; Walk
				(if (& local11 $2000)
					(if (and ((ScriptID 241 0) cycler:) (& local11 $1000)) ; aHarami
						(&= local11 $efff)
						((ScriptID 241 0) setCycle: Beg) ; aHarami
					)
					(if (and (not (IsFlag 113)) (not local10))
						(= local10 1)
						(gMessager say: 9 6 93) ; "Hey, wait! Don't just go. You can't do that to me! Help me!"
					)
				else
					(if (self script:)
						(self script: 0)
						(aWeaponSeller setCycle: End setLoop: 2)
					)
					(if (CueObj theVerb:)
						(CueObj theVerb: 0)
					)
					(if local1
						(gMessager say: local1 6 10 0 aSon)
					)
				)
				(gEgo
					setMotion:
						PolyPath
						((User curEvent:) x:)
						((User curEvent:) y:)
						aWeaponSeller
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (gLongSong2 number:) 231)
			(gLongSong pause: 0)
			(gLongSong2 client: 0 number: 924 setLoop: -1 play: 127)
		)
	)

	(method (dispose)
		(= global451 gDay)
		(ClearFlag 113)
		(if local5
			(local5 dispose:)
		)
		(if local6
			(local6 dispose:)
		)
		(if local7
			(local7 dispose:)
		)
		(if local8
			(local8 dispose:)
		)
		(gWalkHandler delete: self)
		(UnLoad 143 240)
		(LoadMany 0 47 241 245 246 247 248)
		(super dispose:)
	)
)

(instance haramiBeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 159)
				(switch gPrevRoomNum
					(270
						(gEgo setMotion: PolyPath 220 111 self)
					)
					(230
						(gEgo setMotion: PolyPath 20 115 self)
					)
					(250
						(gEgo setMotion: PolyPath 87 175 self)
					)
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(cond
					((IsFlag 47)
						(SetFlag 172)
						(gMessager say: 9 6 7 0 self) ; "Geeze, I thought you was never coming back. Who am I supposed to talk to if you go out and get yourself eaten by some Leopardman? You're the only one I got now."
					)
					((IsFlag 46)
						(gMessager say: 9 6 6 0 self) ; "I never thought I'd be glad to see someone who helped me get caught, but, man, am I glad to see you. You gotta help me."
					)
					((IsFlag 40)
						(gMessager say: 9 6 75 0 self) ; "You came! You don't know how glad I am to see you, just to have someone to talk to. You have no idea how terrible it is to be without honor in Tarna."
					)
					(else
						(gMessager say: 9 6 62 0 self) ; "You! You've got to help me. Please help. No one around here is allowed to talk to me. I can't buy anything, no one will take my money. You can't imagine how bad it is to be considered 'without honor' in this place."
						(SetFlag 40)
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance weaponSellerFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (aWeaponSeller cycler:)
					(= local0 1)
				)
				(aWeaponSeller setCycle: Beg self)
				(gEgo setMotion: 0)
				(aSon setCycle: 0)
			)
			(1
				(Face gEgo aWeaponSeller)
				(= cycles (+ (gEgo cycleSpeed:) 15))
			)
			(2
				(gMessager say: 1 6 1 1 self) ; "Ah, I see that you are in need of a new weapon. I have one just right for you!"
			)
			(3
				(aWeaponSeller setLoop: 2 cel: 6 setCycle: CT 3 -1 self)
			)
			(4
				(gMessager say: 1 6 3 0 self) ; "Here is the finest of daggers! It too is made of Damascus steel. It too is sharper than a serpent's tooth. It is small enough to be concealed up your sleeve, to be ready when your foe least expects it."
			)
			(5
				(aWeaponSeller cel: 0 setCycle: End self)
			)
			(6
				(HandsOn)
				(localproc_1 1)
				(SetFlag 106)
				(aWeaponSeller stopUpd:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance thiefChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: -20 y: 110 code: 0 setMotion: PolyPath 85 120 self)
			)
			(1
				(= cycles 5)
			)
			(2
				(gMessager say: 8 6 47 0 self) ; "Please accompany us to the Hall of Judgement."
			)
			(3
				(HandsOff)
				(gLongSong2 fade:)
				(gLongSong3 fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance aSonGreeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(= cycles 5)
			)
			(1
				(Face gEgo aSanford)
				(= cycles (+ (gEgo cycleSpeed:) 15))
			)
			(2
				(aSanford setCycle: End self)
			)
			(3
				(gMessager say: 7 6 62 0 self) ; "Hello, young man. You look like you could use some of our mostly-new items."
			)
			(4
				(localproc_1 7)
				(aSanford setCycle: CT 0 -1 self)
			)
			(5
				(HandsOn)
				(aSanford stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance from230 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: -30 y: 70)
				((ScriptID 241 0) setLoop: 0) ; aHarami
				(= cycles 5)
			)
			(1
				(if (& local11 $2000)
					(cond
						((IsFlag 47)
							(= [local99 0] @local45)
							(haramiTell init: (ScriptID 241 0) @local45 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						((IsFlag 46)
							(|= local11 $0020)
							(= [local99 0] @local40)
							(haramiTell init: (ScriptID 241 0) @local40 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						(else
							(|= local11 $0010)
							(= [local99 0] @local33)
							(haramiTell init: (ScriptID 241 0) @local33 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
					)
				)
				(self cue:)
			)
			(2
				(gEgo setMotion: PolyPath 20 115 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance from250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 130 y: 250)
				((ScriptID 241 0) setLoop: 0) ; aHarami
				(= cycles 5)
			)
			(1
				(if (& local11 $2000)
					(cond
						((IsFlag 47)
							(= [local99 0] @local45)
							(haramiTell init: (ScriptID 241 0) @local45 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						((IsFlag 46)
							(|= local11 $0020)
							(= [local99 0] @local40)
							(haramiTell init: (ScriptID 241 0) @local40 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						(else
							(|= local11 $0010)
							(= [local99 0] @local33)
							(haramiTell init: (ScriptID 241 0) @local33 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
					)
				)
				(self cue:)
			)
			(2
				(gEgo setMotion: PolyPath 87 175 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance from270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 330 y: 120)
				(= cycles 5)
			)
			(1
				(if (& local11 $2000)
					(cond
						((IsFlag 47)
							(= [local99 0] @local45)
							(haramiTell init: (ScriptID 241 0) @local45 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						((IsFlag 46)
							(|= local11 $0020)
							(= [local99 0] @local40)
							(haramiTell init: (ScriptID 241 0) @local40 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
						(else
							(|= local11 $0010)
							(= [local99 0] @local33)
							(haramiTell init: (ScriptID 241 0) @local33 @local99) ; aHarami
							(gCurRoom setScript: haramiBeg)
						)
					)
				)
				(self cue:)
			)
			(2
				(gEgo setMotion: PolyPath 300 115 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance begSecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(Face gEgo (ScriptID 241 0)) ; aHarami
				(= cycles (+ (gEgo cycleSpeed:) 15))
			)
			(1
				(gMessager say: 9 6 92 0 self) ; "Ya gotta help me."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((<= (gEgo x:) 5)
						(= register 230)
						(gEgo setMotion: PolyPath -30 (gEgo y:) self)
					)
					((<= (gEgo y:) 5)
						(= register 230)
						(gEgo setMotion: PolyPath (gEgo x:) -30 self)
					)
					((>= (gEgo x:) 315)
						(if
							(and
								gNight
								(not (IsFlag 113))
								(& local11 $2000)
							)
							(gEgo addHonor: -50)
						)
						(= register 270)
						(gLongSong fade:)
						(gLongSong2 fade:)
						(gEgo setMotion: PolyPath 340 (gEgo y:) self)
					)
					((>= (gEgo y:) 183)
						(= register 250)
						(gEgo setMotion: PolyPath (gEgo x:) 240 self)
					)
				)
			)
			(1
				(gCurRoom newRoom: register)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bazCode of Code
	(properties)

	(method (doit)
		(if local0
			(localproc_0)
		)
		(cond
			((gCurRoom script:) 0)
			((not (< 5 (gEgo x:) 315))
				(gCurRoom setScript: sExit)
			)
			((not (< 5 (gEgo y:) 183))
				(gCurRoom setScript: sExit)
			)
			((< (gEgo distanceTo: aWeaponSeller) 45)
				(aWeaponSeller setCycle: 0)
				(if (and (not (IsFlag 106)) (not local16))
					(= local16 1)
					(aWeaponSeller setCycle: 0)
					(gCurRoom setScript: weaponSellerFirst)
				)
			)
			((< (gEgo distanceTo: aSanford) 25)
				(if (!= (gLongSong2 number:) 231)
					(gLongSong pause: 1)
					(gLongSong2 client: 0 number: 231 setLoop: -1 play:)
				)
				(cond
					((not (IsFlag 107))
						(SetFlag 107)
						(gCurRoom setScript: aSonGreeting)
					)
					((not (& local11 $0001))
						(|= local11 $0001)
						(= local1 (aSanford noun:))
						(gEgo setMotion: 0)
						(aSanford newGreeting:)
					)
				)
			)
			((< (gEgo distanceTo: aHoneySeller) 40)
				(aHoneySeller setCycle: 0)
				(if (not (& local11 $0002))
					(|= local11 $0002)
					(gEgo setMotion: 0)
					(= local1 (aHoneySeller noun:))
					(aHoneySeller newGreeting:)
				)
			)
			((< (gEgo distanceTo: aSon) 17)
				(if (!= (gLongSong2 number:) 231)
					(gLongSong pause: 1)
					(gLongSong2 client: 0 number: 231 setLoop: -1 play:)
				)
				(cond
					((not (IsFlag 107))
						(SetFlag 107)
						(gCurRoom setScript: aSonGreeting)
					)
					((not (& local11 $0004))
						(|= local11 $0004)
						(gEgo setMotion: 0)
						(= local1 (aSanford noun:))
						(aSanford newGreeting:)
					)
				)
			)
			((< (gEgo distanceTo: aOilSeller) 33)
				(aOilSeller setCycle: 0)
				(if (not (& local11 $0008))
					(|= local11 $0008)
					(gEgo setMotion: 0)
					(= local1 (aOilSeller noun:))
					(aOilSeller newGreeting:)
				)
			)
			((and (== (gLongSong2 number:) 231) (== (gLongSong2 client:) 0))
				(gLongSong2 fade: 60 5 5 0 gCurRoom)
			)
		)
	)
)

(instance nightCode of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((not (< 5 (gEgo x:) 315))
				(gCurRoom setScript: sExit)
			)
			((not (< 5 (gEgo y:) 183))
				(gCurRoom setScript: sExit)
			)
			((< (gEgo distanceTo: (ScriptID 241 0)) 30) ; aHarami
				(if (& local11 $0100)
					0
				else
					(|= local11 $0100)
					((ScriptID 241 0) setCycle: Fwd) ; aHarami
					(|= local11 $1000)
					(= local10 0)
					(gCurRoom setScript: begSecond)
				)
			)
		)
	)
)

(instance nightCodeX of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((not (< 5 (gEgo x:) 315))
				(gCurRoom setScript: sExit)
			)
			((not (< 5 (gEgo y:) 183))
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance aWeaponSeller of MerchantActor
	(properties
		x 62
		y 82
		noun 1
		approachDist 50
		view 325
		loop 2
		signal 16384
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
		(return self)
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)

	(method (cue)
		(if (& local11 $0100)
			(&= local11 $feff)
		)
	)

	(method (newGreeting)
		(switch (mod gDay 6)
			(0
				(gMessager say: noun 6 4 0 aSon) ; "Bwana, perhaps you will need a new throwing dagger today?"
			)
			(1
				(gMessager say: noun 6 5 0 aSon) ; "Mighty warrior, you surely need a sharper weapon to use against the nasty monsters which lurk outside the walls of Tarna?"
			)
			(2
				(gMessager say: noun 6 6 0 aSon) ; "Bwana! You are just the man I wished to see! I have in stock some new spears that sail through the sky like a bird of prey, then strike deeply to the very heart of the target."
			)
			(3
				(gMessager say: noun 6 7 0 aSon) ; "You, I say, you! This is your lucky day. Make me an offer upon these fine weapons! You cannot go wrong."
			)
			(4
				(gMessager say: noun 6 8 0 aSon) ; "Bwana! I knew you would be back to buy a new weapon. You know quality when you are seeing it!"
			)
			(5
				(gMessager say: noun 6 9 0 aSon) ; "The weapon master has returned! May I have the honor and pleasure of selling one of my very fine weapons to you?"
			)
		)
	)
)

(instance aSanford of MerchantActor
	(properties
		x 241
		y 85
		noun 7
		approachDist 50
		view 242
		signal 20480
		cycleSpeed 19
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)

	(method (newGreeting)
		(switch (mod gDay 6)
			(0
				(gMessager say: noun 6 4 0 aSon) ; "You there, you going to buy something or am I going to have to charge you for sightseeing?"
			)
			(1
				(gMessager say: noun 6 5 0 aSon) ; "Look at this stuff! You ever see any better partially-used items anywhere?"
			)
			(2
				(gMessager say: noun 6 6 0 aSon) ; "You! I can make you a great deal on a hubcap from a fifty-seven chevy. You could make a great shield out of it!"
			)
			(3
				(gMessager say: noun 6 7 0 aSon) ; "Hey you! I can sell you the tape drive from a Banana PC Jr. A gentleman like yourself can certainly use one of those."
			)
			(4
				(gMessager say: noun 6 8 0 aSon) ; "You there! I've got just what you are looking for! An Elvis commemorative feeding trough, audio-graphed by the King, himself."
			)
			(5
				(gMessager say: noun 6 9 0 aSon) ; "Hey there, what do you think you are doing, walking by without spending anything? Get your body over here and buy this genuine can of Erasmus's Rootin' Tootin' Root Beer, the fizz from the Wiz."
			)
		)
	)
)

(instance aSon of MerchantActor
	(properties
		x 209
		y 104
		noun 6
		approachDist 40
		view 244
		loop 2
		signal 16384
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
		(return self)
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)

	(method (cue)
		(localproc_1 local1)
		(= local1 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(junkTell doVerb: theVerb)
			)
		)
	)
)

(instance aHoneySeller of MerchantActor
	(properties
		x 304
		y 167
		noun 4
		approachDist 30
		view 254
		priority 11
		signal 16400
		cycleSpeed 14
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
		(return self)
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)

	(method (newGreeting)
		(switch (mod gDay 6)
			(0
				(gMessager say: noun 6 4 0 aSon) ; "A most glorious and lovely day, kind sir. Can I sweeten your life today?"
			)
			(1
				(gMessager say: noun 6 5 0 aSon) ; "Golden sunshine and the essence of flowers distilled for you pleasure, effendi."
			)
			(2
				(gMessager say: noun 6 6 0 aSon) ; "Honey to sweeten the finest morning."
			)
			(3
				(gMessager say: noun 6 7 0 aSon) ; "Honey! Golden, luscious honey for sale."
			)
			(4
				(gMessager say: noun 6 8 0 aSon) ; "A taste of honey before sleeping will guarantee sweet dreams, effendi."
			)
			(5
				(gMessager say: noun 6 9 0 aSon) ; "Honey for sale. Brighten your day with honey. Tasty honey for sale."
			)
		)
	)
)

(instance aOilSeller of MerchantActor
	(properties
		x 197
		y 182
		noun 5
		approachDist 30
		view 258
		loop 2
		priority 15
		signal 16384
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
		(return self)
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)

	(method (cue)
		([local12 local3] stopUpd:)
		(= local0 1)
	)

	(method (newGreeting)
		(switch (mod gDay 6)
			(0
				(gMessager say: noun 6 4 0 aSon) ; "Oil, sahib, oil of all types and uses. Make your hair stay out of your eyes with oil."
			)
			(1
				(gMessager say: noun 6 5 0 aSon) ; "Olive oil for cooking fine foods. Oil for sale!"
			)
			(2
				(gMessager say: noun 6 6 0 aSon) ; "Oil for stopping the squeak of annoying doors! Oil for sale."
			)
			(3
				(gMessager say: noun 6 7 0 aSon) ; "Oil for sale! Oil for making things slide smoothly. Oil for sale!"
			)
			(4
				(gMessager say: noun 6 8 0 aSon) ; "Oil for lamps! Light up your night! Oil for lamps!"
			)
			(5
				(gMessager say: noun 6 9 0 aSon) ; "Oil for backrubs and other sensual delights! Oil for sale."
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(= local9 (proc51_1))
		(= temp0 (gEgo distanceTo: local9))
		(switch local9
			(aWeaponSeller
				(if (> temp0 45)
					(gMessager say: 3 6 99) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aOilSeller
				(if (> temp0 48)
					(gMessager say: 3 6 99) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aSon
				(if (> temp0 18)
					(gMessager say: 3 6 99) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aHoneySeller
				(if (> temp0 41)
					(gMessager say: 3 6 99) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(else
				(cond
					((> temp0 26)
						(gMessager say: 3 6 99) ; "Which merchant do you want to talk to?"
						(return -999)
					)
					((!= (gLongSong2 number:) 231)
						(gLongSong pause: 1)
						(gLongSong2 client: 0 number: 231 setLoop: -1 play:)
					)
				)
			)
		)
		(if
			(!=
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (local9 x:) (local9 y:))
			)
			(Face gEgo local9)
		)
		((Timer new:) setCycle: self (+ (gEgo cycleSpeed:) 10))
		(= iconValue 0)
		(return -999)
	)

	(method (doChild)
		(switch query
			(-92 ; "Greet"
				(cond
					((== local9 aWeaponSeller)
						(= query 41)
					)
					((== local9 aSon)
						(= query 73)
					)
					((== local9 aSanford)
						(= query 73)
					)
					((== local9 aHoneySeller)
						(= query 50)
					)
					((== local9 aOilSeller)
						(= query 59)
					)
				)
			)
			(-93 ; "Good-bye"
				(cond
					((== local9 aWeaponSeller)
						(= query 42)
					)
					((== local9 aSon)
						(= query 74)
					)
					((== local9 aSanford)
						(= query 74)
					)
					((== local9 aHoneySeller)
						(= query 51)
					)
					((== local9 aOilSeller)
						(= query 60)
					)
				)
			)
			(-105 ; "Make Thief's Sign"
				(cond
					((== local9 aWeaponSeller)
						(= query 87)
					)
					((== local9 aSon)
						(= query 88)
					)
					((== local9 aSanford)
						(= query 88)
					)
					((== local9 aHoneySeller)
						(= query 89)
					)
					((== local9 aOilSeller)
						(= query 90)
					)
				)
			)
			(-43 ; "Buy a Weapon"
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 1 6 94) ; "Any of these fine forms of steel comfort and protection can be yours if you will but first trade your dinars for Tarna royals at the window of the money changer off to the north."
				else
					(weaponTell doVerb: 10)
				)
				(return 0)
			)
			(-72 ; "Buy Junk Goods"
				(cond
					((== ((gInventory at: 0) message:) 59) ; theRoyals
						(gMessager say: 7 6 94) ; "What's this, dummy? Don't you have any real money? Why am I wasting my time to sell you something when you don't have anything to buy it with?"
					)
					(
						(or
							(and (gEgo has: 9) (!= gHeroType 2)) ; theTinderbox, Thief
							(and
								(== gHeroType 2) ; Thief
								(gEgo has: 9) ; theTinderbox
								(gEgo has: 33) ; theBird
							)
						)
						(gMessager say: 3 6 115) ; "Forget about that junk, it's junk!"
					)
					(else
						(junkTell doVerb: 10)
					)
				)
				(return 0)
			)
			(-97 ; "Buy Honey"
				(cond
					((== ((gInventory at: 0) message:) 59) ; theRoyals
						(gMessager say: 4 6 94) ; "Ahh. I regret that you must first obtain Tarna royals from the money changer at the north end of the bazaar."
					)
					((gEgo has: 29) ; theHoney
						(gMessager say: 3 6 113) ; "Hero, you are sweet enough as it is! You need no more honey."
					)
					(else
						(honeyTell doVerb: 10)
					)
				)
				(return 0)
			)
			(-98 ; "Buy Oil"
				(cond
					((== ((gInventory at: 0) message:) 59) ; theRoyals
						(gMessager say: 5 6 94) ; "Do you seek to insult me with this strange coin? Go to the money changer before you try to buy my oil again."
					)
					((gEgo has: 25) ; theOil
						(gMessager say: 3 6 114) ; "Too much oil isn't good for your cholesterol. Think light!"
					)
					(else
						(oilTell doVerb: 10)
					)
				)
				(return 0)
			)
		)
	)

	(method (cue)
		(= query
			(super
				showDialog:
					-105 ; "Make Thief's Sign"
					(== gHeroType 2) ; Thief
					-97 ; "Buy Honey"
					(== aHoneySeller local9)
					-72 ; "Buy Junk Goods"
					(or (== aSanford local9) (== aSon local9))
					-43 ; "Buy a Weapon"
					(== aWeaponSeller local9)
					-98 ; "Buy Oil"
					(== aOilSeller local9)
			)
		)
		(= local4 1)
		(if iconValue
			(= query iconValue)
		)
		(egoTell respond:)
	)

	(method (respond)
		(if (not local4)
			(super respond:)
		else
			(= local4 0)
			(cond
				((not query)
					(return 1)
				)
				((== query -999)
					(return 1)
				)
				((== query 999)
					(self doParent:)
					(return 0)
				)
				((and (< query 0) (not (self doChild: query)))
					(return 1)
				)
			)
			(if (< query 0)
				(= query (- query))
			)
			(gMessager say: (client noun:) 5 query 0)
			(return 1)
		)
	)
)

(instance nightTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				84 ; "Tell About Mission"
				(or (IsFlag 46) (IsFlag 47))
				-86 ; "Tell about Rakeesh"
				(IsFlag 47)
				-85 ; "Make Thief's Sign"
				(== gHeroType 2) ; Thief
		)
	)

	(method (doChild)
		(switch query
			(-86 ; "Tell about Rakeesh"
				(gEgo solvePuzzle: 221 8)
				(return query)
			)
			(-85 ; "Make Thief's Sign"
				(gEgo solvePuzzle: 229 8)
				(return query)
			)
		)
	)
)

(instance weaponTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (!= local2 1)
			(localproc_1 local2)
			(= local2 1)
		)
		(switch theVerb
			(59 ; theRoyals
				(= local1 1)
				(gMessager say: 1 6 94 0 aSon) ; "Any of these fine forms of steel comfort and protection can be yours if you will but first trade your dinars for Tarna royals at the window of the money changer off to the north."
			)
			(10 ; Money
				(if (not local5)
					((ScriptID 245 1) ; weaponVendor
						goods:
							((List new:)
								add:
									((Class_47_1 new: 29)
										price: 15
										quantity: (if (IsFlag 166) 0 else 1)
									)
									((Class_47_1 new: 30) price: 6 quantity: 26)
									((Class_47_1 new: 31)
										price: 15
										quantity: (if (IsFlag 167) 0 else 1)
									)
							)
					)
					(= local5 ((ScriptID 245 1) goods:)) ; weaponVendor
				else
					((ScriptID 245 1) goods: local5) ; weaponVendor
				)
				((ScriptID 245 1) init: purchase: dispose:) ; weaponVendor
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-100 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 23)
					)
					(1
						(= query 24)
					)
					(2
						(= query 25)
					)
					(3
						(= query 26)
					)
					(4
						(= query 27)
					)
					(5
						(= query 28)
					)
				)
			)
			(-101 ; "Weapon Seller"
				(switch (mod gDay 6)
					(0
						(= query 29)
					)
					(1
						(= query 30)
					)
					(2
						(= query 31)
					)
					(3
						(= query 32)
					)
					(4
						(= query 33)
					)
					(5
						(= query 34)
					)
				)
			)
			(else
				(super doChild: query)
			)
		)
	)
)

(instance junkTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (!= local2 7)
			(localproc_1 local2)
			(= local2 7)
		)
		(switch theVerb
			(59 ; theRoyals
				(= local1 7)
				(gMessager say: 6 6 94 0 aSon) ; "Sorry, but you will need to visit the money changer before you can buy things in Tarna."
			)
			(10 ; Money
				(if
					(or
						(and (gEgo has: 9) (!= gHeroType 2)) ; theTinderbox, Thief
						(and
							(== gHeroType 2) ; Thief
							(gEgo has: 9) ; theTinderbox
							(gEgo has: 33) ; theBird
						)
					)
					(gMessager say: 3 6 115) ; "Forget about that junk, it's junk!"
				else
					(if (not local6)
						((ScriptID 246 2) ; sanfordVendor
							goods:
								((List new:)
									add:
										((Class_47_1 new: 27)
											price: 200
											denomination: 1
											quantity:
												(if (gEgo has: 9) 0 else 1) ; theTinderbox
										)
										((Class_47_1 new: 28)
											price: 40
											denomination: 1
											quantity:
												(if
													(and
														(== gHeroType 2) ; Thief
														(not (IsFlag 147))
													)
													1
												else
													0
												)
										)
								)
						)
						(= local6 ((ScriptID 246 2) goods:)) ; sanfordVendor
					else
						((ScriptID 246 2) goods: local6) ; sanfordVendor
					)
					((ScriptID 246 2) init: purchase: dispose:) ; sanfordVendor
					(if (and (== gHeroType 2) (IsFlag 147)) ; Thief
						(blackBird dispose:)
					)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-100 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 23)
					)
					(1
						(= query 24)
					)
					(2
						(= query 25)
					)
					(3
						(= query 26)
					)
					(4
						(= query 27)
					)
					(5
						(= query 28)
					)
				)
			)
			(-101 ; "Junk Dealers"
				(switch (mod gDay 6)
					(0
						(= query 64)
					)
					(1
						(= query 65)
					)
					(2
						(= query 66)
					)
					(3
						(= query 67)
					)
					(4
						(= query 68)
					)
					(5
						(= query 69)
					)
				)
			)
		)
	)
)

(instance honeyTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (!= local2 4)
			(localproc_1 local2)
			(= local2 4)
		)
		(switch theVerb
			(59 ; theRoyals
				(= local1 4)
				(gMessager say: 4 6 94 0 aSon) ; "Ahh. I regret that you must first obtain Tarna royals from the money changer at the north end of the bazaar."
			)
			(10 ; Money
				(if (gEgo has: 29) ; theHoney
					(gMessager say: 3 6 113) ; "Hero, you are sweet enough as it is! You need no more honey."
				else
					(if (not local7)
						((ScriptID 247 1) ; honeyVendor
							goods:
								((List new:)
									add:
										((Class_47_1 new: 4)
											price: 80
											denomination: 1
											quantity:
												(if (gEgo has: 29) 0 else 1) ; theHoney
										)
								)
						)
						(= local7 ((ScriptID 247 1) goods:)) ; honeyVendor
					else
						((ScriptID 247 1) goods: local7) ; honeyVendor
					)
					((ScriptID 247 1) init: purchase: dispose:) ; honeyVendor
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-91 ; "Honey Bird"
				(SetFlag 83)
				(return query)
			)
			(-100 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 23)
					)
					(1
						(= query 24)
					)
					(2
						(= query 25)
					)
					(3
						(= query 26)
					)
					(4
						(= query 27)
					)
					(5
						(= query 28)
					)
				)
			)
			(-101 ; "Honey Seller"
				(switch (mod gDay 6)
					(0
						(= query 29)
					)
					(1
						(= query 30)
					)
					(2
						(= query 31)
					)
					(3
						(= query 32)
					)
					(4
						(= query 33)
					)
					(5
						(= query 34)
					)
				)
			)
			(else
				(super doChild: query)
			)
		)
	)
)

(instance oilTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (!= local2 5)
			(localproc_1 local2)
			(= local2 5)
		)
		(switch theVerb
			(59 ; theRoyals
				(= local1 5)
				(gMessager say: 5 6 94 0 aSon) ; "Do you seek to insult me with this strange coin? Go to the money changer before you try to buy my oil again."
			)
			(10 ; Money
				(if (gEgo has: 25) ; theOil
					(gMessager say: 3 6 114) ; "Too much oil isn't good for your cholesterol. Think light!"
				else
					(if (not local8)
						((ScriptID 248 1) ; oilVendor
							goods:
								((List new:)
									add:
										((Class_47_1 new: 5)
											price: 100
											denomination: 1
											quantity:
												(if (gEgo has: 25) 0 else 1) ; theOil
										)
								)
						)
						(= local8 ((ScriptID 248 1) goods:)) ; oilVendor
					else
						((ScriptID 248 1) goods: local8) ; oilVendor
					)
					((ScriptID 248 1) init: purchase: dispose:) ; oilVendor
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-100 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 23)
					)
					(1
						(= query 24)
					)
					(2
						(= query 25)
					)
					(3
						(= query 26)
					)
					(4
						(= query 27)
					)
					(5
						(= query 28)
					)
				)
			)
			(-101 ; "Oil Merchant"
				(switch (mod gDay 6)
					(0
						(= query 53)
					)
					(1
						(= query 54)
					)
					(2
						(= query 55)
					)
					(3
						(= query 56)
					)
					(4
						(= query 57)
					)
					(5
						(= query 58)
					)
				)
			)
		)
	)
)

(instance spearsLeft of View
	(properties
		x 31
		y 78
		noun 11
		view 240
		signal 20480
	)
)

(instance spearsRight of View
	(properties
		x 88
		y 98
		view 240
		cel 1
		signal 20480
	)

	(method (doVerb theVerb)
		(weapon_stand doVerb: theVerb)
	)
)

(instance junkRight of View
	(properties
		x 119
		y 41
		view 240
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(junktable doVerb: theVerb)
	)
)

(instance mooseHead of View
	(properties
		x 113
		y 80
		noun 33
		view 240
		loop 2
		signal 16384
	)
)

(instance blackBird of Prop
	(properties
		x 222
		y 76
		noun 28
		view 241
		priority 6
		signal 16
	)
)

(instance honeyOnShelf of View
	(properties
		x 287
		y 143
		view 240
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(honeystand doVerb: theVerb)
	)
)

(instance oilRug of View
	(properties
		x 117
		y 154
		view 240
		loop 1
		cel 1
		signal 16384
	)
)

(instance oilBottles of View
	(properties
		x 228
		y 170
		view 240
		loop 1
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(rightoilbottles doVerb: theVerb)
	)
)

(instance haramiTell of Teller
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((OneOf theVerb 27 29 40 28 24) ; theFish, theFruit, theHoney, theMeat, theRations
				(= temp0
					(switch theVerb
						(24 14) ; theRations
						(29 19) ; theFruit
						(40 29) ; theHoney
						(28 18) ; theMeat
						(27 17) ; theFish
					)
				)
				(gEgo drop: temp0 1)
				(SetFlag 113)
				(gEgo addHonor: 10)
				(if ((ScriptID 241 0) cycler:) ; aHarami
					((ScriptID 241 0) setCycle: Beg) ; aHarami
				)
				(gMessager say: 9 6 10) ; "Thanks, pal."
			)
			((OneOf theVerb 59 10) ; theRoyals, Money
				(gEgo addHonor: 5)
				(if ((ScriptID 241 0) cycler:) ; aHarami
					((ScriptID 241 0) setCycle: Beg) ; aHarami
				)
				(gMessager say: 9 6 112) ; "It's not like me to refuse easy money, but I got no use for it. No one will let me buy anything anyway."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftoilbottles of Feature
	(properties
		x 148
		y 199
		z 30
		noun 12
		nsTop 164
		nsLeft 138
		nsBottom 175
		nsRight 158
	)
)

(instance bigoilbottle of Feature
	(properties
		x 160
		y 183
		noun 13
		nsTop 177
		nsLeft 153
		nsBottom 189
		nsRight 167
	)
)

(instance rightoilbottles of Feature
	(properties
		x 228
		y 193
		z 30
		noun 14
		nsTop 157
		nsLeft 222
		nsBottom 169
		nsRight 234
	)
)

(instance oilrug of Feature
	(properties
		x 189
		y 175
		noun 15
		nsTop 162
		nsLeft 124
		nsBottom 189
		nsRight 254
	)
)

(instance weapon_stand of Feature
	(properties
		x 72
		y 73
		noun 16
		nsTop 48
		nsLeft 34
		nsBottom 99
		nsRight 111
	)
)

(instance honeystand of Feature
	(properties
		x 290
		y 128
		noun 17
		nsTop 98
		nsLeft 262
		nsBottom 159
		nsRight 319
	)
)

(instance pansonrope of Feature
	(properties
		x 153
		y 66
		noun 24
		nsTop 50
		nsLeft 116
		nsBottom 82
		nsRight 191
	)
)

(instance leftjunk of Feature
	(properties
		x 165
		y 95
		noun 19
		nsTop 83
		nsLeft 146
		nsBottom 107
		nsRight 185
	)
)

(instance junktable of Feature
	(properties
		x 238
		y 86
		noun 20
		nsTop 75
		nsLeft 220
		nsBottom 98
		nsRight 257
	)
)

(instance junkdealertent of Feature
	(properties
		x 199
		y 52
		noun 18
		nsTop 17
		nsLeft 109
		nsBottom 87
		nsRight 289
	)
)

(instance purplepot of Feature
	(properties
		x 253
		y 63
		noun 25
		nsTop 52
		nsLeft 247
		nsBottom 74
		nsRight 260
	)
)

(instance platerows of Feature
	(properties
		x 270
		y 53
		noun 21
		nsTop 44
		nsLeft 261
		nsBottom 63
		nsRight 279
	)
)

(instance righttable of Feature
	(properties
		x 275
		y 69
		noun 22
		nsTop 63
		nsLeft 262
		nsBottom 75
		nsRight 289
	)
)

(instance largeurns of Feature
	(properties
		x 304
		y 77
		noun 23
		nsTop 64
		nsLeft 290
		nsBottom 90
		nsRight 319
	)
)

