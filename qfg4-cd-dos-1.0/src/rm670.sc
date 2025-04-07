;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Interface)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm670 0
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
	local9
	local10
	local11
	local12
	local13
	local14
	local15
)

(instance rm670 of GloryRm
	(properties
		noun 15
		picture 670
		west 661
	)

	(method (init)
		(gGlory handsOff:)
		(if gDebugging
			(if (== (= local0 (GetNumber {Event #?})) 2)
				(= gPrevRoomNum 680)
			)
		else
			(= local0
				(cond
					((== gPrevRoomNum 680) 2)
					((!= gPrevRoomNum 628) 1)
					(else 0)
				)
			)
		)
		(gLongSong number: 670 setLoop: -1 play:)
		(switch gPrevRoomNum
			(680
				(ClearFlag 35)
				(if (IsFlag 235)
					(gEgo
						view: 671
						setLoop: 0 1
						setCel: 0
						posn: 188 115
						init:
						ignoreActors:
						setPri: 152
						setScaler: Scaler 82 60 114 101
						setScript: sKatrinaHere
					)
					(heroTeller init: gEgo 670 18 128 2)
					(pKatrina init: setScaler: Scaler 82 60 114 101)
				else
					(gEgo
						posn: 261 99
						init:
						setScaler: Scaler 82 60 114 101
						normalize:
						setScript: sComeOnIn
					)
				)
			)
			(else
				(gEgo
					view: 35
					setLoop: 3 1
					setCel: 5
					posn: 188 123
					setPri: 174
					init:
					setScaler: Scaler 82 60 114 101
				)
				(gMouseDownHandler addToFront: fPlatform self)
				(gKeyDownHandler addToFront: fPlatform self)
				(gWalkHandler addToFront: self)
				(= local4 1)
				(pAdavis init: setPri: 174)
				(gCurRoom setScript: sAdavisHere)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 15 90 18 99 44 150 64 166 122 180 319 178 619 489 -300 489 -300 -300 419 -1 619 124 271 108 239 105 155 82 62 78 66 82 106 87 174 102 173 113 249 113 250 145 235 152 139 152 122 133 93 126 95 132 105 142 113 151 124 158 147 160 175 168 176 172 153 170 132 169 112 164 97 155 78 137 71 113 64 90
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 185 102 205 102 205 109 185 109
					yourself:
				)
		)
		(pMainDoor init: approachVerbs: 4) ; Do
		(pIMLDoor init: approachVerbs: 4) ; Do
		(pIMRDoor init: approachVerbs: 4) ; Do
		(vBackGround ignoreActors: approachVerbs: 4 init:) ; Do
		(if (not (gEgo has: 50)) ; theStake
			(vStake init: approachVerbs: 4) ; Do
		)
		(if (not (gEgo has: 49)) ; theHammer
			(vHammer init: approachVerbs: 4) ; Do
		)
		(vChain1 init: ignoreActors:)
		(vChain2 init: ignoreActors:)
		(super init: &rest)
		(fCreatures init:)
		(fMaiden init: approachVerbs: 4) ; Do
		(fCrane init: approachVerbs: 4) ; Do
		(fGrate init: approachVerbs: 4) ; Do
		(fCollar init: approachVerbs: 4) ; Do
		(fSaw init: approachVerbs: 4) ; Do
		(fCages init: approachVerbs: 4) ; Do
		(fChopBlock init: approachVerbs: 4) ; Do
		(fAxe init: approachVerbs: 4) ; Do
		(fSkeleton1 init:)
		(fSkeleton2 init:)
		(fMace init: approachVerbs: 4) ; Do
		(fPlatform init: approachVerbs: 4) ; Do
	)

	(method (dispose)
		(gMouseDownHandler delete: self fPlatform)
		(gKeyDownHandler delete: self fPlatform)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				local4
				(not (event modifiers:))
				(OneOf (event type:) evKEYBOARD evMOUSEBUTTON)
				(!= ((gTheIconBar getCursor:) view:) 948)
			)
			(cond
				((== ((gTheIconBar getCursor:) view:) 940)
					(event claimed: 1)
					(gMessager say: 17 6 13 1 self) ; "You find yourself chained to the platform by your feet."
				)
				((== ((gTheIconBar getCursor:) view:) 942)
					(event claimed: 1)
					(if (OneOf gHeroType 0 3) ; Fighter, Paladin
						(= local5 1)
						(gCurRoom setScript: sUnlockChains)
					else
						(gMessager say: 14 4 20) ; "You don't have the strength to break the chains."
					)
				)
				(
					(and
						(== ((gTheIconBar getCursor:) view:) 905)
						(== ((gTheIconBar getCursor:) loop:) 4)
						(== ((gTheIconBar getCursor:) cel:) 13)
						(< 169 (event x:) 210)
						(< 88 (event y:) 119)
						(not (gCurRoom script:))
					)
					(event claimed: 1)
					(gCurRoom setScript: sUnlockChains)
				)
				(else
					(event claimed: 0)
					(super handleEvent: event &rest)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 670) ; "You are in a gloomy, foul-smelling room filled with instruments of torture and death."
		)
		(if local4
			(switch theVerb
				(92 ; summonStaffSpell
					(gMessager say: 17 6 33) ; "There is no reason to use that spell here."
				)
				(91 ; jugglingLightsSpell
					(gMessager say: 17 6 33) ; "There is no reason to use that spell here."
				)
				(80 ; openSpell
					(if local6
						(gMessager say: 17 6 31) ; "There is no need to use that spell now."
					else
						(= local6 1)
						(gCurRoom setScript: sUnlockChains)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(92 ; summonStaffSpell
					(gMessager say: 17 6 33) ; "There is no reason to use that spell here."
				)
				(91 ; jugglingLightsSpell
					(gMessager say: 17 6 33) ; "There is no reason to use that spell here."
				)
				(80 ; openSpell
					(if local6
						(gMessager say: 17 6 31) ; "There is no need to use that spell now."
					else
						(= local6 1)
						(gCurRoom setScript: sUnlockChains)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance sGoToSkeleton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if local12
					(gEgo setMotion: PolyPath 214 173 self)
				else
					(gEgo setMotion: PolyPath 58 160 self)
				)
			)
			(1
				(if local12
					(gEgo setLoop: 4 1)
				else
					(gEgo setLoop: 5 1)
				)
				(gEgo normalize:)
				(= ticks 30)
			)
			(2
				(if local12
					(gMessager say: 12 1 0 1 self) ; "It's definitely a skeleton -- make no bones about it!"
				else
					(gMessager say: 11 1 0 1 self) ; "The Borgovs were notoriously sloppy housekeepers."
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUnlockChains of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(cond
					(local6
						(self cue:)
					)
					(local5
						(gMessager say: 14 4 19 1 self) ; "With some effort, you break the rusty chains."
					)
					(else
						(gMessager say: 14 42 0 1 self) ; "You open the lock on the chains easily. It seems your foe has underestimated you once again! It does seem odd that he didn't bother to remove your backpack, though."
					)
				)
			)
			(1
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gWalkHandler delete: self)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 1 1 setCel: 8 posn: 197 125)
				(= cycles 4)
			)
			(3
				(gEgo setCel: 7 posn: 192 121)
				(= cycles 4)
			)
			(4
				(gEgo setCel: 6 posn: 193 122)
				(= cycles 4)
			)
			(5
				(if local5
					(gEgo setCel: 7 posn: 192 121)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(6
				(if local5
					(gEgo setCel: 6 posn: 193 122)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(7
				(if local5
					(gEgo setCel: 7 posn: 192 121)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(8
				(if local5
					(gEgo setCel: 6 posn: 193 122)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(9
				(gEgo setCel: 5 posn: 185 121)
				(= cycles 4)
			)
			(10
				(gEgo setCel: 4 posn: 177 120)
				(= cycles 4)
			)
			(11
				(gEgo setCel: 3 posn: 166 116 setCycle: CT 0 -1 self)
			)
			(12
				(= local4 0)
				(if local6
					(gEgo trySkill: 20) ; openSpell
					(= global441 (gEgo x:))
					(= global442 (gEgo y:))
					(gCurRoom setScript: sCastOpen 0 fPlatform)
				else
					(= local6 1)
					(gCurRoom setScript: sGetDown)
				)
			)
		)
	)
)

(instance sGetDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 188 116
					normalize:
					setPri: 174
					setMotion: MoveTo 168 117 self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setMotion: JumpTo 153 126 self)
			)
			(3
				(gEgo setMotion: MoveTo 140 127 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo setMotion: JumpTo 126 143 self)
			)
			(6
				(gEgo normalize: setMotion: MoveTo 111 146 self)
			)
			(7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 (gEgo cycleSpeed:))
				(gGlory handsOff:)
				(gEgo
					setSpeed: global433
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global441 global442)
						self
				)
			)
			(1
				(gEgo
					view: 14
					loop: 3
					setCel: 0
					posn: 192 115
					setCycle: End self
				)
			)
			(2
				(myProject
					view: 21
					setLoop: 0 1
					x: global441
					y: global442
					setScaler: gEgo
					cycleSpeed: 0
					priority: 207
					init:
					setCycle: Osc 4 self
				)
				(if register
					(= local11 (register onMe: global441 global442))
				)
				(gEgo setCycle: Beg)
				(gLongSong2 number: 934 setLoop: 1 1 play:)
			)
			(3
				(myProject hide:)
				(= ticks 12)
			)
			(4
				(gEgo posn: 188 116 normalize: setPri: 174 setSpeed: local9)
				(gMessager say: 14 80 0 1 self) ; "You open the lock on the chains easily. It seems your foe has underestimated you once again! It does seem odd that he didn't bother to remove your backpack, though."
			)
			(5
				(gCurRoom setScript: sGetDown)
			)
		)
	)
)

(instance sAdavisHere of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 13)
			(if (> (-= register 2) 0)
				(Palette 2 0 255 (-= register 2)) ; PalIntensity
			else
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register 100)
				(= seconds 2)
			)
			(1
				(= seconds 1)
			)
			(2
				(gMessager say: 16 6 10 0 self) ; "You fool! Did you really believe you could get away from me?"
			)
			(3
				(pAdavis view: 675 setCel: 0 setLoop: 1 1 setCycle: CT 7 1 self)
			)
			(4
				(getSound play:)
				(myProject
					view: 673
					setLoop: 0 1
					setCel: 0
					posn: 119 75
					init:
					setCycle: End self
				)
			)
			(5
				(myProject hide: dispose:)
				(pAdavis setCel: 7 setCycle: End self)
			)
			(6
				(pAdavis setCel: 0)
				(= cycles 4)
			)
			(7
				(gMessager say: 17 6 11 1 self) ; "You find yourself falling asleep."
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(pAdavis setCycle: CT 7 1 self)
			)
			(10
				(getSound play:)
				(pAdavis setCel: 7 setCycle: End self)
			)
			(11
				(pAdavis setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(12
				(= seconds 2)
			)
			(13
				(pAdavis hide: dispose:)
			)
			(14
				(= seconds 2)
			)
			(15
				((ScriptID 7 4) init: 17 30) ; fixTime
				(Palette 2 0 255 100) ; PalIntensity
				(= cycles 24)
			)
			(16
				(gMessager say: 17 6 25 1 self) ; "You wake from what you thought was a nightmare only to discover it is only too real."
			)
			(17
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 17 6 12 1 self) ; "You sense the vague impressions of ancient pain and horror in this place. There is also the sense of something Dark and very much alive near you, hungering for you."
				else
					(= seconds 2)
				)
			)
			(18
				(gEgo setCycle: End self)
			)
			(19
				(gGlory handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCreatures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: 0)
				(= ticks 3)
			)
			(1
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 17 6 15 1 self) ; "You sense you are approaching something very dark and very dangerous."
				else
					(self cue:)
				)
			)
			(2
				(= local7 1)
				(pTenacle1 init: setCycle: End)
				(pTenacle2 init: setCycle: End self)
			)
			(3
				(pTenacle1 setCycle: Beg)
				(pTenacle2 setCycle: Beg)
				(gEgo
					setCycle: Rev
					setMotion:
						PolyPath
						(- (gEgo x:) 5)
						(+ (gEgo y:) 15)
						self
				)
			)
			(4
				(gEgo setCycle: 0)
				(cond
					(local8
						(gMessager say: 17 6 18 1 self) ; "The creature retreats under the pool of stagnant water, and you cannot harm him."
					)
					(local7
						(gMessager say: 17 6 17 1 self) ; "There is something large under the water that is either lonely or hungry. You don't want to find out which."
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(= local8 0)
				(gEgo normalize:)
				(DisposeScript 64969)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance castOpenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 1)
				(= local9 (gEgo cycleSpeed:))
				(gEgo trySkill: 20) ; openSpell
				(gGlory handsOff:)
				(gEgo
					setSpeed: global433
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global441 global442)
						self
				)
			)
			(1
				(= local10 (gEgo loop:))
				(gEgo view: 14 loop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(openEffect
					x: global441
					y: global442
					setScaler: gEgo
					cycleSpeed: 0
					priority: 207
					init:
					setCycle: Osc 4 self
				)
				(gEgo setCycle: Beg)
				(gLongSong2 number: 934 setLoop: 1 1 play:)
			)
			(3
				(openEffect dispose:)
				(= cycles 2)
			)
			(4
				(gEgo setSpeed: local9 normalize: local10)
				(self setScript: sEnterMaiden)
			)
		)
	)

	(method (dispose)
		(= local11 (= register 0))
		(super dispose:)
	)
)

(instance sEnterMaiden of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creakDoorSound play:)
				(pIMLDoor setCycle: End)
				(pIMRDoor setCycle: End self)
			)
			(1
				(if (OneOf gPrevRoomNum 680 628)
					(self cue:)
				else
					(gMessager say: 5 4 0 1 self) ; "Now that you look closely, there does seem to be something a bit odd about the design of the Iron Maiden. You take a deep breath and step inside."
				)
			)
			(2
				(if local14
					(gEgo setMotion: PolyPath 253 107 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setMotion: MoveTo 256 101 self)
			)
			(4
				(gEgo setPri: 53)
				(creakDoorSound play:)
				(pIMLDoor setCycle: Beg)
				(pIMRDoor setCycle: Beg self)
			)
			(5
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance sDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(switch local2
					(0
						(gMessager say: 4 4 0 0 self) ; "It's barred on the other side but you can see and hear the two guards through a peephole in the door."
						(++ local2)
					)
					(1
						(gMessager say: 19 6 26 0 self) ; "What I don't get is why de Adda Bees guy brings da stake down dere. Why give a weapon to de enemy, even if you gots him chained up?"
						(++ local2)
					)
					(else
						(gMessager say: 17 6 16 3 self) ; "You hear only heavy breathing out there now."
					)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoorScript1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 17 6 14 0 self) ; "You hear the sound of voices on the other side of the door."
				((pMainDoor heading:) dispose:)
				(pMainDoor heading: 0)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: 176 152
					setCycle: CT 2 1 self
				)
			)
			(1
				(if local3
					(vHammer hide: dispose:)
				else
					(vStake hide: dispose:)
				)
				(= ticks 6)
			)
			(2
				(if local3
					(gMessager say: 20 4 0 1 self) ; "You pick up the heavy hammer and store it in your pack."
				else
					(gMessager say: 21 4 0 1 self) ; "You take the wooden stake and stake its claim in your pack."
				)
			)
			(3
				(getSound play:)
				(gEgo setCycle: CT 0 -1 self)
			)
			(4
				(gEgo get: (if local3 49 else 50) posn: 183 152 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFetch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(vHammer hide: dispose:)
					(gMessager say: 20 87 0 1 self) ; "You fetch the hammer and put it away."
				else
					(vStake hide: dispose:)
					(gMessager say: 21 87 0 1 self) ; "You Fetch the stake and put it in your pack."
				)
			)
			(1
				(getSound play:)
				(gEgo get: (if local3 49 else 50))
				(= ticks 6)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pIMLDoor setCycle: End)
				(pIMRDoor setCycle: End self)
			)
			(1
				(creakDoorSound play:)
				(gEgo setMotion: MoveTo 255 118 self)
			)
			(2
				(creakDoorSound play:)
				(pIMLDoor setCycle: Beg)
				(pIMRDoor setCycle: Beg self)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKatrinaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 6 1 0 self) ; "How dare you! You break into my home, steal away my child, kill my servant Toby, and then return to kill me! After I befriended you and helped you. Some Hero you are!"
			)
			(2
				(whipSound play:)
				(pKatrina setCycle: End self)
			)
			(3
				(pKatrina setScript: sWhipIt)
				(katrinaTeller init: pKatrina 670 18 127 2)
				(gGlory handsOn:)
				(gTheIconBar disable: 0 2 4 5 6 7)
				(self dispose:)
			)
		)
	)
)

(instance sWhipIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(whipSound play:)
				(client setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sFirstFavor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(heroTeller dispose:)
				(katrinaTeller dispose:)
				(= seconds 4)
			)
			(1
				(switch local13
					(1
						(gMessager say: 18 128 21 0 self) ; "Right. Do you really expect me to believe you? I bet you say that to every girl who chains you up and holds a whip."
					)
					(2
						(gMessager say: 18 128 22 0 self) ; "Tell me you love me and then try to put a stake in my heart, no doubt."
					)
					(3
						(gMessager say: 18 128 7 0 self) ; "You tell how you returned the child to her parents and how happy she is now."
					)
					(4
						(gMessager say: 18 128 3 0 self) ; "You tell her about how Ad Avis brought you here and set you up."
					)
					(5
						(gMessager say: 18 128 5 0 self) ; "You tell Katrina how you are a Hero, and a Hero's got to do what a Hero's got to do."
					)
					(else
						(gMessager say: 18 128 4 0 self) ; "You ask Katrina not to hurt you."
					)
				)
			)
			(2
				(katrinaTeller2 init: pKatrina 670 18 127 3)
				(heroTeller2 init: gEgo 670 18 128 3)
				(= seconds 1)
			)
			(3
				(gGlory handsOn:)
				(gTheIconBar disable: 0 2 4 5 6 7)
				(self dispose:)
			)
		)
	)
)

(instance sDoFavor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(heroTeller2 dispose:)
				(katrinaTeller2 dispose:)
				(= seconds 4)
			)
			(1
				(switch local13
					(1
						(gMessager say: 18 128 23 0 self) ; "Liar! You think I am stupid enough to believe you? Love, hah! You stole from me the only one who ever really loved me - Tanya. Is that how you show your love?"
					)
					(2
						(gMessager say: 18 128 24 0 self) ; "You have no idea how many men have said those words to me before. 'Katrina, you're so beautiful. Katrina, I love you.' Always they lie and try to use me."
					)
					(3
						(gMessager say: 18 128 7 0 self) ; "You tell how you returned the child to her parents and how happy she is now."
					)
					(4
						(gMessager say: 18 128 6 0 self) ; "You try to explain what you are doing in Katrina's bedroom."
					)
					(5
						(gMessager say: 18 128 8 0 self) ; "You apologize profusely for disturbing Katrina's rest."
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(katrinaTeller3 init: pKatrina 670 18 127 22)
				(heroTeller3 init: gEgo 670 18 128 22)
				(gMessager say: 1 6 29 0 self) ; "I have decided that I still have a use for you... alive."
			)
			(3
				(gGlory handsOn:)
				(gTheIconBar disable: 0 2 4 5 6 7)
				(self dispose:)
			)
		)
	)
)

(instance sGoTo600 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(pKatrina ignoreActors: setScript: 0)
				(gMessager say: 18 128 28 0 self) ; "You tell Katrina you'll do anything if she'll just let you go and not rip your throat out."
			)
			(1
				(SetFlag 110)
				(= global459 gDay)
				(pKatrina view: 638 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				(getSound play:)
				(pKatrina setCycle: Beg)
				(myProject
					view: 21
					setLoop: 4 1
					setCel: 0
					posn: 155 83
					init:
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 187 79 self
				)
			)
			(3
				(gMessager say: 1 6 30 0 self) ; "By my Will, I Geas thee!"
			)
			(4
				(myProject hide:)
				(pKatrina setCel: 0 setCycle: End self)
			)
			(5
				(getSound play:)
				(pKatrina setCycle: Beg)
				(myProject
					posn: 155 83
					setCel: 0
					show:
					setCycle: Fwd
					setMotion: MoveTo 187 79 self
				)
			)
			(6
				(myProject hide:)
				(= ticks 6)
			)
			(7
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance sChangeScalerUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScaler: Scaler 82 82 175 90)
				(self cue:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sChangeScalerDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScaler: Scaler 82 60 114 101)
				(self cue:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance myProject of Actor
	(properties
		x 119
		y 75
		priority 185
		fixPriority 1
		view 673
		signal 16385
	)
)

(instance pKatrina of Prop
	(properties
		noun 1
		x 149
		y 130
		priority 163
		fixPriority 1
		view 638
		signal 16385
	)
)

(instance pIMLDoor of Prop
	(properties
		noun 5
		approachX 253
		approachY 107
		x 257
		y 103
		view 670
		loop 4
		signal 16385
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not local4)) ; Do
				(gCurRoom setScript: sEnterMaiden)
			)
			((== theVerb -80) ; openSpell (part 2)
				(gMessager say: 5 80 0 0) ; "There's no reason to do that; the Iron Maiden isn't locked."
			)
			((== theVerb 80) ; openSpell
				(gMessager say: 5 80 0 0) ; "There's no reason to do that; the Iron Maiden isn't locked."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openEffect of Prop
	(properties
		fixPriority 1
		view 21
		signal 24577
	)
)

(instance pIMRDoor of Prop
	(properties
		approachX 253
		approachY 107
		x 257
		y 103
		priority 97
		fixPriority 1
		view 670
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(gMessager say: 5 80 0 0) ; "There's no reason to do that; the Iron Maiden isn't locked."
			)
			(80 ; openSpell
				(gMessager say: 5 80 0 0) ; "There's no reason to do that; the Iron Maiden isn't locked."
			)
			(else
				(pIMLDoor doVerb: theVerb)
			)
		)
	)
)

(instance pMainDoor of Prop
	(properties
		noun 4
		approachX 29
		approachY 90
		x 6
		y 35
		priority 64
		fixPriority 1
		view 670
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 8 92 45 87 56 91 15 97
						yourself:
					)
					1
					5
					7
					sDoorScript1
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not local4) (not (gCurRoom script:))) ; Do
				(gCurRoom setScript: sDoorScript)
				(return 1)
			)
			((== theVerb 80) ; openSpell
				(gMessager say: 17 6 32) ; "The 'Open' spell doesn't work on a door with a heavy bar on the other side (a pretty fair description of this one)."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pTenacle1 of Prop
	(properties
		noun 25
		x 175
		y 93
		view 670
		loop 6
		signal 4097
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 17 6 42) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(= local8 1)
					(gEgo use: 5) ; theThrowdagger
					(gCurRoom setScript: sCreatures)
				)
			)
			((OneOf theVerb 83 86 79 88 171 91 93 94 84 36) ; dazzleSpell, flameDartSpell, frostSpell, forceBoltSpell, theHammer, jugglingLightsSpell, lightningBallSpell, ritualSpell, zapSpell, theSword
				(= local8 1)
				(gCurRoom setScript: sCreatures)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pTenacle2 of Prop
	(properties
		noun 25
		x 215
		y 90
		view 670
		loop 7
		signal 4097
	)

	(method (doVerb theVerb)
		(pTenacle1 doVerb: theVerb)
	)
)

(instance pAdavis of Prop
	(properties
		noun 16
		x 58
		y 92
		view 675
		loop 1
	)
)

(instance vChain1 of View
	(properties
		noun 26
		x 179
		y 37
		view 671
		loop 3
		cel 1
	)
)

(instance vChain2 of View
	(properties
		noun 26
		x 189
		y 35
		view 671
		loop 3
		cel 1
	)
)

(instance vBackGround of View
	(properties
		noun 4
		approachX 29
		approachY 90
		x 34
		y 86
		fixPriority 1
		view 670
		loop 1
	)

	(method (doVerb theVerb)
		(pMainDoor doVerb: theVerb)
	)
)

(instance vStake of View
	(properties
		noun 21
		approachX 183
		approachY 152
		x 191
		y 132
		priority 150
		fixPriority 1
		view 670
		loop 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local4)
					(= local3 0)
					(gCurRoom setScript: sPickUp)
				)
			)
			(87 ; fetchSpell
				(= local3 0)
				(gCurRoom setScript: sFetch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vHammer of View
	(properties
		noun 20
		approachX 183
		approachY 152
		x 181
		y 130
		priority 150
		fixPriority 1
		view 670
		loop 8
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local4)
					(= local3 1)
					(gCurRoom setScript: sPickUp)
				)
			)
			(87 ; fetchSpell
				(= local3 1)
				(gCurRoom setScript: sFetch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCreatures of Feature
	(properties
		nsLeft 164
		nsTop 91
		nsRight 224
		nsBottom 105
		sightAngle 180
		approachX 252
		approachY 157
		x 167
		y 103
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 17 6 17) ; "There is something large under the water that is either lonely or hungry. You don't want to find out which."
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 164 91 224 91 224 105 164 105
						yourself:
					)
					1
					7
					5
					sCreatures
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fGrate of Feature
	(properties
		noun 24
		nsLeft 51
		nsTop 31
		nsRight 70
		nsBottom 81
		sightAngle 180
		approachX 175
		approachY 104
		x 167
		y 103
	)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 4) ; Do
				0
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMaiden of Feature
	(properties
		noun 5
		nsLeft 248
		nsTop 52
		nsRight 282
		nsBottom 102
		sightAngle 180
		approachX 253
		approachY 107
		x 265
		y 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(if (not local4)
					(= global441 ((User curEvent:) x:))
					(= global442 ((User curEvent:) y:))
					(gCurRoom setScript: castOpenScript)
				else
					(gMessager say: 5 80 0 0) ; "There's no reason to do that; the Iron Maiden isn't locked."
				)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(pIMLDoor doVerb: theVerb)
			)
		)
	)
)

(instance fCrane of Feature
	(properties
		noun 6
		nsLeft 248
		nsRight 272
		nsBottom 48
		sightAngle 180
		approachX 183
		approachY 152
		x 260
		y 24
	)
)

(instance fCollar of Feature
	(properties
		noun 23
		nsLeft 151
		nsTop 21
		nsRight 218
		nsBottom 37
		sightAngle 180
		approachX 183
		approachY 152
		x 184
		y 29
	)
)

(instance fSaw of Feature
	(properties
		noun 7
		nsLeft 125
		nsTop 6
		nsRight 156
		nsBottom 67
		sightAngle 180
		approachX 120
		approachY 133
		x 140
		y 36
	)
)

(instance fCages of Feature
	(properties
		noun 8
		nsLeft 205
		nsTop 10
		nsRight 240
		nsBottom 72
		sightAngle 180
		approachX 190
		approachY 102
		x 222
		y 41
	)
)

(instance fChopBlock of Feature
	(properties
		noun 9
		nsLeft 189
		nsTop 92
		nsRight 202
		nsBottom 107
		sightAngle 180
		approachX 193
		approachY 113
		x 195
		y 107
	)
)

(instance fAxe of Feature
	(properties
		noun 10
		nsLeft 184
		nsTop 73
		nsRight 207
		nsBottom 96
		sightAngle 180
		approachX 193
		approachY 113
		x 195
		y 84
	)
)

(instance fSkeleton1 of Feature
	(properties
		noun 11
		nsTop 117
		nsRight 32
		nsBottom 188
		sightAngle 40
		approachX 58
		approachY 160
		x 16
		y 152
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 144 165 157 165 205 180 182 186
						yourself:
					)
					1
					7
					5
					sChangeScalerUp
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local12 0)
			(gCurRoom setScript: sGoToSkeleton)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSkeleton2 of Feature
	(properties
		noun 12
		nsLeft 273
		nsTop 108
		nsRight 319
		nsBottom 189
		sightAngle 40
		approachX 214
		approachY 173
		x 300
		y 126
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 144 165 157 165 205 180 182 186
						yourself:
					)
					0
					6
					4
					sChangeScalerDown
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local12 1)
			(gCurRoom setScript: sGoToSkeleton)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fMace of Feature
	(properties
		noun 13
		nsLeft 276
		nsRight 319
		nsBottom 55
		sightAngle 180
		approachX 252
		approachY 157
		x 297
		y 27
	)
)

(instance fPlatform of Feature
	(properties
		noun 14
		nsLeft 136
		nsTop 113
		nsRight 240
		nsBottom 144
		sightAngle 180
		approachX 183
		approachY 152
		x 188
		y 128
	)

	(method (doVerb theVerb)
		(if local4
			(switch theVerb
				(80 ; openSpell
					(if local6
						(gMessager say: 17 6 31) ; "There is no need to use that spell now."
					else
						(= local6 1)
						(gCurRoom setScript: sUnlockChains)
					)
				)
				(42 ; theToolkit
					(gCurRoom setScript: sUnlockChains)
				)
				(4 ; Do
					(if (OneOf gHeroType 0 3) ; Fighter, Paladin
						(= local5 1)
						(gCurRoom setScript: sUnlockChains)
					else
						(gMessager say: 14 4 20) ; "You don't have the strength to break the chains."
					)
				)
				(else
					(if (== theVerb 80) ; openSpell
						0
					else
						(super doVerb: theVerb)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance katrinaTeller of Teller
	(properties
		title 1
		actionVerb 2
	)
)

(instance katrinaTeller2 of Teller
	(properties
		title 1
		actionVerb 2
	)
)

(instance katrinaTeller3 of Teller
	(properties
		title 1
		actionVerb 2
	)
)

(instance heroTeller of Teller
	(properties
		loopMenu 0
		actionVerb 2
		thiefSign 0
	)

	(method (showCases)
		(super showCases: 21 (IsFlag 234) 22 (not (IsFlag 234))) ; Tell Katrina You Love Her, Tell Katrina You Love Her
	)

	(method (sayMessage)
		(switch iconValue
			(3 ; Tell About Ad Avis
				(= local13 4)
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(5 ; Defend Your Actions
				(= local13 5)
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(4 ; Plead for Mercy
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(7 ; Tell About Child
				(= local13 3)
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(21 ; Tell Katrina You Love Her
				(= local13 1)
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(22 ; Tell Katrina You Love Her
				(= local13 2)
				(self clean:)
				(gCurRoom setScript: sFirstFavor)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance heroTeller2 of Teller
	(properties
		loopMenu 0
		actionVerb 2
		thiefSign 0
	)

	(method (showCases)
		(super showCases: 23 (IsFlag 234) 24 (not (IsFlag 234))) ; Tell Her You Love Her, Tell Her You Love Her
	)

	(method (sayMessage)
		(switch iconValue
			(23 ; Tell Her You Love Her
				(= local13 1)
				(self clean:)
				(gCurRoom setScript: sDoFavor)
			)
			(24 ; Tell Her You Love Her
				(= local13 2)
				(self clean:)
				(gCurRoom setScript: sDoFavor)
			)
			(6 ; Explain Your Actions
				(= local13 4)
				(self clean:)
				(gCurRoom setScript: sDoFavor)
			)
			(8 ; Say You're Sorry
				(= local13 5)
				(self clean:)
				(gCurRoom setScript: sDoFavor)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance heroTeller3 of Teller
	(properties
		loopMenu 0
		actionVerb 2
		thiefSign 0
	)

	(method (sayMessage)
		(self clean:)
		(gCurRoom setScript: sGoTo600)
	)
)

(instance getSound of Sound
	(properties
		number 934
	)
)

(instance creakDoorSound of Sound
	(properties
		number 960
	)
)

(instance whipSound of Sound
	(properties
		number 671
	)
)

