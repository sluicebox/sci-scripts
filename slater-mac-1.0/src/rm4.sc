;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm4 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm4 of Rm
	(properties
		picture 400
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(aWord0 init:)
		(aWord1 init:)
		(aWord2 init:)
		(aWord3 init:)
		(aWord4 init:)
		(aWord5 init:)
		(rock init:)
		(aCave init:)
		(showGirl init:)
		(slater1 init:)
		(tent1 init:)
		(pack init:)
		(duck init:)
		(charlie init:)
		(mountain init:)
		(stoned init:)
		(caveMan init:)
		(aRower init:)
		(sky init: setOnMeCheck: 1 32)
		(aCoconut init:)
		(gLongSong number: 111 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local2) (not (gCurRoom script:)))
			(= local2 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(if local0
			(PalVary pvREVERSE 1)
		)
		(if local0
			(PalVary pvUNINIT)
		)
		(mySound dispose:)
		(my2Sound dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance rockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rock setCel: 1)
				(= ticks 40)
			)
			(1
				(gGame handsOff:)
				(theView view: 475 setLoop: 0 setCel: 1 posn: 124 182 init:)
				(mySound number: 1045 setLoop: 1 play:)
				(= ticks 25)
			)
			(2
				(theProp view: 475 setLoop: 1 setCel: 1 posn: 228 182 init:)
				(= ticks 50)
			)
			(3
				(theView hide: dispose:)
				(= ticks 50)
			)
			(4
				(theProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(if (not local1)
					(gCurRoom setScript: tent1Script)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tent1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(charlie view: 485 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 12)
			)
			(1
				(slater1 cycleSpeed: 12 posn: 222 121 setCycle: CT 1 1 self)
			)
			(2
				(slater1 setCycle: CT 3 1 self)
			)
			(3
				(mySound number: 911 play: setLoop: 1)
				(my2Sound number: 917 setLoop: 1 play:)
				(tent1 setCycle: CT 1 1)
				(slater1 setCycle: CT 7 1 self)
			)
			(4
				(my2Sound number: 941 play: setLoop: 1)
				(slater1 setCycle: End self)
			)
			(5
				(charlie setCycle: 0 hide: dispose:)
				(mySound number: 911 setLoop: 1 play:)
				(tent1 posn: 131 119 setCycle: CT 9 1 self)
			)
			(6
				(tent1 setCycle: CT 11 1 self)
			)
			(7
				(mySound number: 914 setLoop: 1 play: self)
				(tent1 setCycle: CT 12 1)
			)
			(8
				(paper1 init: setCycle: End self)
			)
			(9
				(mySound number: 1001 setLoop: 1 play:)
				(paper2 init: hide:)
				(paper1 setLoop: 2 setCel: 0 posn: 87 123 setCycle: End self)
			)
			(10
				(paper2 ignoreActors: show:)
				(paper1
					view: 400
					setLoop: 2
					setCel: 0
					posn: 100 124
					ignoreActors:
				)
				(= ticks 6)
			)
			(11
				(mySound stop:)
				(slater1 dispose:)
				(slater init: setCel: 0 stopUpd:)
				(tent1 dispose:)
				(paper1 dispose:)
				(paper2 dispose:)
				(tent init: stopUpd:)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance caveManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(caveMan view: 430 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(mySound number: 928 play: setLoop: 1)
				(caveMan setCycle: CT 7 1 self)
			)
			(2
				(= ticks 25)
			)
			(3
				(caveMan setCycle: CT 13 1 self)
			)
			(4
				(caveMan setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(5
				(mySound stop:)
				(= ticks 90)
			)
			(6
				(caveMan setCycle: CT 5 1 self)
			)
			(7
				(mySound stop:)
				(my2Sound number: 1012 setLoop: 1 play:)
				(= ticks 90)
			)
			(8
				(caveMan setCycle: CT 2 -1 self)
			)
			(9
				(caveMan setLoop: 2 setCel: 0 setCycle: CT 7 1 self)
			)
			(10
				(caveMan setCel: 0 setCycle: CT 7 1 self)
			)
			(11
				(caveMan setCel: 0 setCycle: CT 7 1 self)
			)
			(12
				(caveMan setCel: 0 setCycle: CT 7 1 self)
			)
			(13
				(caveMan setCel: 0 setCycle: CT 7 1 self)
			)
			(14
				(mySound number: 928 play: setLoop: 1)
				(caveMan setLoop: 0 setCel: 13 setCycle: Beg self)
			)
			(15
				(mySound stop:)
				(caveMan view: 465 setLoop: 1 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance duckScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(duck view: 460 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 942 setLoop: 1 play:)
				(duck setCycle: CT 3 1 self)
			)
			(2
				(duck setCycle: CT 9 1 self)
			)
			(3
				(duck setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(4
				(duck setLoop: 0 setCel: 9 setCycle: CT 3 -1 self)
				(mySound number: 1000 setLoop: 1 play:)
			)
			(5
				(duck setCycle: CT 0 -1 self)
			)
			(6
				(duck view: 465 setLoop: 3 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(gLongSong number: 130 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance showGirlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 998 setLoop: 1 play:)
				(showGirl view: 450 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(sparkle init: setCycle: Fwd)
				(sparkle2 init: setCycle: Fwd)
				(sparkle3 init: setCycle: Fwd)
				(showGirl setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(showGirl setLoop: 4 setCel: 0 setCycle: Fwd)
				(= ticks 50)
			)
			(3
				(showGirl setLoop: 2 setCel: 0 setCycle: End self)
				(sparkle setCel: 0 dispose:)
				(sparkle2 setCel: 0 dispose:)
				(sparkle3 setCel: 0 dispose:)
			)
			(4
				(mySound number: 999 setLoop: 1 play: self)
			)
			(5
				(showGirl view: 465 setLoop: 2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rowerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 995 setLoop: 1 play:)
				(my2Sound number: 994 setLoop: 1 play:)
				(rowers init: setMotion: MoveTo 312 141 self)
			)
			(1
				(= ticks 6)
			)
			(2
				(rowers setCel: 0 setMotion: MoveTo 292 145)
				(= ticks 25)
			)
			(3
				(mySound number: 995 setLoop: 1 play:)
				(my2Sound number: 994 setLoop: 1 play:)
				(rowers setCycle: End setMotion: MoveTo 272 149 self)
			)
			(4
				(rowers setCel: 0 setMotion: MoveTo 252 153)
				(= ticks 25)
			)
			(5
				(mySound number: 995 setLoop: 1 play:)
				(my2Sound number: 994 setLoop: 1 play:)
				(rowers setCycle: End setMotion: MoveTo 232 157 self)
			)
			(6
				(rowers setCel: 0 setMotion: MoveTo 212 161)
				(= ticks 25)
			)
			(7
				(mySound number: 995 setLoop: 1 play:)
				(my2Sound number: 994 setLoop: 1 play:)
				(rowers setCycle: End setMotion: MoveTo 192 165 self)
			)
			(8
				(rowers setCel: 0 setMotion: MoveTo 172 169)
				(= ticks 25)
			)
			(9
				(mySound number: 995 setLoop: 1 play:)
				(my2Sound number: 994 setLoop: 1 play:)
				(rowers setCel: 0 setCycle: End setMotion: MoveTo 152 173)
				(= ticks 25)
			)
			(10
				(rowers setCel: 0 setMotion: MoveTo 107 198 self)
			)
			(11
				(mySound stop:)
				(my2Sound stop:)
				(rowers posn: 332 127 setCel: 0 dispose:)
				(= cycles 2)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stonedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(stoned view: 440 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 950 setLoop: 1 play:)
				(stoned setCycle: End self)
			)
			(2
				(mySound number: 996 setLoop: -1 play:)
				(stoned setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 150)
			)
			(3
				(my2Sound number: 990 setLoop: 1 play:)
				(stoned setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
			)
			(4
				(mySound number: 997 setLoop: 1 play:)
				(stoned setCel: 3 setCycle: CT 7 1 self)
			)
			(5
				(= ticks 100)
			)
			(6
				(my2Sound number: 997 setLoop: 1 play:)
				(mySound number: 951 setLoop: 1 play:)
				(stoned
					setCel: 7
					setPri: 8
					setMotion: MoveTo (stoned x:) 235 self
				)
			)
			(7
				(my2Sound stop:)
				(= ticks 50)
			)
			(8
				(my2Sound number: 997 setLoop: 1 play:)
				(mySound number: 951 setLoop: 1 play:)
				(stoned setMotion: MoveTo 238 245 self)
			)
			(9
				(my2Sound stop:)
				(= ticks 25)
			)
			(10
				(my2Sound number: 997 setLoop: 1 play:)
				(stoned
					setLoop: 0
					setCel: 0
					posn: 238 182
					setMotion: MoveTo 238 166 self
				)
			)
			(11
				(mySound stop:)
				(stoned view: 465 setLoop: 1 setCel: 3 setPri: 10 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance skyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 25)
			)
			(1
				(if local0
					(= local0 0)
					(mySound number: 951 setLoop: 1 play:)
					(stars setMotion: MoveTo 186 82 self)
					(PalVary pvREVERSE 2)
				else
					(= local0 1)
					(mySound number: 950 setLoop: 1 play:)
					(stars init: setMotion: MoveTo 186 20 self)
					(PalVary pvINIT 410 2)
				)
			)
			(2
				(if local0
					(stars stopUpd:)
				else
					(stars dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tentScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tent view: 425 setLoop: 0 setCel: 0)
				(= ticks 6)
			)
			(1
				(patch init: setPri: 9 setCycle: End self)
			)
			(2
				(mySound number: 957 setLoop: 1 play:)
				(= ticks 36)
			)
			(3
				(patch setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(mySound number: 956 setLoop: 1 play: self)
			)
			(5
				(patch setLoop: 1 setCel: 3 setCycle: Beg self)
			)
			(6
				(mySound number: 957 setLoop: 1 play:)
				(tent view: 465 setLoop: 1 setCel: 1 stopUpd:)
				(patch dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance packScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 961 setLoop: 1 play:)
				(pack view: 420 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(pack setLoop: 1 setCel: 0)
				(= ticks 3)
			)
			(2
				(mySound number: 908 setLoop: 1 play:)
				(pack setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(mySound number: 907 setLoop: -1 play:)
				(pack setLoop: 2 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(4
				(mySound number: 908 setLoop: 1 play:)
				(pack setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(mySound number: 907 setLoop: -1 play:)
				(pack setLoop: 2 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(6
				(mySound stop:)
				(pack setLoop: 0 setCel: 10 setCycle: Beg self)
			)
			(7
				(pack view: 465 setLoop: 1 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance caveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1163 setLoop: 1 play: self)
				(cavey init: setCycle: CT 2 1 self)
			)
			(1)
			(2
				(mySound number: 1163 setLoop: 1 play: self)
			)
			(3
				(cavey setCycle: CT 10 1 self)
			)
			(4
				(mySound number: 904 setLoop: 1 play:)
				(cavey setCycle: CT 14 1 self)
			)
			(5
				(mySound number: 904 setLoop: 1 play:)
				(cavey setCycle: CT 15 1 self)
			)
			(6
				(cavey setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(7
				(mySound number: 904 setLoop: 1 play:)
				(cavey setCycle: CT 5 1 self)
			)
			(8
				(= ticks 6)
			)
			(9
				(mySound number: 956 setLoop: 1 play:)
				(cavey setCycle: CT 8 1 self)
			)
			(10
				(= ticks 6)
			)
			(11
				(cavey setCycle: CT 12 1 self)
			)
			(12
				(mySound number: 904 setLoop: 1 play:)
				(cavey setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mountainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 150 setLoop: -1 play:)
				(mountain view: 410 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 984 setLoop: 1 play:)
				(mountain setCycle: End self)
			)
			(2
				(mountain view: 465 setLoop: 0 setCel: 1 stopUpd:)
				(mySound number: 974 setLoop: 1 play:)
				(flyGuy setLoop: 1 setCel: 0 posn: 113 74 init: hide:)
				(= ticks 3)
			)
			(3
				(flyGuy show:)
				(= ticks 3)
			)
			(4
				(flyGuy
					setCel: 0
					moveSpeed: 0
					setMotion: MoveTo (flyGuy x:) (- (flyGuy y:) 30) self
				)
			)
			(5
				(= ticks 100)
			)
			(6
				(flyGuy
					view: 411
					setLoop: 0
					setCel: 0
					posn: 155 145
					cycleSpeed: 0
					setCycle: CT 5 1 self
				)
			)
			(7
				(slater hide:)
				(flyGuy setCycle: CT 7 1 self)
			)
			(8
				(flyGuy view: 410 setLoop: 2 setCel: 0 cycleSpeed: 18)
				(slater view: 410 setLoop: 1 setCel: 4 show:)
				(my2Sound number: 917 setLoop: 1 play:)
				(my2Sound number: 992 setLoop: 1 play: self)
			)
			(9
				(paper view: 410 setLoop: 3 setCel: 0 init: setCycle: End self)
			)
			(10
				(flyGuy setCycle: CT 2 1 self)
			)
			(11
				(mySound number: 956 setLoop: 1 play: self)
			)
			(12
				(slater view: 465 setLoop: 0 setCel: 0 stopUpd:)
				(paper view: 400 setLoop: 1 setCel: 0 dispose:)
				(= ticks 6)
			)
			(13
				(= ticks 25)
			)
			(14
				(flyGuy setCycle: CT 4 1 self)
			)
			(15
				(mySound number: 957 setLoop: 1 play:)
				(= ticks 25)
			)
			(16
				(flyGuy setCycle: CT 6 1 self)
			)
			(17
				(mySound number: 957 setLoop: 1 play:)
				(= ticks 25)
			)
			(18
				(flyGuy setCycle: CT 8 1 self)
			)
			(19
				(mySound number: 957 setLoop: 1 play:)
				(= ticks 25)
			)
			(20
				(flyGuy setCycle: CT 10 1 self)
			)
			(21
				(mySound number: 991 setLoop: 1 play:)
				(= ticks 50)
			)
			(22
				(flyGuy setCycle: CT 12 1 self)
			)
			(23
				(mySound number: 953 setLoop: 1 play:)
				(flyGuy posn: (- (flyGuy x:) 20) 147)
				(= ticks 5)
			)
			(24
				(flyGuy posn: (- (flyGuy x:) 20) 147)
				(= ticks 5)
			)
			(25
				(flyGuy posn: (- (flyGuy x:) 20) 147)
				(= ticks 5)
			)
			(26
				(flyGuy posn: (- (flyGuy x:) 20) 147)
				(= ticks 5)
			)
			(27
				(flyGuy posn: -20 147)
				(= ticks 5)
			)
			(28
				(mySound stop:)
				(flyGuy hide: setLoop: 1 setCel: 0 posn: 101 63 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slater view: 400 setCycle: CT 2 1 self)
			)
			(1
				(mySound number: 994 setLoop: 1 play:)
				(slater setCycle: CT 4 1 self)
			)
			(2
				(mySound number: 1001 setLoop: 1 play:)
				(slater setCycle: CT 6 1)
				(paper init: setCycle: End self)
			)
			(3
				(paper setCel: 0 dispose:)
				(slater view: 465 setCel: 0 stopUpd:)
				(= ticks 12)
			)
			(4
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coconutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 1002)
				(slater view: 405 setLoop: 1 setCel: 0)
				(coconut init: setPri: 6 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 930 setLoop: 1 play:)
				(coconut setPri: 13 setCycle: CT 4 1 self)
			)
			(2
				(mySound number: 1002 setLoop: 1 play:)
				(coconut setCycle: CT 6 1 self)
				(slater setCycle: End)
			)
			(3
				(coconut setCycle: End self)
			)
			(4
				(coconut setLoop: 0 setCel: 0 dispose:)
				(= ticks 12)
			)
			(5
				(slater view: 465 setLoop: 0 setCel: 0 stopUpd:)
				(UnLoad 132 1002)
				(gGame handsOn:)
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 175
		nsLeft 57
		nsBottom 182
		nsRight 95
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 0 posn: 75 182 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 175
		nsLeft 98
		nsBottom 182
		nsRight 140
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1073 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 1 posn: 118 182 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 175
		nsLeft 140
		nsBottom 182
		nsRight 187
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 2 posn: 163 182 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 175
		nsLeft 190
		nsBottom 182
		nsRight 221
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1074 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 3 posn: 206 182 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 175
		nsLeft 224
		nsBottom 182
		nsRight 245
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 4 posn: 234 182 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 175
		nsLeft 248
		nsBottom 182
		nsRight 275
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1075 setLoop: 1 play: rm4)
		(theView view: 480 setLoop: 5 posn: 260 182 init:)
	)
)

(instance sky of InterFeature
	(properties
		y 10
	)

	(method (doVerb)
		(gCurRoom setScript: skyScript)
	)
)

(instance aCoconut of InterFeature
	(properties
		nsLeft 34
		nsBottom 57
		nsRight 61
	)

	(method (doVerb)
		(if (and local1 (not local3))
			(= local3 1)
			(gCurRoom setScript: coconutScript)
		)
	)
)

(instance aCave of InterFeature
	(properties
		nsTop 61
		nsLeft 54
		nsBottom 86
		nsRight 91
	)

	(method (doVerb)
		(gCurRoom setScript: caveScript)
	)
)

(instance aRower of InterFeature
	(properties
		nsTop 132
		nsLeft 197
		nsBottom 159
		nsRight 290
	)

	(method (doVerb)
		(gCurRoom setScript: rowerScript)
	)
)

(instance rock of InterView
	(properties
		x 49
		y 181
		view 470
		loop 3
		priority 14
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance theView of Prop
	(properties
		cel 1
		priority 14
		signal 16
	)
)

(instance theProp of Prop
	(properties
		cel 1
		priority 14
		signal 16
	)
)

(instance caveMan of InterProp
	(properties
		x 40
		y 142
		view 465
		loop 1
		cel 2
		priority 11
		signal 20497
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: caveManScript)
		)
	)
)

(instance duck of InterProp
	(properties
		x 276
		y 102
		view 465
		loop 3
		priority 5
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: duckScript)
	)
)

(instance showGirl of InterProp
	(properties
		x 206
		y 107
		view 465
		loop 2
		priority 6
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: showGirlScript)
	)
)

(instance sparkle of Prop
	(properties
		x 203
		y 40
		view 450
		loop 3
		priority 14
		signal 16
	)
)

(instance sparkle2 of Prop
	(properties
		x 200
		y 70
		view 450
		loop 3
		priority 14
		signal 16
	)
)

(instance sparkle3 of Prop
	(properties
		x 198
		y 63
		view 450
		loop 3
		cel 1
		priority 14
		signal 16
	)
)

(instance tent of InterProp
	(properties
		x 241
		y 120
		view 465
		loop 1
		cel 1
		priority 6
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: tentScript)
	)
)

(instance patch of Prop
	(properties
		x 268
		y 108
		view 425
		loop 1
	)
)

(instance slater of InterProp
	(properties
		x 155
		y 145
		view 465
		priority 7
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance paper of Prop
	(properties
		x 98
		y 124
		view 400
		loop 1
	)
)

(instance mountain of InterProp
	(properties
		x 114
		y 74
		view 465
		cel 1
		signal 20481
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: mountainScript)
		)
	)
)

(instance cavey of Prop
	(properties
		x 76
		y 116
		view 415
	)
)

(instance pack of InterProp
	(properties
		x 118
		y 110
		view 465
		loop 1
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: packScript)
	)
)

(instance tent1 of Prop
	(properties
		x 125
		y 114
		view 485
		priority 7
		signal 20497
	)
)

(instance paper1 of Prop
	(properties
		x 97
		y 80
		view 455
		loop 1
		cel 1
		priority 12
		signal 16401
	)
)

(instance paper2 of Prop
	(properties
		x 99
		y 124
		view 400
		loop 2
		cel 1
		priority 13
		signal 16401
	)
)

(instance charlie of Prop
	(properties
		x 124
		y 106
		view 465
		loop 3
		cel 1
		priority 8
		signal 16
	)
)

(instance slater1 of Prop
	(properties
		x 231
		y 114
		view 455
		priority 9
		signal 20497
	)
)

(instance rowers of Actor
	(properties
		x 332
		y 137
		view 445
		priority 11
		signal 16401
	)
)

(instance stoned of InterActor
	(properties
		x 235
		y 166
		view 465
		loop 1
		cel 3
		priority 10
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: stonedScript)
	)
)

(instance coconut of Actor
	(properties
		x 77
		y 139
		view 405
		priority 14
		signal 20497
	)
)

(instance flyGuy of Actor
	(properties
		x 106
		y 67
		view 410
		loop 1
		priority 13
		signal 24593
	)
)

(instance stars of Actor
	(properties
		x 186
		y 82
		view 435
		priority 3
		signal 24593
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

