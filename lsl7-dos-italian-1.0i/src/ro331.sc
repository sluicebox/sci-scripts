;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro331 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(poWang view: 33130 loop: 0 cel: 0)
	(UpdateScreenItem poWang)
	(voWang show:)
	(= gToWang toWang)
	(switch global263
		(0
			(gCurRoom setScript: soWangGetsMore)
		)
		(1
			(gCurRoom setScript: soWangServes)
			(-- global263)
		)
	)
	(return 1)
)

(instance ro331 of L7Room
	(properties
		picture 33100
	)

	(method (init)
		(super init:)
		(gOMusic1 setRelVol: 50 setMusic: 34000)
		(if (not ((ScriptID 64017 0) test: 277)) ; oFlags
			((ScriptID 64017 0) set: 277) ; oFlags
			(= global263 1)
		)
		(if (not ((ScriptID 64017 0) test: 268)) ; oFlags
			(poWang init:)
			(voWang init:)
			(poWangSporker init: hide:)
			(= gToWang toWang)
			(aoLarryReach init: hide:)
			(aoSpork init: hide:)
			(voCannedSpork init: hide:)
		)
		(voLid init:)
		(= global330 0)
		(if (not ((ScriptID 64017 0) test: 231)) ; oFlags
			(poDildo init:)
		)
		(if (not ((ScriptID 64017 0) test: 71)) ; oFlags
			(voCarvingKnife init:)
		)
		(if (not ((ScriptID 64017 0) test: 70)) ; oFlags
			(voHeatLamp init:)
		)
		(voPlate init:)
		(foSneezeGuard init:)
		(foWeiners init:)
		(foCUExit init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(= global330 0)
		(switch newRoomNumber
			(330 ; ro330
				(gOMusic1 setRelVol: 50)
			)
			(else
				(gOMusic1 setRelVol: 100)
			)
		)
		(gOSound1 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance soWangServes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gToWang toWang)
				(if
					(and
						((ScriptID 64017 0) test: 104) ; oFlags
						(not ((ScriptID 64017 0) test: 209)) ; oFlags
					)
					((ScriptID 64017 0) set: 209) ; oFlags
					(gMessager say: 1 4 10 0 self) ; "Hello, Wang."
				else
					(= cycles 1)
				)
			)
			(1
				(= local1 0)
				(gMessager say: 1 4 1 1 self) ; "What are you serving?"
			)
			(2
				(gMessager sayRange: 1 4 1 2 6 self) ; "(CHINESE) (BRUSQUE) We got s'Pork. Very best. You like. OK?"
			)
			(3
				(voCannedSpork setPri: 498 show:)
				(poWangSporker
					view: 33100
					loop: 1
					cel: 0
					show:
					setCycle: End self 10 12 13 14 15 16 20 9999
				)
				(poWang hide:)
				(voWang hide:)
			)
			(4
				(voLid hide:)
				(poWangSporker setPri: 504)
			)
			(5
				(poSporkDispenser cel: 0 init:)
			)
			(6
				(poSporkDispenser cel: 1 doit:)
			)
			(7
				(voCannedSpork setPri: 504 doit:)
				(poSporkDispenser cel: 2 doit:)
			)
			(8
				(poSporkDispenser cel: 3 doit:)
				(poLidClose view: 33102 loop: 0 cel: 0 posn: 424 324 init:)
			)
			(9
				(voCannedSpork setPri: 500)
			)
			(10
				(poWangSporker setPri: 505)
			)
			(11
				(voCannedSpork hide:)
				(poWangSporker
					view: 33105
					loop: 0
					cel: 0
					setCycle: End self 6 9999
				)
			)
			(12
				(gOSound1 playSound: 33204)
			)
			(13
				(= cycles 1)
			)
			(14
				(poWangSporker
					view: 33110
					loop: 0
					cel: 0
					setPri: 100
					setCycle: CT 7 1 self
				)
			)
			(15
				(gOSound1 playSound: 33201)
				(poPlopSpork cel: 0 init: setCycle: End self)
			)
			(16
				(poSporkDispenser
					view: 33102
					loop: 2
					cel: 1
					posn: 430 341
					doit:
				)
				(poLidClose
					loop: 1
					cel: 0
					posn: 424 344
					setCycle: End self 1 2 3 9999
				)
			)
			(17
				(poSporkDispenser cel: 2 doit:)
			)
			(18
				(poSporkDispenser cel: 3 doit:)
			)
			(19
				(poSporkDispenser dispose:)
			)
			(20
				(gMessager say: 1 4 1 7 self) ; "My God, what IS that?"
				(poWangSporker setCycle: End self)
			)
			(21 0)
			(22
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(voLid show:)
				(poLidClose dispose:)
				(= gToWang toWang)
				(= local0 0)
				(gMessager say: 1 4 1 8 coEndTalk) ; "(IRISH) Like I've been tryin' ta tell you, it's S'PORK!"
				(aoLarryReach show: cycleSpeed: 8 setCycle: CT 9 1 self)
				(aoSpork show: cycleSpeed: 8 setCycle: CT 8 1 self)
				(poPlopSpork dispose:)
			)
			(23
				(voPlate hide:)
			)
			(24
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(25
				(= local0 0)
				(gMessager say: 1 4 1 9 coEndTalk) ; "Ooohhh, the processed potted meat food product that tastes "as fresh as home-slaughtered." Just like Mom used to butcher."
				(aoLarryReach show: setCycle: CT 15 1 self)
				(aoSpork show: setCycle: CT 14 1 self)
			)
			(26 0)
			(27
				(aoLarryReach hide:)
				(aoSpork hide: loop: 1 cel: 0 x: 342 y: 467)
				(= cycles 1)
			)
			(28
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(29
				(gOSound1 playSound: 33202)
				(gMessager say: 1 4 1 10 self) ; "(CHINESE) Very good, boss. Now, you go."
			)
			(30
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(= local0 0)
				(gMessager sayRange: 1 4 1 11 12 coEndTalk) ; "Hey, what's with the accent?"
				(aoLarryReach show: setCycle: Beg self 9 0)
			)
			(31
				(voPlate show:)
			)
			(32
				(aoLarryReach hide:)
				(= cycles 1)
			)
			(33
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(34
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWangServesAgain of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gToWang toWang)
				(if
					(and
						((ScriptID 64017 0) test: 104) ; oFlags
						(not ((ScriptID 64017 0) test: 209)) ; oFlags
					)
					((ScriptID 64017 0) set: 209) ; oFlags
					(gMessager say: 1 4 10 0 self) ; "Hello, Wang."
				else
					(= cycles 1)
				)
			)
			(1
				(voCannedSpork setPri: 498 show:)
			)
			(2
				(= gToWang 0)
				(= local0 0)
				(gMessager say: 1 4 2 2 coEndTalk) ; "(CHINESE) Mmmmmm. s'Pork good, huh? (SERVES S'PORK) (MUMBLING TO SELF) (Dang Wang?)"
				(poWangSporker
					view: 33100
					loop: 1
					cel: 0
					show:
					setCycle: End self 10 12 13 14 15 16 20 9999
				)
				(poWang hide:)
				(voWang hide:)
			)
			(3
				(voLid hide:)
				(poWangSporker setPri: 504)
			)
			(4
				(poSporkDispenser init: cel: 0)
			)
			(5
				(poSporkDispenser cel: 1 doit:)
			)
			(6
				(poSporkDispenser cel: 2 doit:)
				(voCannedSpork setPri: 504 doit:)
			)
			(7
				(poSporkDispenser cel: 3 doit:)
				(poLidClose view: 33102 loop: 0 cel: 0 posn: 424 324 init:)
			)
			(8
				(voCannedSpork setPri: 500)
			)
			(9
				(poWangSporker setPri: 505)
			)
			(10
				(voCannedSpork hide:)
				(poWangSporker
					view: 33105
					loop: 0
					cel: 0
					setCycle: End self 6 9999
				)
			)
			(11
				(gOSound1 playSound: 33204)
			)
			(12
				(= cycles 1)
			)
			(13
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(14
				(poWangSporker
					view: 33110
					loop: 0
					cel: 0
					setPri: 100
					setCycle: CT 7 1 self
				)
			)
			(15
				(gOSound1 playSound: 33201)
				(poPlopSpork cel: 0 init: setCycle: End self)
			)
			(16
				(poLidClose loop: 1 cel: 0 posn: 424 344 setCycle: End)
				(poSporkDispenser dispose:)
				(poWangSporker setCycle: End self)
			)
			(17
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(voLid show:)
				(poLidClose dispose:)
				(= gToWang toWang)
				(aoLarryReach show: setCycle: CT 9 1 self)
				(aoSpork show: setCycle: CT 8 1 self)
				(poPlopSpork dispose:)
			)
			(18
				(voPlate hide:)
			)
			(19
				(aoLarryReach show: setCycle: CT 15 1 self)
				(aoSpork show: setCycle: CT 14 1 self)
			)
			(20 0)
			(21
				(aoLarryReach hide:)
				(aoSpork hide: loop: 1 cel: 0 x: 342 y: 467)
				(= cycles 1)
			)
			(22
				(gOSound1 playSound: 33202)
				(= ticks 5)
			)
			(23
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(gMessager say: 1 4 2 3 self) ; "(IRISH) Now be sure not to exceed the maximum daily allowance. Those warnings are on the can for a reason, y'know."
			)
			(24
				(aoLarryReach show: setCycle: Beg self 9 0)
			)
			(25
				(voPlate show:)
			)
			(26
				(aoLarryReach hide:)
				(= cycles 1)
			)
			(27
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWangServesOnTake of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gToWang toWang)
				(if
					(and
						((ScriptID 64017 0) test: 104) ; oFlags
						(not ((ScriptID 64017 0) test: 209)) ; oFlags
					)
					((ScriptID 64017 0) set: 209) ; oFlags
					(gMessager say: 1 4 10 0 self) ; "Hello, Wang."
				else
					(= cycles 1)
				)
			)
			(1
				(voCannedSpork setPri: 498 show:)
				(gMessager say: 3 8 4 1 self) ; "I think I'll have a hunk of your s'Pork. (SMACKING, MUNCHING, CRUNCHING SOUNDS)"
			)
			(2
				(= gToWang 0)
				(poWangSporker
					view: 33100
					loop: 1
					cel: 0
					show:
					setCycle: End self 10 12 13 14 15 16 20 9999
				)
				(poWang hide:)
				(voWang hide:)
			)
			(3
				(voLid hide:)
				(poWangSporker setPri: 504)
			)
			(4
				(poSporkDispenser init: cel: 0)
			)
			(5
				(poSporkDispenser cel: 1 doit:)
			)
			(6
				(voCannedSpork setPri: 504 doit:)
				(poSporkDispenser cel: 2 doit:)
			)
			(7
				(poSporkDispenser cel: 3 doit:)
				(poLidClose view: 33102 loop: 0 cel: 0 posn: 424 324 init:)
			)
			(8
				(voCannedSpork setPri: 500)
			)
			(9
				(poWangSporker setPri: 505)
			)
			(10
				(voCannedSpork hide:)
				(poWangSporker
					view: 33105
					loop: 0
					cel: 0
					setCycle: End self 6 9999
				)
			)
			(11
				(gOSound1 playSound: 33204)
			)
			(12
				(= cycles 1)
			)
			(13
				(poWangSporker
					view: 33110
					loop: 0
					cel: 0
					setPri: 100
					setCycle: CT 7 1 self
				)
			)
			(14
				(gOSound1 playSound: 33201)
				(poPlopSpork cel: 0 init: setCycle: End self)
			)
			(15
				(poLidClose loop: 1 cel: 0 posn: 424 344 setCycle: End)
				(poSporkDispenser dispose:)
				(poWangSporker setCycle: End self)
			)
			(16
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(voLid show:)
				(poLidClose dispose:)
				(= gToWang toWang)
				(aoLarryReach show: setCycle: CT 9 1 self)
				(aoSpork show: setCycle: CT 8 1 self)
				(poPlopSpork dispose:)
			)
			(17
				(voPlate hide:)
			)
			(18
				(aoLarryReach show: setCycle: CT 15 1 self)
				(aoSpork show: setCycle: CT 14 1 self)
			)
			(19 0)
			(20
				(aoLarryReach hide:)
				(aoSpork hide: loop: 1 cel: 0 x: 342 y: 467)
				(= cycles 1)
			)
			(21
				(gMessager say: 3 8 4 2 self) ; "This stuff is great! It's kinda like Spam, only not so expensive!"
				(gOSound1 playSound: 33202)
			)
			(22
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(aoLarryReach show: setCycle: Beg self 9 0)
			)
			(23
				(voPlate show:)
			)
			(24
				(aoLarryReach hide:)
				(= cycles 1)
			)
			(25
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWangGetsMore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gToWang toWang)
				(if
					(and
						((ScriptID 64017 0) test: 104) ; oFlags
						(not ((ScriptID 64017 0) test: 209)) ; oFlags
					)
					((ScriptID 64017 0) set: 209) ; oFlags
					(gMessager say: 1 4 10 0 self) ; "Hello, Wang."
				else
					(= cycles 1)
				)
			)
			(1
				(voCannedSpork setPri: 498 show:)
				(if local1
					(gMessager say: 3 8 4 1 self) ; "I think I'll have a hunk of your s'Pork. (SMACKING, MUNCHING, CRUNCHING SOUNDS)"
				else
					(gMessager sayRange: 1 4 2 1 2 self) ; "Dang, Wang. That s'Pork IS tasty. How 'bout some more?"
				)
			)
			(2
				(if local1
					(= local0 0)
					(gMessager say: 3 8 4 2 coEndTalk) ; "This stuff is great! It's kinda like Spam, only not so expensive!"
				else
					(= local0 1)
				)
				(= local1 0)
				(= gToWang 0)
				(poWangSporker
					view: 33100
					loop: 1
					cel: 0
					show:
					setCycle: End self 10 14 15 16 20 9999
				)
				(poWang hide:)
				(voWang hide:)
			)
			(3
				(voLid hide:)
				(poWangSporker setPri: 504)
			)
			(4
				(voCannedSpork setPri: 504 doit:)
			)
			(5
				(poLidClose view: 33102 loop: 0 cel: 0 posn: 424 324 init:)
			)
			(6
				(voCannedSpork setPri: 500)
			)
			(7
				(poWangSporker setPri: 505)
			)
			(8
				(voCannedSpork hide:)
				(poWangSporker
					view: 33105
					loop: 0
					cel: 0
					setCycle: End self 6 9999
				)
			)
			(9
				(gOSound1 playSound: 33204)
			)
			(10
				(= cycles 1)
			)
			(11
				(poWangSporker
					view: 33110
					loop: 0
					cel: 0
					setPri: 100
					setCycle: CT 7 1 self
				)
			)
			(12
				(gOSound1 playSound: 33201)
				(poPlopSpork cel: 0 init: setCycle: End self)
			)
			(13
				(poLidClose loop: 1 cel: 0 posn: 424 344 setCycle: End)
				(poWangSporker setCycle: End self)
			)
			(14
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(15
				(= gToWang toWang)
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(gMessager say: 1 4 2 3 self) ; "(IRISH) Now be sure not to exceed the maximum daily allowance. Those warnings are on the can for a reason, y'know."
			)
			(16
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(voLid show:)
				(poLidClose dispose:)
				(= gToWang toWang)
				(aoLarryReach show: setCycle: CT 9 1 self)
				(aoSpork show: setCycle: CT 8 1 self)
				(poPlopSpork dispose:)
			)
			(17
				(voPlate hide:)
			)
			(18
				(aoLarryReach show: setCycle: CT 15 1 self)
				(aoSpork show: setCycle: CT 14 1 self)
			)
			(19 0)
			(20
				(aoLarryReach hide:)
				(aoSpork hide: loop: 1 cel: 0 x: 342 y: 467)
				(= cycles 1)
			)
			(21
				(gOSound1 playSound: 33202)
				(= ticks 5)
			)
			(22
				(poWang show:)
				(voWang show:)
				(poWangSporker hide:)
				(aoLarryReach show: setCycle: Beg self 9 0)
			)
			(23
				(voPlate show:)
			)
			(24
				(aoLarryReach hide:)
				(= cycles 1)
			)
			(25
				(gMessager say: 1 4 3 1 self) ; "(CHINESE) Oh, no! Not enough s'Pork! Must get more. (TO LARRY) No touchy!"
			)
			(26
				(poWang hide:)
				(voWang hide:)
				(poWangSporker
					view: 33120
					loop: 0
					cel: 0
					x: 432
					y: 315
					show:
					setCycle: End self
				)
			)
			(27
				((ScriptID 64017 0) set: 69) ; oFlags
				(poWangSporker hide:)
				(voWang dispose:)
				(poWang dispose:)
				((ScriptID 64017 0) set: 268) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOutSporken of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 3 8 3 1 3 self) ; "You've had just about all the s'Pork you can take!"
			)
			(1
				(= local0 0)
				(gMessager say: 3 8 3 4 coEndTalk) ; "Oh. (Burp.) Good."
				(= ticks 80)
			)
			(2
				(if (> (= temp0 (Random 4 5)) 4)
					(gOSound1 playSound: 106 self)
				else
					(gOSound1 playSound: 107 self)
				)
			)
			(3
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeBulb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 8 0 1 self) ; "Okay, but first you'd better let it cool. (HUM, WHISTLE, KILL 5 SECONDS) Okay, now."
				(voHeatLamp view: 33170 loop: 0 cel: 0 posn: 121 193)
				(voLid view: 33150 loop: 0 cel: 0)
			)
			(1
				(gOSound1 playSound: 33203)
				(= cycles 1)
			)
			(2
				(voHeatLamp dispose:)
				(gEgo get: ((ScriptID 64037 0) get: 13)) ; oInvHandler, ioHeatBulb
				(gMessager sayRange: 2 8 0 2 3 self) ; "(IT'S STILL HOT AS HELL!) Ow! Oh! Uch! Ouch! Ulp! Ahnt! Hot hot hot hot hot!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSneeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poSneezeStuff posn: (- 0 (Random 0 40)) -50 init: hide:)
				(gMessager say: 5 1 0 1 self) ; "This glass is called a sneezeguard, although you can't imagine why."
			)
			(1
				(= local0 0)
				(gMessager say: 5 1 0 2 coEndTalk) ; "(SNEEZE) Ah-choo!"
				(= ticks 60)
			)
			(2
				(poSneezeStuff show: setCycle: End self)
			)
			(3
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(4
				(gMessager say: 5 1 0 3 self) ; "Oh, now I get it!"
			)
			(5
				(gGame handsOn:)
				(foSneezeGuard dispose:)
				(self dispose:)
			)
		)
	)
)

(instance poWangSporker of Prop
	(properties
		priority 482
		x 424
		y 344
		view 33100
		fixPriority 1
	)
)

(instance voLid of Prop
	(properties
		noun 3
		priority 500
		x 424
		y 344
		loop 1
		cel 5
		view 33102
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 70) ; oFlags
			(self view: 33150 loop: 0 cel: 0 x: 165 y: 344)
		else
			(self view: 33150 loop: 0 cel: 1 x: 165 y: 344)
		)
		(AddDefaultVerbs self)
		(if (not ((ScriptID 64017 0) test: 268)) ; oFlags
			(self addHotspotVerb: 8)
		)
	)

	(method (show)
		(super show: &rest)
		(if ((ScriptID 64017 0) test: 70) ; oFlags
			(self view: 33150 loop: 0 cel: 0 x: 165 y: 344)
		else
			(self view: 33150 loop: 0 cel: 1 x: 165 y: 344)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if ((ScriptID 64017 0) test: 268) ; oFlags
					(gCurRoom setScript: soOutSporken)
				else
					(= local1 1)
					(localproc_0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poLidClose of Prop
	(properties
		priority 500
		x 424
		y 324
		loop 1
		view 33102
		fixPriority 1
	)
)

(instance voCarvingKnife of Prop
	(properties
		noun 6
		priority 500
		x 23
		y 391
		view 33140
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if (not ((ScriptID 64017 0) test: 268)) ; oFlags
					(gMessager say: 6 8 5 1 0 331) ; "(CHINESE) What?! Whoaa! Keep hands away. Knife sharp. My knife! Use knife make living, Joe! You no take knife."
				else
					(gMessager say: 6 8 0 1 0 331) ; "Since Wang's not looking, I may as well steal his knife."
					(self dispose:)
					(gEgo get: ((ScriptID 64037 0) get: 3)) ; oInvHandler, ioKnife
					((ScriptID 64017 0) set: 71) ; oFlags
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voHeatLamp of Prop
	(properties
		noun 2
		priority 1
		x 168
		y 173
		loop 2
		view 33150
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 5 117 62)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if (not ((ScriptID 64017 0) test: 268)) ; oFlags
					(gMessager say: 2 8 5 1 0 331) ; "(CHINESE) Oh, no, no, no, no, no, no, no, no. Keep hands off. You burn self, okay?"
				else
					(gCurRoom setScript: soTakeBulb)
					((ScriptID 64017 0) set: 70) ; oFlags
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poSneezeStuff of Prop
	(properties
		priority 600
		y -50
		view 33160
		fixPriority 1
	)
)

(instance aoLarryReach of Actor
	(properties
		priority 600
		x 336
		y 479
		view 33117
		fixPriority 1
	)
)

(instance aoSpork of Actor
	(properties
		priority 610
		x 342
		y 467
		loop 1
		view 33117
		fixPriority 1
	)
)

(instance poPlopSpork of Prop
	(properties
		priority 610
		x 424
		y 344
		loop 1
		view 33110
		fixPriority 1
	)
)

(instance poDildo of Prop
	(properties
		priority 700
		x 534
		y 286
		loop 1
		view 33150
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(++ global264)
		((ScriptID 64017 0) set: 231) ; oFlags
		(self
			view: 33125
			loop: 0
			cel: 0
			x: 549
			y: 285
			setScript: (ScriptID 50 2) ; soDildo
			setCycle: End (ScriptID 50 2) ; soDildo
		)
	)
)

(instance poSporkDispenser of Prop
	(properties
		priority 504
		x 424
		y 344
		loop 2
		view 33100
		fixPriority 1
	)
)

(instance voPlate of Prop
	(properties
		priority 600
		x 424
		y 344
		loop 1
		view 33115
		fixPriority 1
	)
)

(instance voCannedSpork of View
	(properties
		priority 1
		x 424
		y 344
		view 33115
		fixPriority 1
	)
)

(instance foWeiners of Feature
	(properties
		noun 4
		x 534
		y 144
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 636 265 636 251 628 249 614 255 610 251 614 221 606 201 610 189 615 179 628 173 638 157 638 1 431 1 435 31 444 37 443 47 455 68 470 80 478 84 485 94 494 103 500 104 500 111 504 121 507 122 507 131 513 139 510 149 514 164 522 180 535 191 547 194 552 191 558 201 572 205 585 203 591 201 592 203 588 212 588 223 592 230 592 235 587 249 589 258 582 265 576 275 565 277 549 267 539 265 534 254 530 245 527 242 532 237 529 234 524 236 522 234 519 235 522 244 515 248 512 261 516 272 507 275 486 268 469 259 456 264 448 263 448 267 444 270 444 274 447 278 447 280 456 277 467 288 589 287
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSneezeGuard of Feature
	(properties
		noun 5
		x 152
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 146 294 17 291 8 57 41 10 140 16 145
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not local2)
					(= local2 1)
					(gCurRoom setScript: soSneeze)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 330) ; ro330
	)
)

(instance poLarry of Prop ; UNUSED
	(properties
		priority 50
		x 320
		y 240
		view 33117
		fixPriority 1
	)
)

(instance poWang of Prop
	(properties
		noun 1
		priority 1
		x 420
		y 338
		view 33130
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(localproc_0)
			)
			(else
				(cond
					((Message msgGET 331 1 theVerb 0 1)
						(super doVerb: theVerb)
					)
					((proc64037_3 theVerb)
						(gMessager say: 1 161 (Random 7 9))
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance voWang of View
	(properties)

	(method (init)
		(= view (poWang view:))
		(= loop (+ (poWang loop:) 1))
		(= x (poWang x:))
		(= y (poWang y:))
		(self setPri: (+ (poWang priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poWang view:))
		(= loop (+ (poWang loop:) 1))
		(= x (poWang x:))
		(= y (poWang y:))
		(self setPri: (+ (poWang priority:) 1))
		(super show: &rest)
	)
)

(instance toWang of Talker
	(properties)

	(method (init)
		(= view (poWang view:))
		(= loop (+ (poWang loop:) 1))
		(= x (poWang x:))
		(= y (poWang y:))
		(= priority (+ (poWang priority:) 1))
		(voWang hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voWang show:)
		(super dispose: &rest)
	)
)

(instance poWangEyes of Prop ; UNUSED
	(properties)

	(method (init)
		(= view (poWang view:))
		(= loop (+ (poWang loop:) 2))
		(= x (poWang x:))
		(= y (poWang y:))
		(self setPri: (+ (poWang priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poWang view:))
		(= x (poWang x:))
		(= y (poWang y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

