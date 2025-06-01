;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use Interface)
(use RegionPath)
(use ForwardCounter)
(use LoadMany)
(use Grooper)
(use Sight)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	street 0
	deathDroid 1
	cyborgPath 2
	cyborgScreams 3
	droidShoots 4
	cyborg 5
)

(local
	local0 = -1
	local1
	local2
	[local3 74] = [0 0 0 0 314 -74 278 120 214 195 152 321 152 321 314 -72 314 -72 240 178 210 333 210 333 314 -72 314 -72 220 165 327 320 327 320 -73 -83 -73 -83 76 183 6 296 6 296 -65 94 -65 94 55 191 133 320 133 320 -24 14 -24 14 70 191 164 298 164 298 -24 180 -24 180 160 160 100 160 100 160]
	[local77 129] = [32767 30 100 500 200 500 32767 35 0 132 24 76 79 57 46 108 100 250 32767 50 0 65 220 75 218 73 40 128 30 250 32767 65 0 100 15 100 103 125 145 151 -5 173 32767 60 319 157 239 175 239 181 -5 150 32767 55 319 100 238 100 295 -1 32767 40 221 250 195 97 79 78 278 35 302 -1 32767 25 91 219 210 145 297 250 32767 40 310 55 270 150 285 250 32767 55 319 65 228 68 109 163 125 145 140 163 242 83 325 83 32767 60 0 140 325 140 32767 65 0 170 60 160 -5 95 32767 50 101 219 90 96 101 92 -5 103 -32768]
	[local206 48] = [-2 -46 1 0 0 0 8 -44 1 0 0 0 13 -43 3 11 -45 3 5 -43 3 9 -43 3 -3 -42 1 0 0 0 -11 -43 2 -8 -43 2 -14 -43 2 -9 -43 2 -6 -46 1 0 0 0]
	[local254 16] = [0 60 -30 30 -60 0 -30 -30 0 -60 30 -30 60 0 30 30]
)

(procedure (localproc_0 param1)
	(if (>= param1 22)
		(return (- param1 22))
	else
		(return (- 360 (- 22 param1)))
	)
)

(class street of Rgn
	(properties
		gracePeriod 4200
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 25 30 35 40 45 50 55 60 65))
		(= initialized 0)
		(if (== (gLongSong2 number:) 21)
			(gLongSong2 fade:)
		)
		(if (== (gLongSong prevSignal:) -1)
			(gLongSong
				number: 801
				loop: -1
				vol: 0
				flags: 1
				playBed:
				fade: 127 15 10 0
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
		(= local1 (Random 500 1000))
		(LoadMany rsVIEW 26)
		(streetSoundFX init:)
		(if (not (IsFlag 0))
			(LoadMany rsVIEW 25 51)
			(cyborg init: setLoop: Grooper setCycle: Walk setMotion: cyborgPath)
		)
	)

	(method (doit)
		(super doit:)
		(if gracePeriod
			(-- gracePeriod)
		)
		(if (and (> local1 0) (not (deathDroid script:)))
			(-= local1 1)
		else
			(= local1 (Random 500 1000))
			(if
				(and
					(not gracePeriod)
					(not (gCurRoom script:))
					(not (IsFlag 0))
					(< (deathDroid z:) 100)
					(not (deathDroid script:))
					(!= gCurRoomNum 45)
					(!= gCurRoomNum 30)
					(!= gCurRoomNum 60)
				)
				(deathDroid init: setCycle: turnCycle setScript: lookScript)
				(gLongSong2 number: 21 vol: 127 loop: -1 flags: 1 play:)
				(gLongSong stop:)
			)
		)
	)
)

(instance deathDroid of Actor
	(properties
		z 45
		description {Droid-O-Death}
		lookStr {The Droid-O-Death, somewhat resembling a stripped down Maytag washer, hovers 15 feet above the surface of the street.}
		yStep 5
		view 25
		priority 14
		signal 26640
		illegalBits 0
		xStep 5
	)

	(method (isNotHidden)
		(return (not (IsOffScreen self)))
	)
)

(instance cyborg of Actor
	(properties
		description {cyborg}
		sightAngle 45
		lookStr {This is the only form of actual life that you've seen down here! It's not a very good specimen though. Its clothes are tattered and a grotesque metal contraption is clamped to its head which serves to hold the eyelids permanently open.}
		yStep 1
		view 51
		signal 24576
		illegalBits 0
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 701 0) ; "He seems to be unaware of your existence, almost as though he is controlled by some other consciousness."
			)
			(11 ; Smell
				(Print 701 1) ; "As a result of being persistently downwind of the cyborg you are very aware that it smells like a slice of luncheon meat that's been walking around in the sun too long."
			)
			(10 ; Taste
				(Print 701 2) ; "Not with your tongue!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (deathDroid script:)
			(cyborg setMotion: 0)
			(if (== local0 -1)
				(= local0 (cyborg loop:))
			)
			(Face cyborg deathDroid)
		)
		(if
			(and
				(not (cyborg z:))
				(!= (gCurRoom script:) cyborgScreams)
				(!= (gCurRoom script:) (ScriptID 812 0)) ; eRS
				(< (cyborg distanceTo: gEgo) 60)
				(!= (gEgo onControl: 1) 256)
				(not (deathDroid script:))
				(or
					(<
						(Abs
							(-
								(GetAngle
									(cyborg x:)
									(cyborg y:)
									(gEgo x:)
									(gEgo y:)
								)
								(cyborg heading:)
							)
						)
						49
					)
					(< (cyborg distanceTo: gEgo) 30)
				)
			)
			(if
				(and
					(== gCurRoomNum 50)
					(== (gCurRoom script:) (ScriptID 50 1)) ; grateScript
					(== (gEgo view:) 50)
				)
				(cyborg setMotion: 0)
				(Face cyborg gEgo)
			else
				(HandsOff)
				(gEgo setMotion: 0)
				(gCurRoom setScript: cyborgScreams)
			)
		)
	)

	(method (isNotHidden)
		(return (not (IsOffScreen self)))
	)
)

(instance cyborgPath of RegionPath
	(properties
		theRegion 701
	)

	(method (at param1)
		(return [local77 param1])
	)

	(method (nextRoom)
		(if
			(and
				(== gCurRoomNum (self at: (+ value 2)))
				(<
					(GetDistance
						(self at: (+ value 3))
						(self at: (+ value 4))
						(gEgo x:)
						(gEgo y:)
					)
					50
				)
			)
			(repeat
				(-= value 2)
				(breakif (== (self at: (+ 1 value)) 32767))
			)
		)
		(super nextRoom: &rest)
	)
)

(instance lookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2
					(switch gCurRoomNum
						(25 4)
						(35 54)
						(40 14)
						(50 44)
						(55 24)
						(60 64)
						(65 34)
					)
				)
				(self register: (if (> (gEgo y:) 120) -1 else 1))
				(deathDroid
					x: [local3 (+ local2 (* 4 register) 4)]
					y: [local3 (+ local2 (* 4 register) 5)]
					setCycle: turnCycle
					setMotion:
						MoveTo
						[local3 (+ local2 (* 2 register) 4)]
						[local3 (+ local2 (* 2 register) 5)]
						self
				)
			)
			(1
				(deathDroid
					setMotion:
						MoveTo
						[local3 (+ local2 4)]
						[local3 (+ local2 5)]
						self
				)
			)
			(2
				(if
					(or
						(and
							(or
								(not (gCurRoom script:))
								(== (gCurRoom script:) cyborgScreams)
								(== (gCurRoom script:) (ScriptID 705 2)) ; ropeScript
							)
							(!= (gEgo onControl: 1) 256)
						)
						(== (gCurRoom script:) cyborgScreams)
					)
					(HandsOff)
					(deathDroid cycleSpeed: 2 setScript: droidShoots)
				else
					(deathDroid cycleSpeed: 2 setCycle: End self)
					(SetScore 45 5)
				)
			)
			(3
				(deathDroid loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if
					(and
						(not (gCurRoom script:))
						(!= (gEgo onControl: 1) 256)
					)
					(HandsOff)
					(deathDroid setScript: droidShoots)
				else
					(= cycles 1)
				)
			)
			(5
				(deathDroid
					setCycle:
						CT
						(if (== register -1)
							(switch gCurRoomNum
								(25 5)
								(35 3)
								(40 5)
								(50 3)
								(55 4)
								(65 4)
							)
						else
							(switch gCurRoomNum
								(25 1)
								(35 7)
								(40 1)
								(50 7)
								(55 1)
								(65 7)
							)
						)
						-1
						self
				)
			)
			(6
				(deathDroid
					cycleSpeed: 0
					setCycle: turnCycle
					setMotion:
						MoveTo
						[local3 (+ local2 (* 2 register -1) 4)]
						[local3 (+ local2 (* 2 register -1) 5)]
						self
				)
			)
			(7
				(deathDroid
					setMotion:
						MoveTo
						[local3 (+ local2 (* 4 register -1) 4)]
						[local3 (+ local2 (* 4 register -1) 5)]
						self
				)
				(cyborg setLoop: -1)
				(gLongSong2 fade:)
			)
			(8
				(deathDroid dispose:)
				(gLongSong
					number: 801
					loop: -1
					vol: 0
					playBed:
					flags: 1
					fade: 127 15 10 0
				)
				(cyborg
					loop: local0
					setLoop: Grooper
					setCycle: Walk
					setMotion: cyborgPath
				)
				(= local0 -1)
				(lookScript start: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance droidShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathDroid
					setCycle:
						CT
						(Min
							7
							(/
								(*
									(GetAngle
										(deathDroid x:)
										(deathDroid y:)
										(gEgo x:)
										(gEgo y:)
									)
									4
								)
								180
							)
						)
						-1
						self
				)
			)
			(1
				(if (< (deathDroid distanceTo: gEgo) 30)
					(if (< 2 (deathDroid cel:) 7)
						(deathDroid setPri: 13)
					)
					(deathDroid
						xStep: 10
						yStep: 10
						setCycle: 0
						setMotion:
							MoveTo
							(+
								(deathDroid x:)
								[local254 (* (deathDroid cel:) 2)]
							)
							(+
								(deathDroid y:)
								[local254 (+ (* (deathDroid cel:) 2) 1)]
							)
							self
					)
				else
					(deathDroid setCycle: 0)
					(= cycles 2)
				)
			)
			(2
				(HandsOff)
				(= cycles 2)
			)
			(3
				(HandsOff)
				(Face gEgo deathDroid)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(4
				(HandsOff)
				(gunFire1
					init:
					x: (+ (deathDroid x:) [local206 (* (deathDroid cel:) 6)])
					y:
						(+
							(deathDroid y:)
							[local206 (+ (* (deathDroid cel:) 6) 1)]
						)
					loop: [local206 (+ (* (deathDroid cel:) 6) 2)]
					setPri: (if (< 2 (deathDroid cel:) 7) 14 else 12)
					setCycle: End
				)
				(if (< 1 [local206 (+ (* (deathDroid cel:) 6) 2)] 4)
					(gunFire2
						init:
						x:
							(+
								(deathDroid x:)
								[local206 (+ (* (deathDroid cel:) 6) 3)]
							)
						y:
							(+
								(deathDroid y:)
								[local206 (+ (* (deathDroid cel:) 6) 4)]
							)
						loop: [local206 (+ (* (deathDroid cel:) 6) 5)]
						setPri: (if (< 2 (deathDroid cel:) 7) 14 else 12)
						setCycle: End
					)
				)
				(= cycles 3)
			)
			(5
				(HandsOff)
				(streetSoundFX number: 106 loop: 1 play:)
				(= cycles 3)
			)
			(6
				(streetSoundFX play:)
				(if (IsObject (ScriptID 705 3)) ; tempHead
					((ScriptID 705 3) dispose:) ; tempHead
				)
				(HandsOff)
				(gLongSong number: 135 loop: -1 vol: 127 flags: 0 play:)
				(gEgo
					view: 26
					normal: 0
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 1 1
					setMotion: 0
				)
				(= cycles 3)
			)
			(7
				(streetSoundFX play:)
				(HandsOff)
				(gunFire1 dispose:)
				(gunFire2 dispose:)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo setCycle: CT 1 1 self)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo setCycle: CT 1 1 self)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo setCycle: End self)
			)
			(13
				(gLongSong stop:)
				(= seconds 3)
				(gLongSong2 fade:)
			)
			(14
				(EgoDead 8) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
		)
	)
)

(instance cyborgScreams of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 7) (== (streetSoundFX prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face cyborg gEgo)
				(Face gEgo cyborg)
				(= cycles 3)
			)
			(1
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(2
				((ScriptID 705 1) dispose:) ; theBunny
				(Load rsSOUND 114)
				(cyborg hide: setMotion: 0)
				(deathDroid mover: 0)
				(gEgo hide:)
				(DrawPic 31 10)
				(gCurRoom curPic: 31)
				(theMouth init:)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(gLongSong2 number: 829 loop: -1 vol: 127 flags: 1 play:)
				(gTheIconBar enable:)
				(HandsOff)
				(= seconds 3)
			)
			(4
				(theMouth setCycle: ForwardCounter 9 self)
			)
			(5
				(theMouth
					posn: 142 106
					setLoop: 1
					setCycle: ForwardCounter 7 self
				)
			)
			(6
				(theMouth
					posn: 152 104
					setLoop: 2
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(streetSoundFX number: 114 loop: 1 flags: 1 play:)
				(hand init:)
				(theMouth posn: 151 127 setLoop: 3 setCycle: Fwd)
			)
			(8
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(9
				(hand dispose:)
				(theMouth dispose:)
				(cyborg show:)
				(gEgo show:)
				(DrawPic gCurRoomNum)
				(gCurRoom curPic: gCurRoomNum)
				(UnLoad 132 114)
				(UnLoad 129 31)
				(LoadMany rsVIEW 25 26)
				(LoadMany rsSOUND 106 135)
				(= cycles 1)
			)
			(10
				(gTheIconBar enable:)
				(gLongSong2 number: 21 vol: 127 loop: -1 flags: 1 play:)
				(gLongSong stop:)
				(deathDroid init: setCycle: turnCycle setScript: lookScript)
				(cyborg setMotion: 0)
			)
			(11 0)
		)
	)
)

(instance theMouth of Actor
	(properties
		x 153
		y 106
		view 31
		signal 24576
	)
)

(instance hand of View
	(properties
		x 118
		y 189
		view 31
		loop 4
		signal 24576
	)
)

(instance gunFire1 of Prop
	(properties
		z 45
		view 25
		loop 1
		signal 16384
	)
)

(instance gunFire2 of Prop
	(properties
		z 45
		view 25
		loop 2
		signal 16384
	)
)

(instance turnCycle of Fwd
	(properties)

	(method (nextCel)
		(return (+ (/ (* (localproc_0 (client heading:)) 4) 180) 1))
	)
)

(instance streetSoundFX of Sound
	(properties
		number 106
	)
)

