;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use CycleBet)
(use LoadMany)
(use DPath)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm7 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm7 of Rm
	(properties
		picture 700
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 991 964)
		(aSpider init: setOnMeCheck: 1 16384)
		(stemTail init:)
		(unknown_7_21 init: setOnMeCheck: 1 8192)
		(stemTail2 init:)
		(unknown_7_22 init: setOnMeCheck: 1 4096)
		(aWord0 init:)
		(aWord1 init:)
		(aWord2 init:)
		(aWord3 init:)
		(charlie init:)
		(slater init:)
		(rock init:)
		(cactus init:)
		(guitar init:)
		(smallGuitar init:)
		(cattail init:)
		(cactusDino init:)
		(vine1 init:)
		(vine2 init:)
		(vine3 init:)
		(vine4 init:)
		(vine5 init:)
		(pad init:)
		(pad2 init:)
		(sky init:)
		(spit init:)
		(log init:)
		(gLongSong2 number: 130 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local0) (not (gCurRoom script:)))
			(= local0 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(my3Sound dispose:)
		(DisposeScript 991)
		(DisposeScript 964)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade: 0 10 30 1)
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
				(= ticks 60)
			)
			(1
				(gGame handsOff:)
				(theView view: 775 setLoop: 0 setCel: 1 posn: 140 182 init:)
				(mySound number: 1048 setLoop: 1 play:)
				(= ticks 16)
			)
			(2
				(gGame handsOff:)
				(theProp view: 775 setLoop: 1 setCel: 1 posn: 203 182 init:)
				(= ticks 41)
			)
			(3
				(theView hide: dispose:)
				(rock setCel: 0)
				(= ticks 18)
			)
			(4
				(theProp hide: dispose:)
				(rock stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance skyScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (upside loop:) 0) (OneOf (upside cel:) 1 4))
			(mySound number: 956 setLoop: 1 play:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(upside init: setCycle: Fwd setMotion: MoveTo 131 52 self)
			)
			(1
				(mySound stop:)
				(upside setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(2
				(= ticks 50)
			)
			(3
				(mySound number: 904 setLoop: 1 play:)
				(upside setCycle: CT 6 1)
				(= ticks 50)
			)
			(4
				(my2Sound number: 1014 setLoop: 1 play:)
				(fallsOut
					init:
					setLoop: 2
					setCel: 0
					setPri: 10
					ignoreActors:
					posn: 180 73
				)
				(= ticks 12)
			)
			(5
				(fallsOut posn: 180 93)
				(= ticks 12)
			)
			(6
				(fallsOut posn: 180 113)
				(= ticks 12)
			)
			(7
				(fallsOut posn: 180 140)
				(= ticks 12)
			)
			(8
				(mySound number: 997 setLoop: 1 play:)
				(upside setCycle: CT 6 1)
				(fallsOut setLoop: 3 setCel: 0 setCycle: End self)
			)
			(9
				(fallsOut setLoop: 2 setCel: 0 posn: 155 86 hide: dispose:)
				(upside setCycle: Beg self)
			)
			(10
				(mySound number: 956 setLoop: -1 play:)
				(upside
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 289 49 self
				)
			)
			(11
				(mySound stop:)
				(upside
					setLoop: 0
					setCel: 0
					setCycle: 0
					posn: 0 51
					hide:
					dispose:
				)
				(= cycles 2)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance padScript of Script
	(properties)

	(method (doit)
		(if (and (== state 2) (not local6))
			(cond
				((< 140 (fly x:) 160)
					(= local6 1)
					(fEyes setCel: 3)
				)
				((< 100 (fly x:) 130)
					(fEyes setCel: 2)
				)
				((< 60 (fly x:) 92)
					(fEyes setCel: 1)
				)
				((< 20 (fly x:) 40)
					(fEyes setCel: 0)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(splash init: setCycle: End)
				(frog init: setCycle: CT 5 1 self)
				(mySound number: 997 setLoop: 1 play:)
			)
			(1
				(mySound number: 926 setLoop: 1 play:)
				(splash setCel: 0 hide: dispose:)
				(frog setCycle: CT 7 1 self)
			)
			(2
				(fEyes init:)
				(mySound number: 903 setLoop: -1 play:)
				(fly
					setLoop: 4
					setCel: 0
					posn: 35 117
					init:
					cycleSpeed: 8
					setPri: 11
					setCycle: Fwd
					setMotion:
						DPath
						37
						117
						70
						101
						108
						96
						152
						99
						165
						113
						147
						129
						105
						113
						self
				)
			)
			(3
				(fly setLoop: 4 posn: 105 113 setCycle: Fwd)
				(Load rsSOUND 1013)
				(= ticks 25)
			)
			(4
				(mySound stop:)
				(fEyes setCel: 0 dispose:)
				(fly setLoop: 2 setCel: 0 posn: 82 159 setCycle: CT 5 1 self)
			)
			(5
				(my2Sound number: 1013 setLoop: 1 play:)
				(frog hide: setCel: 0 dispose:)
				(fly setCycle: CT 6 1 self)
				(Load rsSOUND 908)
			)
			(6
				(mySound number: 908 setLoop: 1 play:)
				(fly setCycle: CT 7 1 self)
			)
			(7
				(mySound number: 903 setLoop: -1 play:)
				(fly setCycle: CT 10 1 self)
			)
			(8
				(fly
					setLoop: 4
					posn: 105 113
					setCycle: Fwd
					setMotion: MoveTo -15 113 self
				)
			)
			(9
				(mySound stop:)
				(fly setCel: 0 hide: dispose:)
				(= local6 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vine1Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local1
					(1
						(= local2 vine1)
						(local2 setLoop: 2)
					)
					(2
						(= local2 vine2)
						(local2 setLoop: 1)
					)
					(3
						(= local2 vine3)
						(local2 setLoop: 0)
					)
					(4
						(= local2 vine4)
						(local2 setLoop: 1)
					)
					(5
						(= local2 vine5)
						(local2 setLoop: 3)
					)
				)
				(local2 view: 755 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 1016 setLoop: -1 play:)
				(local2 setCycle: CycleBet 1 4 5 self)
			)
			(2
				(local2 setCel: 12 setCycle: Beg self)
			)
			(3
				(mySound stop:)
				(local2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance logScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(logDino posn: 243 119)
				(= ticks 6)
			)
			(1
				(logDino init: setLoop: 1 setPri: 2 setCycle: End self)
			)
			(2
				(mySound number: 932 setLoop: 1 play: self)
				(logDino setLoop: 0 setPri: -1 setCycle: Fwd)
			)
			(3
				(mySound play: self)
			)
			(4
				(logDino setCycle: 0 setLoop: 1 setCel: 1 setPri: 2)
				(= cycles 2)
			)
			(5
				(logDino setCycle: Beg self)
			)
			(6
				(logDino dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 1012 964)
				(mySound number: 997 setLoop: 1 play:)
				(spiter
					init:
					setLoop: 0
					setCel: 0
					moveSpeed: 6
					setPri: 10
					setCycle: End
					setMotion: MoveTo 114 130 self
				)
			)
			(1
				(mySound number: 1012 setLoop: 1 play:)
				(spiter setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(spiter setMotion: MoveTo 68 133 self)
			)
			(3
				(Load rsSOUND 964)
				(= ticks 5)
			)
			(4
				(spiter setPri: 11 setCel: 6)
				(= ticks 100)
			)
			(5
				(mySound number: 964 setLoop: -1 play:)
				(= ticks 2)
			)
			(6
				(spiter setCel: 5)
				(water init:)
				(= ticks 2)
			)
			(7
				(water setCycle: End self)
			)
			(8
				(water setLoop: 5 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(9
				(water hide: dispose: setCel: 0 setCycle: 0)
				(aDrip posn: 108 105 init: show: setCycle: End self)
			)
			(10
				(aDrip setCycle: 0 setCel: 0 hide: dispose:)
				(spiter setCel: 6)
				(= ticks 60)
			)
			(11
				(mySound number: 997 setLoop: 1 play:)
				(spiter setLoop: 3 setCel: 0 setCycle: End self)
			)
			(12
				(spiter
					view: 745
					setLoop: 1
					setCel: 0
					posn: 68 133
					hide:
					dispose:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aSpiderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spider
					init:
					setLoop: 0
					setCel: 0
					moveSpeed: 0
					setMotion: MoveTo 209 24 self
				)
			)
			(1
				(mySound number: 951 setLoop: 1 play:)
				(spider setMotion: MoveTo 209 87 self)
			)
			(2
				(spider setCycle: End)
				(charlie view: 725 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(= ticks 25)
			)
			(4
				(my2Sound number: 1014 setLoop: 1 play:)
				(spider setLoop: 1 setCel: 0 posn: 203 81)
				(charlie view: 735 setLoop: 1 setCel: 1 posn: 205 82)
				(= ticks 12)
			)
			(5
				(mySound number: 1014 setLoop: 1 play:)
				(= ticks 75)
			)
			(6
				(spider setLoop: 0 setCel: 2 posn: 209 87 setCycle: Beg self)
				(charlie
					view: 725
					setLoop: 0
					setCel: 2
					posn: 190 136
					setCycle: Beg
				)
			)
			(7
				(mySound number: 974 setLoop: 1 play:)
				(if global143
					(self cue:)
				else
					(spider setCel: 0 posn: 209 97)
					(= ticks 1)
				)
			)
			(8
				(mySound number: 974 setLoop: 1 play:)
				(if global143
					(self cue:)
				else
					(spider posn: 209 70)
					(= ticks 1)
				)
			)
			(9
				(if global143
					(self cue:)
				else
					(spider posn: 209 66)
					(= ticks 1)
				)
			)
			(10
				(if global143
					(self cue:)
				else
					(spider posn: 209 33)
					(= ticks 1)
				)
			)
			(11
				(if global143
					(self cue:)
				else
					(spider posn: 209 26)
					(= ticks 1)
				)
			)
			(12
				(spider setCel: 0 posn: 209 26 dispose:)
				(charlie
					view: 790
					setLoop: 0
					setCel: 1
					posn: 190 136
					setPri: 11
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stemTailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local5
					(stemTail setPri: 14 setCycle: CT 1 1 self)
				else
					(self cue:)
				)
			)
			(1
				(if local5
					(stemTail setCycle: CT 2 1 self)
				else
					(stemTail2 setCycle: CT 1 1 self)
				)
			)
			(2
				(mySound number: 994 setLoop: 1 play:)
				(if local5
					(stemTail setCycle: CT 5 1 self)
				else
					(stemTail2 setCycle: CT 5 1 self)
				)
			)
			(3
				(mySound number: 1152 setLoop: 1 play:)
				(if local5
					(stemTail setCel: 6)
				else
					(stemTail2 setCel: 6)
				)
				(= ticks 6)
			)
			(4
				(if local5
					(stemTail setCycle: CT 8 1 self)
				else
					(stemTail2 setCycle: CT 8 1 self)
				)
			)
			(5
				(mySound number: 994 setLoop: 1 play:)
				(if local5
					(stemTail setCycle: CT 12 1 self)
				else
					(stemTail2 setCycle: CT 12 1 self)
				)
			)
			(6
				(if local5
					(stemTail setPri: 9 setCel: 0 stopUpd:)
				else
					(stemTail2 setCel: 0 stopUpd:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cactusDino view: 720 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 5)
			)
			(1
				(mySound number: 908 setLoop: 1 play: self)
				(my2Sound number: 907 play: self setLoop: 1)
			)
			(2)
			(3
				(bone init: hide:)
				(= ticks 12)
			)
			(4
				(cactusDino setCycle: 0 setCel: 0)
				(mySound number: 1015 setLoop: 1 play:)
				(bone show: setMotion: JumpTo 134 47 self)
			)
			(5
				(bone setMotion: JumpTo 139 133 self)
			)
			(6
				(bone posn: 139 128)
				(= ticks 3)
			)
			(7
				(bone posn: 139 133)
				(= ticks 3)
			)
			(8
				(mySound number: 941 setLoop: 1 play: self)
			)
			(9
				(= ticks 45)
			)
			(10
				(boneDino init:)
				(mySound number: 997 setLoop: 1 play:)
				(boneDino setLoop: 1 setCel: 0 setCycle: 0)
				(= ticks 5)
			)
			(11
				(mySound number: 908 setLoop: 1 play:)
				(my2Sound number: 907 play: setLoop: 1)
				(bone hide: posn: 143 79 dispose:)
				(boneDino cycleSpeed: 0 setCycle: CT 4 1 self)
			)
			(12
				(mySound stop:)
				(my2Sound stop:)
				(boneDino setCycle: CT 7 1 self)
			)
			(13
				(mySound number: 997 setLoop: 1 play:)
				(boneDino setCycle: End self)
			)
			(14
				(boneDino hide: setCel: 0 dispose:)
				(cactusDino view: 790 setLoop: 1 setCel: 0 stopUpd:)
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
				(slater view: 725 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(slater setCel: 0)
				(= ticks 25)
			)
			(2
				(slater setCycle: CT 2 1 self)
			)
			(3
				(slater setCel: 0)
				(= ticks 25)
			)
			(4
				(fish init: hide:)
				(slater setCel: 0 setCycle: CT 2 1 self)
			)
			(5
				(slater setPri: 7 setCel: 3)
				(fish view: 725 setLoop: 2 setCel: 0 setPri: 8 show:)
				(= ticks 12)
			)
			(6
				(mySound number: 997 setLoop: 1 play:)
				(fish cycleSpeed: 6 setCycle: CT 2 1 self)
			)
			(7
				(slater hide:)
				(my2Sound number: 988 setLoop: 1 play:)
				(fish setCycle: CT 3 1 self)
			)
			(8
				(mySound number: 911 setLoop: 1 play:)
				(slater
					view: 790
					setLoop: 1
					setCel: 2
					posn: 177 111
					show:
					stopUpd:
				)
				(fish dispose:)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fishScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slater view: 725 setLoop: 3 setCel: 1 posn: 177 111)
				(sneeze posn: (+ (slater x:) 4) (- (slater y:) 4) init:)
				(= ticks 1)
			)
			(1
				(mySound number: 1149 setLoop: 1 play:)
				(= ticks 22)
			)
			(2
				(mySound number: 1159 setLoop: 1 play:)
				(sneeze posn: (+ (sneeze x:) 4) (- (sneeze y:) 4))
				(= ticks 16)
			)
			(3
				(mySound number: 1160 setLoop: 1 play:)
				(sneeze posn: (+ (sneeze x:) 4) (- (sneeze y:) 4))
				(= ticks 16)
			)
			(4
				(fish1 init:)
				(sneeze posn: (- (sneeze x:) 16) (+ (sneeze y:) 16))
				(mySound number: 982 setLoop: 1 play:)
				(= ticks 24)
			)
			(5
				(fish1 dispose:)
				(sneeze posn: (+ (sneeze x:) 4) (- (sneeze y:) 4))
				(= ticks 6)
			)
			(6
				(sneeze dispose:)
				(slater
					view: 790
					setLoop: 1
					setCel: 2
					posn: 177 111
					show:
					forceUpd:
					stopUpd:
				)
				(= cycles 2)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cactusDinoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cDino
					init:
					moveSpeed: 3
					ignoreActors:
					setPri: 4
					setMotion: JumpTo 118 27 self
				)
			)
			(1
				(mySound number: 1014 play: setLoop:)
				(cDino
					init:
					moveSpeed: 3
					ignoreActors:
					setMotion: JumpTo 180 85 self
				)
			)
			(2
				(cactusDino view: 720 setLoop: 1 setCel: 0 setCycle: Fwd)
				(cDino hide: posn: 83 69 dispose:)
				(mySound number: 1005 setLoop: 1 play: self)
				(= ticks 5)
			)
			(3
				(my3Sound number: 908 setLoop: 1 play: self)
				(my2Sound number: 907 setLoop: 1 play: self)
			)
			(4)
			(5)
			(6
				(my3Sound stop:)
				(cactusDino stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cattailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local4
					(= local4 0)
					(mySound number: 950 setLoop: 1 play:)
					(cattail setPri: -1 setCycle: CT 3 -1 self)
				else
					(= local4 1)
					(cattail
						view: 715
						setLoop: 0
						setCel: 0
						setCycle: CT 3 1 self
					)
				)
			)
			(1
				(if local4
					(mySound number: 986 setLoop: 1 play:)
					(cattail setCycle: CT 5 1 self)
				else
					(cattail setCycle: CT 0 -1 self)
				)
			)
			(2
				(if local4
					(mySound stop:)
				)
				(= ticks 60)
			)
			(3
				(if local4
					(cattail stopUpd:)
				else
					(cattail setPri: -1 view: 790 setLoop: 0 setCel: 2 stopUpd:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance charlieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 710)
				(charlie
					view: 725
					setLoop: 0
					setCel: 0
					posn: 192 137
					setCycle: End self
				)
			)
			(1
				(charlie view: 710 setLoop: 0 setCel: 0 posn: 154 141)
				(mySound number: 912 setLoop: 1 play:)
				(= ticks 25)
			)
			(2
				(charlie
					view: 725
					setLoop: 0
					setCel: 0
					posn: 192 137
					setCycle: End self
				)
			)
			(3
				(mySound number: 912 setLoop: 1 play:)
				(charlie view: 710 setLoop: 0 setCel: 0 posn: 154 141)
				(= ticks 25)
			)
			(4
				(charlie setCycle: CT 1 1 self)
			)
			(5
				(mySound number: 997 setLoop: 1 play:)
				(charlie setCycle: CT 3 1 self)
			)
			(6
				(= ticks 50)
			)
			(7
				(mySound number: 927 setLoop: 1 play:)
				(charlie setCycle: CT 5 1)
				(= ticks 40)
			)
			(8
				(charlie setCycle: CT 3 -1)
				(= ticks 50)
			)
			(9
				(mySound number: 997 setLoop: 1 play:)
				(charlie setCel: 7)
				(= ticks 6)
			)
			(10
				(my2Sound number: 1011 setLoop: -1 play:)
				(charlie setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 150)
			)
			(11
				(my2Sound stop:)
				(charlie
					view: 790
					setLoop: 0
					setCel: 1
					posn: 190 136
					setCycle: 0
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guitarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 928 1017)
				(gLongSong2 number: 130 setLoop: -1 play:)
				(smallGuitar view: 700 setLoop: 2 setCel: 0 setCycle: CT 1 1)
				(guitar view: 700 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(smallGuitar setCycle: CT 6 1)
				(guitar setCycle: CT 6 1 self)
				(mySound number: 928 setLoop: 1 play:)
			)
			(2
				(mySound number: 1017 setLoop: -1 play:)
				(smallGuitar setLoop: 3 setCel: 0 setCycle: Fwd)
				(guitar setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 250)
			)
			(3
				(smallGuitar setLoop: 2 setCel: 6 setCycle: 0)
				(guitar setLoop: 0 setCel: 5 setCycle: 0)
				(= ticks 6)
			)
			(4
				(mySound number: 928 setLoop: 1 play:)
				(smallGuitar setCycle: CT 0 -1 self)
				(guitar setCycle: CT 0 -1 self)
			)
			(5
				(mySound stop:)
				(smallGuitar view: 790 setLoop: 3 setCel: 0 stopUpd:)
				(guitar view: 790 setLoop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 174
		nsLeft 97
		nsBottom 181
		nsRight 134
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm7)
		(theView view: 780 setLoop: 0 posn: 114 182 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 174
		nsLeft 138
		nsBottom 181
		nsRight 180
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1092 setLoop: 1 play: rm7)
		(theView view: 780 setLoop: 1 posn: 157 182 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 174
		nsLeft 181
		nsBottom 181
		nsRight 192
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1093 setLoop: 1 play: rm7)
		(theView view: 780 setLoop: 2 posn: 186 182 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 174
		nsLeft 195
		nsBottom 181
		nsRight 223
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1094 setLoop: 1 play: rm7)
		(theView view: 780 setLoop: 3 posn: 206 182 init:)
	)
)

(instance aSpider of InterFeature
	(properties)

	(method (doVerb)
		(gCurRoom setScript: aSpiderScript)
	)
)

(instance unknown_7_21 of InterFeature
	(properties
		y 190
	)

	(method (doVerb)
		(stemTail doVerb:)
	)
)

(instance unknown_7_22 of InterFeature
	(properties
		y 190
	)

	(method (doVerb)
		(stemTail2 doVerb:)
	)
)

(instance cactus of InterFeature
	(properties
		nsTop 36
		nsLeft 35
		nsBottom 97
		nsRight 91
	)

	(method (doVerb)
		(gCurRoom setScript: cactusDinoScript)
	)
)

(instance log of InterFeature
	(properties
		nsTop 83
		nsLeft 169
		nsBottom 120
		nsRight 249
	)

	(method (doVerb)
		(gCurRoom setScript: logScript)
	)
)

(instance spit of InterFeature
	(properties
		nsTop 117
		nsLeft 34
		nsBottom 148
		nsRight 289
	)

	(method (doVerb)
		(gCurRoom setScript: spitScript)
	)
)

(instance pad2 of InterFeature
	(properties
		nsTop 134
		nsLeft 67
		nsBottom 148
		nsRight 112
	)

	(method (doVerb)
		(gCurRoom setScript: padScript)
	)
)

(instance pad of InterFeature
	(properties
		nsTop 122
		nsLeft 34
		nsBottom 132
		nsRight 63
	)

	(method (doVerb)
		(gCurRoom setScript: padScript)
	)
)

(instance sky of InterFeature
	(properties
		nsLeft 34
		nsBottom 52
		nsRight 152
	)

	(method (doVerb)
		(gCurRoom setScript: skyScript)
	)
)

(instance rock of InterView
	(properties
		x 86
		y 181
		view 785
		loop 3
		priority 14
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance fish1 of View
	(properties
		x 179
		y 95
		view 740
		priority 10
		signal 4112
	)
)

(instance sneeze of View
	(properties
		x 177
		y 111
		view 725
		loop 3
		priority 8
		signal 16
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

(instance vine1 of InterProp
	(properties
		x 11
		y 89
		view 790
		loop 2
		cel 2
		priority 6
		signal 16401
	)

	(method (doVerb)
		(= local1 1)
		(gCurRoom setScript: vine1Script)
	)
)

(instance vine2 of InterProp
	(properties
		x 206
		y 173
		view 755
		loop 1
		priority 13
		signal 16401
	)

	(method (doVerb)
		(= local1 2)
		(gCurRoom setScript: vine1Script)
	)
)

(instance vine3 of InterProp
	(properties
		x 164
		y 167
		view 790
		loop 2
		priority 12
		signal 16401
	)

	(method (doVerb)
		(= local1 3)
		(gCurRoom setScript: vine1Script)
	)
)

(instance vine4 of InterProp
	(properties
		x 141
		y 183
		view 755
		loop 1
		priority 12
		signal 16401
	)

	(method (doVerb)
		(= local1 4)
		(gCurRoom setScript: vine1Script)
	)
)

(instance vine5 of InterProp
	(properties
		x 30
		y 127
		view 790
		loop 2
		cel 3
		priority 14
		signal 16401
	)

	(method (doVerb)
		(= local1 5)
		(gCurRoom setScript: vine1Script)
	)
)

(instance stemTail of InterProp
	(properties
		x 243
		y 154
		view 730
		priority 9
		signal 4113
	)

	(method (doVerb)
		(= local5 1)
		(gCurRoom setScript: stemTailScript)
	)
)

(instance stemTail2 of InterProp
	(properties
		x 247
		y 158
		view 730
		loop 1
		priority 9
		signal 4113
	)

	(method (doVerb)
		(= local5 0)
		(gCurRoom setScript: stemTailScript)
	)
)

(instance slater of InterProp
	(properties
		x 173
		y 113
		view 790
		loop 1
		cel 1
		priority 10
		signal 20497
	)

	(method (doVerb)
		(if (not local3)
			(gCurRoom setScript: slaterScript)
		else
			(gCurRoom setScript: fishScript)
		)
	)
)

(instance fish of Prop
	(properties
		x 177
		y 111
		view 790
		loop 1
		cel 2
		signal 20481
	)
)

(instance logDino of Prop
	(properties
		view 750
		priority 9
		signal 16
	)
)

(instance water of Prop
	(properties
		x 109
		y 103
		view 746
		loop 2
		priority 12
		signal 16
	)
)

(instance aDrip of Prop
	(properties
		x 108
		y 105
		view 747
		loop 4
		priority 11
		signal 16
	)
)

(instance cactusDino of InterProp
	(properties
		x 145
		y 96
		view 790
		loop 1
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: boneScript)
	)
)

(instance cattail of InterProp
	(properties
		x 138
		y 119
		view 790
		cel 2
		signal 16385
	)

	(method (doVerb)
		(gCurRoom setScript: cattailScript)
	)
)

(instance guitar of InterProp
	(properties
		x 116
		y 80
		view 790
		priority 3
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: guitarScript)
	)
)

(instance smallGuitar of InterProp
	(properties
		x 280
		y 70
		view 790
		loop 3
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: guitarScript)
	)
)

(instance charlie of InterProp
	(properties
		x 190
		y 136
		view 790
		cel 1
		priority 11
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: charlieScript)
	)
)

(instance splash of Prop
	(properties
		x 90
		y 174
		view 765
		priority 9
		signal 16
	)
)

(instance frog of Prop
	(properties
		x 83
		y 159
		view 765
		loop 1
		priority 10
		signal 16
	)
)

(instance fEyes of Prop
	(properties
		x 83
		y 133
		view 765
		loop 3
		priority 14
		signal 16400
	)
)

(instance fly of Actor
	(properties
		x 35
		y 117
		view 765
		loop 4
		priority 10
		signal 16
	)
)

(instance spiter of Actor
	(properties
		x 68
		y 133
		view 745
		loop 1
		priority 11
		signal 16400
	)
)

(instance upside of Actor
	(properties
		y 51
		view 770
		priority 13
		signal 24592
	)
)

(instance fallsOut of Actor
	(properties
		x 155
		y 86
		view 770
		loop 2
		priority 11
		signal 24592
	)
)

(instance spider of Actor
	(properties
		x 209
		y 26
		view 735
		priority 13
		signal 24592
	)
)

(instance cDino of Actor
	(properties
		x 83
		y 69
		view 720
		signal 16384
	)
)

(instance bone of Actor
	(properties
		x 143
		y 79
		view 705
		priority 8
		signal 16400
	)
)

(instance boneDino of Actor
	(properties
		x 139
		y 133
		view 705
		loop 1
		priority 8
		signal 16400
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

(instance my3Sound of Sound
	(properties)
)

