;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use n013)
(use sweepRgn)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm180 0
	oakMan 1
)

(local
	[local0 7] = [1180 40 1 1 1 1 0]
	[local7 13] = [1180 44 1 2 1 1 2 1 1 1 1 1 0]
	[local20 5] = [1180 58 1 1 0]
	[local25 4] = [1180 60 1 0]
	[local29 4] = [1180 64 1 0]
	[local33 5] = [1180 65 1 1 0]
	[local38 5] = [1180 101 1 1 0]
	[local43 4] = [1180 56 1 0]
	[local47 7] = [1180 79 2 1 1 1 0]
	[local54 7] = [1180 83 1 1 1 1 0]
	[local61 5] = [1180 61 1 1 0]
	[local66 4] = [1180 30 1 0]
	[local70 4] = [1180 31 1 0]
	[local74 4] = [1180 32 1 0]
	[local78 4] = [1180 33 1 0]
	[local82 4] = [1180 34 1 0]
	[local86 4] = [1180 35 1 0]
	[local90 4] = [1180 36 1 0]
	[local94 4] = [1180 37 1 0]
	[local98 4] = [1180 38 1 0]
	[local102 6] = [1180 68 2 1 1 0]
	[local108 5] = [1180 71 2 1 0]
	[local113 4] = [1180 73 1 0]
	[local117 4] = [1180 67 1 0]
	[local121 4] = [1180 87 1 0]
	[local125 4] = [1180 88 1 0]
	[local129 4] = [1180 92 1 0]
	[local133 4] = [1180 93 1 0]
	[local137 4] = [1180 89 1 0]
	[local141 5] = [1180 90 1 1 0]
	[local146 10] = [1180 94 2 1 1 1 1 1 1 0]
	[local156 4] = [1180 105 1 0]
	[local160 5] = [1180 103 1 1 0]
	[local165 4] = [1180 108 1 0]
	[local169 5] = [1180 77 2 1 0]
	[local174 5] = [1180 109 1 1 0]
	[local179 4] = [1180 126 1 0]
	[local183 9] = [186 0 2 4 22 24 19 16 8]
	[local192 9] = [46 0 2 4 17 37 14 22 7]
	[local201 8] = [-1 0 0 0 0 0 0 0]
	[local209 520]
	local729
	local730
	local731
	local732
	local733
	local734
	local735
	local736
	local737
	local738
	local739
	local740
	local741
	local742
)

(procedure (localproc_0)
	(switch local730
		(0
			(localproc_1 (GetFarText 1180 2 @local209) 100 5 181) ; "I can sing, but have no mouth."
			(localproc_1 (GetFarText 1180 1 @local209) 100 5 172) ; "I can fly, but have no wings, I can float, but have no fins,"
			(localproc_1 (GetFarText 1180 0 @local209) 100 5 163) ; "I am the heart that does not beat; if cut, I bleed without blood,"
		)
		(1
			(localproc_1 (GetFarText 1180 4 @local209) 100 5 181) ; "silent, silent is my kingdom, green is the colour of my death."
			(localproc_1 (GetFarText 1180 3 @local209) 100 5 172) ; "High born, my touch is gentle, purest white is my lace,"
		)
		(2
			(localproc_1 (GetFarText 1180 8 @local209) 100 5 181) ; "my merest touch brings laughter."
			(localproc_1 (GetFarText 1180 7 @local209) 100 5 172) ; "upon me are sweet dreams dreamt,"
			(localproc_1 (GetFarText 1180 6 @local209) 100 5 163) ; "wisdom flows from me in other hands,"
			(localproc_1 (GetFarText 1180 5 @local209) 100 5 154) ; "I am the outstretched fingers that seize and hold the wind,"
		)
		(3
			(localproc_1 (GetFarText 1180 12 @local209) 100 5 181) ; "to build my treasure anew."
			(localproc_1 (GetFarText 1180 11 @local209) 100 5 172) ; "to seize my gold, by smoke I am overcome and robbed, then left"
			(localproc_1 (GetFarText 1180 10 @local209) 100 5 163) ; "stored in a labyrinth where no man walks, yet men come often"
			(localproc_1 (GetFarText 1180 9 @local209) 100 5 154) ; "Golden treasures I contain, guarded by hundreds and thousands,"
		)
		(4
			(localproc_1 (GetFarText 1180 16 @local209) 100 5 181) ; "'gainst ladies' cheeks I oft reside."
			(localproc_1 (GetFarText 1180 15 @local209) 100 5 172) ; "Cure me and I live beyond my death. Tough I am, yet soft beside,"
			(localproc_1 (GetFarText 1180 14 @local209) 100 5 163) ; "my first I serve in life, my second I serve in death,"
			(localproc_1 (GetFarText 1180 13 @local209) 100 5 154) ; "My first master has four legs, my second master has two legs,"
		)
		(5
			(localproc_1 (GetFarText 1180 18 @local209) 100 5 181) ; "yet my bite harms no one, and ladies delight in my touch."
			(localproc_1 (GetFarText 1180 17 @local209) 100 5 172) ; "Metal or bone I may be, many teeth I have and always bared,"
		)
		(6
			(localproc_1 (GetFarText 1180 22 @local209) 100 5 181) ; "then valued for my hardened gold."
			(localproc_1 (GetFarText 1180 21 @local209) 100 5 172) ; "I sleep in a cave until I grow old,"
			(localproc_1 (GetFarText 1180 20 @local209) 100 5 163) ; "I hang until half of me is gone,"
			(localproc_1 (GetFarText 1180 19 @local209) 100 5 154) ; "Not born but from a mother's body drawn,"
		)
		(7
			(localproc_1 (GetFarText 1180 26 @local209) 100 5 181) ; "yet lust for me keeps me locked away."
			(localproc_1 (GetFarText 1180 25 @local209) 100 5 172) ; "upon me, I have greatest power when given away,"
			(localproc_1 (GetFarText 1180 24 @local209) 100 5 163) ; "widely, men spill much blood over me, kings leave their imprint"
			(localproc_1 (GetFarText 1180 23 @local209) 100 5 154) ; "I am two-faced but bear only one face, I have no legs but travel"
		)
		(8
			(localproc_1 (GetFarText 1180 29 @local209) 100 5 181) ; "I say much, but have no words."
			(localproc_1 (GetFarText 1180 28 @local209) 100 5 172) ; "I am coloured, set in white, I fill with water and overflow,"
			(localproc_1 (GetFarText 1180 27 @local209) 100 5 163) ; "I am a window, I am a lamp, I am clouded, I am shining,"
		)
	)
	(= local735 0)
)

(procedure (localproc_1 param1 param2)
	(Display param1 param2 &rest 105 3 102 7 103 33 106 320)
)

(procedure (localproc_2 param1 param2)
	(Say param1 param2 &rest 67 -1 local738 70 local739 30 0)
)

(instance rm180 of Rm
	(properties
		picture 180
		style 100
		horizon 30
		north 220
		east 220
		south 220
		west 220
	)

	(method (init)
		(LoadMany rsVIEW 0 3 2 1 245 4 5 183 46 185 186 188)
		(super init:)
		(gEgo actions: egoDoVerb)
		(cond
			((== (gRgnMusic number:) 400)
				(gRgnMusic number: 400)
				(gEgo setScript: egoEnters 0 gEgoEdgeHit)
			)
			((and (IsFlag 42) (not (IsFlag 118)))
				(gRgnMusic number: 901)
				(gEgo setScript: firstEncounter)
			)
			(else
				(gRgnMusic number: 180)
				(gEgo setScript: egoEnters 0 gEgoEdgeHit)
			)
		)
		(gRgnMusic play:)
		(NormalEgo)
		(oakMan setPri: 7 init: stopUpd:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 189 156 178 160 181 170 176 173 169 171 160 166 136 166 140 161 177 153 169 149 84 149 60 157 50 165 30 165 30 160 50 155 68 144 43 152 31 152 39 142 80 141 107 129 0 129 0 0 319 0 319 132 242 132 247 156 248 165 225 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 300 167 277 166 266 154 251 145 255 137 277 138 319 139 319 159 300 158
					yourself:
				)
		)
		(AddToFeatures oakTree grove1 grove2)
		(if (and (< gDay 8) gForestSweepRoomCount)
			(= gForestSweepRoomCount 0)
		)
	)

	(method (dispose)
		(LoadMany 0 223 225 220)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			((and (< gForestSweepRoomCount 3) (IsFlag 110))
				(HandsOff)
				(ClearFlag 110)
				(oakHandSignCode doit:)
			)
			(local735
				(= local735 0)
				(localproc_0 local730)
			)
			((gEgo script:))
			((gEgo edgeHit:)
				(= temp0
					(switch (= gEgoEdgeHit (gEgo edgeHit:))
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(gEgo setScript: walkOut 0 temp0)
			)
			((== (gEgo onControl: 1) 2)
				(gCurRoom horizon: (gEgo y:))
				(gEgo setMotion: 0 setCycle: 0)
			)
			(else
				(super doit:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(1
						(gEgo
							posn: global104 238
							init:
							setMotion: PolyPath global104 185 self
						)
					)
					(2
						(if (< global105 165)
							(= global105 165)
						)
						(gEgo
							posn: -10 global105
							init:
							setMotion: PolyPath 26 global105 self
						)
					)
					(3
						(if (< global104 160)
							(gEgo
								posn: 25 152
								loop: 2
								init:
								setMotion: PolyPath 27 157 self
							)
						else
							(gEgo
								posn: 274 157
								loop: 2
								init:
								setMotion: PolyPath 272 161 self
							)
						)
					)
					(4
						(if (< global105 165)
							(= global105 165)
						)
						(gEgo
							posn: 330 global105
							init:
							setMotion: PolyPath 298 global105 self
						)
					)
					(else
						(gEgo posn: 160 175 loop: 2 init:)
						(= ticks 24)
					)
				)
			)
			(1
				(if (IsFlag 179)
					(ClearFlag 179)
					(Converse 1 @local174 @local201 0 self) ; "Thank the Blessed Virgin! The sprite's spell has worn off!"
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(if (IsFlag 129)
					(if (> gForestSweepRoomCount 3)
						(gTheIconBar disable: 5)
						(if (== gDisguiseNum 0) ; outlaw
							(NormalEgo 0 3 1)
							(gEgoHead view: 1)
							(gEgo
								normal: 1
								moveHead: 1
								xStep: 8
								yStep: 6
								setMotion: PolyPath 160 170
							)
						)
					)
					(proc750_2)
				)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch gEgoEdgeHit
					(3
						(= temp1 240)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(HandsOff)
				(if (!= gEgoEdgeHit 1)
					(gEgo
						ignoreActors: 1
						setMotion: PolyPath temp0 temp1 self
					)
				else
					(self cue:)
				)
			)
			(1
				(HandsOn)
				(cond
					((and (== gDay 7) (IsFlag 35) (IsFlag 34))
						(gCurRoom newRoom: 160)
					)
					(
						(and
							(== gDay 9)
							(IsFlag 36)
							(IsFlag 7)
							(IsFlag 113)
						)
						(gTheIconBar enable: 5)
						(gCurRoom newRoom: 160)
					)
					((and (== gDay 12) (IsFlag 38) (IsFlag 27))
						(gTheIconBar enable: 5)
						(gCurRoom newRoom: 160)
					)
					(else
						(gCurRoom newRoom: register)
					)
				)
			)
		)
	)
)

(instance overRidge of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 3 setCycle: 0 setMotion: 0)
			)
			(1
				(gCurRoom horizon: (gEgo y:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstEncounter of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= local741 1)
				(SetFlag 118)
				(sprite
					posn: 300 220
					setLoop: 1
					init:
					setCycle: Walk
					setMotion: MoveTo 75 164 self
				)
			)
			(1
				(sprite view: 188 setLoop: 2 setCel: 0)
				(gEgo posn: 300 230 init: setMotion: PolyPath 194 173 self)
			)
			(2
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 1) (- (gEgo y:) 1)
				)
				(sprite cycleSpeed: 12 setCycle: End self)
			)
			(3
				(Converse 1 @local0 @local183 0 self) ; "Old Man Oak"
			)
			(4
				(sprite
					view: 185
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath -20 176 self
				)
			)
			(5
				(sprite dispose:)
				(gRgnMusic number: 181 loop: -1 play:)
				(oakMan setCycle: End self)
			)
			(6
				(= local742 1)
				(oakMan stopUpd:)
				(Converse 2 @local7 @local192 0 1 1 self) ; "I heard my wood-child call. So, fleshling, you seek me. I am here."
			)
			(7
				(gEgo setScript: canWeTalkHere)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance canWeTalkHere of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(oakMan setCycle: Beg self)
			)
			(2
				(gRgnMusic number: 180 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance callVainly of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch gDisguiseNum
					(0 ; outlaw
						(= temp0 1)
					)
					(1 ; beggar
						(= temp0 7)
					)
					(4 ; yeoman
						(= temp0 6)
					)
					(6 ; fens monk
						(= temp0 8)
					)
					(5 ; abbey monk
						(= temp0 9)
					)
					(2 ; jewler (no rouge)
						(= temp0 4)
					)
					(else
						(= temp0 5)
					)
				)
				(Converse 1 @local43 temp0 1 self) ; "Green Man, spirit of Sherwood, come forth!"
			)
			(1
				(Say 1180 57 self) ; "I didn't think that would work."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance blowIt of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1180 63 self) ; "That was a waste of breath."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theRiddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local730 (Random 0 8))
				(if (or (!= (gRgnMusic number:) 181) (not (gRgnMusic handle:)))
					(gRgnMusic number: 181 loop: -1 play:)
				)
				(if (!= (oakMan cel:) 10)
					(oakMan cycleSpeed: 12 setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(Converse 2 @local169 @local192 0 1 1 self) ; "I'll risk the peril of your riddles if that is the only way I may earn your protection."
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(+ (gEgo x:) 1)
						(+ (gEgo y:) 1)
						self
				)
			)
			(3
				(oakMan loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(oakMan setCycle: Beg)
				(razzleDazzle init: play:)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(5
				(oakMan setLoop: 0 setCel: 10 stopUpd:)
				(sparkle dispose:)
				(gEgo
					view: 245
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					normal: 1
					moveHead: 1
					setCycle: CT 2 1 self
				)
			)
			(6
				(razzleDazzle dispose:)
				(Converse 2 @local47 @local192 0 1 1 self) ; "What are you do--!"
			)
			(7
				(Converse 1 @local54 @local192 0 self) ; "If you pass my riddles, I will restore you."
			)
			(8
				(= ticks 36)
			)
			(9
				(if (== local730 8)
					(= local730 0)
				else
					(++ local730)
				)
				(switch local730
					(0
						(= local739 260)
						(= local738 110)
						(= local736 1180)
						(= local737 30)
						(= local731 @local66)
					)
					(1
						(= local739 260)
						(= local738 120)
						(= local736 1180)
						(= local737 31)
						(= local731 @local70)
					)
					(2
						(= local739 260)
						(= local738 110)
						(= local736 1180)
						(= local737 32)
						(= local731 @local74)
					)
					(3
						(= local739 260)
						(= local738 100)
						(= local736 1180)
						(= local737 33)
						(= local731 @local78)
					)
					(4
						(= local739 260)
						(= local738 90)
						(= local736 1180)
						(= local737 34)
						(= local731 @local82)
					)
					(5
						(= local739 260)
						(= local738 100)
						(= local736 1180)
						(= local737 35)
						(= local731 @local86)
					)
					(6
						(= local739 260)
						(= local738 100)
						(= local736 1180)
						(= local737 36)
						(= local731 @local90)
					)
					(7
						(= local739 260)
						(= local738 100)
						(= local736 1180)
						(= local737 37)
						(= local731 @local94)
					)
					(8
						(= local739 260)
						(= local738 110)
						(= local736 1180)
						(= local737 38)
						(= local731 @local98)
					)
				)
				(fakeFrame init:)
				(fakeBust init:)
				(fakeMouth init:)
				(SetMessageColor 7)
				(localproc_2 local736 local737 self)
			)
			(10
				(SetMessageColor 0)
				(fakeFrame dispose:)
				(fakeBust dispose:)
				(fakeMouth setCycle: 0 dispose:)
				(= ticks 8)
			)
			(11
				(= ticks 6)
			)
			(12
				(= local735 1)
				(oakTree dispose:)
				(grove1 dispose:)
				(grove2 dispose:)
				((ScriptID 213) doit:) ; handCode
			)
			(13
				(AddToFeatures oakTree grove1 grove2)
				(switch local730
					(0
						(if (or (== global124 22) (== global124 23))
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(1
						(if
							(or
								(== global124 24)
								(== global124 25)
								(== global124 26)
							)
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(2
						(if (or (== global124 27) (== global124 28))
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(3
						(if
							(or
								(== global124 29)
								(== global124 30)
								(== global124 31)
								(== global124 32)
							)
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(4
						(if
							(or
								(== global124 33)
								(== global124 34)
								(== global124 35)
								(== global124 36)
								(== global124 37)
								(== global124 38)
								(== global124 39)
							)
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(5
						(if (or (== global124 40) (== global124 41))
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(6
						(if (or (== global124 42) (== global124 43))
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(7
						(if
							(or
								(== global124 44)
								(== global124 45)
								(== global124 46)
								(== global124 47)
								(== global124 48)
							)
							(= local732 1)
						else
							(= local732 0)
						)
					)
					(8
						(if
							(or
								(== global124 49)
								(== global124 50)
								(== global124 51)
								(== global124 52)
							)
							(= local732 1)
						else
							(= local732 0)
						)
					)
				)
				(if (== local732 0)
					(self changeState: 14)
				else
					(self changeState: 16)
				)
			)
			(14
				(switch local733
					(0
						(Converse 1 @local121 @local192 0 self) ; "Nay, that is not it. You may try again."
					)
					(1
						(Converse 1 @local125 @local192 0 self) ; "Nay, you are wrong again. Once more you may try before all is lost."
					)
					(2
						(HandsOn)
						(gEgo setScript: yourHistory)
					)
				)
				(++ local733)
			)
			(15
				(self changeState: 9)
			)
			(16
				(switch local734
					(0
						(Converse 1 @local129 @local192 0 self) ; "Aye, that is the word. Two more riddles you must answer. Here is the next."
					)
					(1
						(Converse 1 @local133 @local192 0 self) ; "Aye, you are right again. The final riddle is upon you."
					)
					(2
						(HandsOn)
						(gEgo setScript: yourAWinner)
					)
				)
				(++ local734)
			)
			(17
				(self changeState: 9)
			)
		)
	)
)

(instance oakWindow of Window ; UNUSED
	(properties)

	(method (init)
		(= color global187)
		(= back global176)
	)
)

(instance fakeFrame of View
	(properties
		x 43
		y 81
		view 805
		priority 14
		signal 16400
	)
)

(instance fakeBust of View
	(properties
		view 46
		loop 1
		priority 13
		signal 16400
	)

	(method (init)
		(self posn: (+ (fakeFrame x:) 2) (- (fakeFrame y:) 1))
		(super init:)
	)
)

(instance fakeMouth of Prop
	(properties
		view 46
		priority 14
		signal 16400
	)

	(method (init)
		(self posn: (fakeFrame x:) (- (fakeFrame y:) 13) setCycle: End self)
		(super init:)
	)

	(method (cue)
		(self cycleSpeed: (Random 3 18) setCycle: End self)
		(super cue:)
	)
)

(instance yourHistory of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local137 @local192 0 self) ; "You have failed!"
			)
			(1
				(if
					(and
						(!= (oakMan cel:) 10)
						(or
							(!= (gRgnMusic number:) 181)
							(not (gRgnMusic handle:))
						)
					)
					(gRgnMusic number: 181 loop: -1 play:)
				)
				(oakMan setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(oakMan stopUpd:)
				(razzleDazzle init: play:)
				(gEgo setCycle: End)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(3
				(sparkle dispose:)
				(oakMan setCycle: Beg self)
			)
			(4
				(razzleDazzle dispose:)
				(gRgnMusic number: 180 loop: -1 play:)
				(oakMan stopUpd:)
				(Converse 1 @local141 @local192 0 self) ; "What a fine young oak you make."
			)
			(5
				(EgoDead)
			)
		)
	)
)

(instance yourAWinner of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(oakMan setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(oakMan stopUpd:)
				(razzleDazzle init: play:)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(2
				(sparkle dispose:)
				(gEgo setLoop: 0 setCel: 2 setCycle: Beg self)
			)
			(3
				(razzleDazzle dispose:)
				(NormalEgo 4)
				(oakMan setCycle: Beg self)
			)
			(4
				(oakMan stopUpd:)
				(SetScore 200)
				(= ticks 6)
			)
			(5
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 2) (- (gEgo y:) 2) self
				)
			)
			(6
				(Converse 2 @local146 @local192 0 1 1 self) ; "My oath! It's good to feel my toes astride the earth again!"
			)
			(7
				(gRgnMusic number: 180 loop: -1 play:)
				(oakMan setLoop: 0 setCel: 5 setCycle: Beg self)
			)
			(8
				(oakMan stopUpd:)
				(NormalEgo)
				(gEgo cycleSpeed: 1)
				(HandsOn)
				(SetIcon 0)
				(= gTheCursor 0)
				(SetFlag 35)
				(self dispose:)
			)
		)
	)
)

(instance targetPractice of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(
						(or
							(<=
								(= temp0
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(oakMan x:)
										(oakMan y:)
									)
								)
								20
							)
							(> temp0 340)
						)
						(gEgo setLoop: 3)
					)
					((<= temp0 60)
						(gEgo setLoop: 6)
					)
					((<= temp0 100)
						(gEgo setLoop: 0)
					)
					((<= temp0 160)
						(gEgo setLoop: 4)
					)
					((<= temp0 200)
						(gEgo setLoop: 2)
					)
					((<= temp0 240)
						(gEgo setLoop: 5)
					)
					((<= temp0 290)
						(gEgo setLoop: 1)
					)
					((<= temp0 340)
						(gEgo setLoop: 7)
					)
				)
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(1
				(gEgo view: 5 setCel: 0 setCycle: End self)
			)
			(2
				(gSFX number: 906 loop: 1 play:)
				(NormalEgo)
				(= ticks 12)
			)
			(3
				(gSFX number: 908 play: self)
			)
			(4
				(if (!= (gRgnMusic number:) 181)
					(gRgnMusic number: 181 loop: -1 play:)
				)
				(if (!= (oakMan cel:) 10)
					(oakMan setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(Converse 1 @local156 @local192 0 self) ; "Rootless fleshling vermin! How dare you treat me like some common tree."
			)
			(6
				(oakMan setLoop: 1 setCel: 0 setCycle: End self)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 1) (+ (gEgo y:) 1)
				)
			)
			(7
				(oakMan stopUpd:)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(8
				(sparkle dispose:)
				(gEgo
					view: 245
					setLoop: 0
					cycleSpeed: 8
					cel: 0
					setCycle: End self
				)
			)
			(9
				(oakMan setCycle: Beg self)
			)
			(10
				(gRgnMusic number: 180 loop: 1 play:)
				(oakMan stopUpd:)
				(Converse 1 @local160 @local192 0 self) ; "Sink deep roots. Drink of sun and rain."
			)
			(11
				(EgoDead)
			)
		)
	)
)

(instance callOutOakMan of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo oakMan)
				(if (or (!= (gRgnMusic number:) 181) (not (gRgnMusic handle:)))
					(gRgnMusic number: 181 loop: -1 play:)
				)
				(if (!= (oakMan cel:) 10)
					(oakMan cycleSpeed: 18 setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(Converse 1 @local38 @local192 0 self) ; "You have returned with greater knowledge than when you left."
			)
			(2
				(HandsOn)
				(= seconds 5)
			)
			(3
				(oakMan setCycle: Beg self)
			)
			(4
				(gRgnMusic number: 180 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sprite of Actor
	(properties
		yStep 5
		view 185
		signal 16384
		xStep 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1180 39 1) ; "'Tis a wood sprite"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance oakMan of Prop
	(properties
		x 152
		y 131
		view 183
		priority 7
		signal 16
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (and (> cel 0) (IsFlag 118))
					(Say 1180 54 1) ; "The green Man has flesh of wood, skin of bark, hair of leaves."
				else
					(Say 1180 75 1) ; "This is the most ancient and sacred oak of the forest."
				)
			)
			(3 ; Do
				(if (or (== cel 0) (and (not (IsFlag 118)) (not (IsFlag 34))))
					(Say 1180 76 1) ; "This is a sacred oak. I'll not take bark, branch or leaf from this tree."
				else
					(Say 1180 55 1) ; "I don't think the Green Man would take kindly to being plucked."
				)
			)
			(5 ; Talk
				(cond
					((and (IsFlag 129) (> gForestSweepRoomCount 2))
						(Converse 1 @local179 1 0 self) ; "Simply talking to the Oak Tree will not save me!"
					)
					((and (not (IsFlag 118)) (not (IsFlag 34)))
						(Say 1180 107 1) ; "I cannot think of what to say to an oak tree."
					)
					((!= gDisguiseNum 0) ; outlaw
						(Say 1180 106 1) ; "It would seem the Green Man will not answer me in this guise."
					)
					((and (IsFlag 118) (not (IsFlag 34)) (== local729 0))
						(++ local729)
						(Converse 2 @local102 @local192 0 1 1) ; "Give me your riddles, Green Man. I will risk all."
					)
					((and (IsFlag 118) (not (IsFlag 34)) (== local729 1))
						(++ local729)
						(Converse 2 @local108 @local192 0 1 1) ; "Where do I find the Forest Priestess?"
					)
					((and (IsFlag 118) (not (IsFlag 34)) (== local729 2))
						(++ local729)
						(Converse 2 @local113 @local192 0 1 1) ; "Fleshling, I have no more to say to you until you know how to properly summon me."
						(if (== (gEgo script:) firstEncounter)
							(HandsOff)
						)
					)
					(
						(and
							(IsFlag 118)
							(IsFlag 34)
							(< gDay 8)
							(not local740)
							(== local742 0)
						)
						(= local740 1)
						(gEgo setScript: callOutOakMan)
					)
					((and (not (IsFlag 35)) (IsFlag 118) (IsFlag 34))
						(gEgo setScript: theRiddles)
					)
					(else
						(gEgo setScript: callVainly)
					)
				)
			)
			(10 ; Longbow
				(cond
					((IsFlag 35)
						(Say 1180 127 1) ; "I would be foolish indeed to fire an arrow at the very being who gave me his blessing!"
					)
					((== gDisguiseNum 0) ; outlaw
						(gEgo setScript: targetPractice)
					)
					(else
						(Say 1180 127 1) ; "I would be foolish indeed to fire an arrow at the very being who gave me his blessing!"
					)
				)
			)
			(4 ; Inventory
				(cond
					((and (> cel 0) (IsFlag 118))
						(switch invItem
							(2 ; halfHeart
								(Converse 1 @local20 @local192 0) ; "That is a powerful talisman you hold."
							)
							(10 ; fireRing
								(Converse 1 @local25 @local192 0) ; "Keep it away! I care not for its magic. Fire is no friend of mine."
							)
							(18 ; waterRing
								(Converse 1 @local61 @local192 0) ; "Ah, this ring has sweet magic.  Water is life and renewal."
							)
							(17 ; handScroll
								(if (IsFlag 34)
									(Converse 1 @local33 @local192 0) ; "You possess its secret now. The Druid Code is in your mind."
								else
									(Converse 1 @local29 @local192 0) ; "Only she who is the Forest Priestess may unlock the secrets of this scroll."
								)
							)
							(else
								(Converse 1 @local117 @local192 0) ; "It is of no value to me."
							)
						)
					)
					((== invItem 2) ; halfHeart
						(Say 1180 111 1) ; "Whatever the power of this emerald may be, it has no effect upon the Grandfather Oak."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance razzleDazzle of Sound
	(properties
		number 216
	)
)

(instance sparkle of Prop
	(properties
		view 245
		loop 1
		signal 16384
	)
)

(instance oakTree of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 211 144 185 148 176 143 189 138 183 127 130 127 67 149 68 135 79 139 125 110 134 65 31 39 16 0 319 0 319 73 221 78 194 99 196 114 208 113
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1180 75 0) ; "This is the most ancient and sacred oak of the forest."
			)
			(3 ; Do
				(Say 1180 76 0) ; "This is a sacred oak. I'll not take bark, branch or leaf from this tree."
			)
			(10 ; Longbow
				(cond
					((IsFlag 35)
						(Say 1180 127 1) ; "I would be foolish indeed to fire an arrow at the very being who gave me his blessing!"
					)
					((== gDisguiseNum 0) ; outlaw
						(gEgo setScript: targetPractice)
					)
					(else
						(Say 1180 127 1) ; "I would be foolish indeed to fire an arrow at the very being who gave me his blessing!"
					)
				)
			)
			(5 ; Talk
				(cond
					((and (not (IsFlag 118)) (not (IsFlag 34)))
						(Say 1180 107 1) ; "I cannot think of what to say to an oak tree."
					)
					((!= gDisguiseNum 0) ; outlaw
						(Say 1180 106 1) ; "It would seem the Green Man will not answer me in this guise."
					)
					((== (oakMan cel:) 0)
						(gEgo setScript: callVainly)
					)
					(else
						(Converse 1 @local165 @local192 0) ; "The Oak is but my shell. It cannot speak."
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 2) ; halfHeart
					(Say 1180 111 1) ; "Whatever the power of this emerald may be, it has no effect upon the Grandfather Oak."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grove1 of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 124 107 0 122 0 7 17 6 30 40 132 66
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1180 74 0) ; "All the trees within this grove are oaks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grove2 of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 119 267 120 212 106 197 99 222 79 319 75
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1180 74 0) ; "All the trees within this grove are oaks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oakHandSignCode of Code
	(properties)

	(method (doit)
		(cond
			((!= gDisguiseNum 0) ; outlaw
				(HandsOn)
				(Say 1180 106 1) ; "It would seem the Green Man will not answer me in this guise."
			)
			((== (gEgo script:) theRiddles)
				(theRiddles cue:)
			)
			((IsFlag 35)
				(HandsOn)
				(cond
					((== global124 7)
						(gEgo setScript: (ScriptID 223 0)) ; englishTreeName
					)
					((== global124 18)
						(gEgo setScript: (ScriptID 223 1)) ; notSweeping
					)
				)
			)
			((IsFlag 34)
				(HandsOn)
				(cond
					((== global124 7)
						(gEgo setScript: (ScriptID 223 0)) ; englishTreeName
					)
					((== global124 18)
						(gEgo setScript: (ScriptID 223 2)) ; notBlessed
					)
				)
			)
			(else
				(HandsOn)
			)
		)
	)
)

(instance egoDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(switch invItem
					(1 ; horn
						(gEgo setScript: (ScriptID 5 0)) ; blowArbitrator
						1
					)
					(5 ; pipe
						(if (== gDisguiseNum 6) ; fens monk
							(gEgo setScript: blowIt)
							1
						)
					)
				)
			)
		)
	)
)

